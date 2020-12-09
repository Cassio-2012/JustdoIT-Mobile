package com.example.just_do_it.view

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.just_do_it.PostAdapter
import com.example.just_do_it.R
import com.example.just_do_it.login.Login_activity
import com.example.just_do_it.login.SessionManager
import com.example.just_do_it.service.model.PostModel
import com.example.just_do_it.service.model.UserModel

import com.example.just_do_it.service.repository.remote.PostService
import com.example.just_do_it.service.repository.remote.RetrofitClient


import com.example.just_do_it.service.repository.remote.LoginService

import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback

import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : GenericActivity() {
    val remote = RetrofitClient.createService(PostService::class.java)
    val reLogin = RetrofitClient.createService(LoginService::class.java)
    var usuarioLogado = UserModel()

    private lateinit var recyclerView: RecyclerView
    private val postAdapter = PostAdapter()

    var page = 1
    var isLoading = false

    var list = mutableListOf<PostModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        start()
        usuarioLogado = loadUser()
        var layoutManager = LinearLayoutManager(this)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = postAdapter
        val idUsuarioLog = usuarioLogado.id

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {

                if (dy > 3) {
                    val visibleItemCount = layoutManager.childCount
                    val pastVisibleItem = layoutManager.findFirstCompletelyVisibleItemPosition()
                    val total = postAdapter.itemCount
                    if (!isLoading) {
                        if ((visibleItemCount + pastVisibleItem) >= total) {
                            page++
                            carregarPost()
                        }
                    }

                }
                super.onScrolled(recyclerView, dx, dy)
            }
        })


        var usuario = UserModel()
        usuario.email = usuarioLogado.email
        usuario.senha = usuarioLogado.senha
        println("---------------------------${usuario.email},${usuario.senha}--------------------------")

//LOGIN
        val login = reLogin.loginUser(usuario)
        login.enqueue(object : Callback<UserModel> {
            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {

                if (response.code() == 200) {
//INITIAL
                    println("---------------------------${response.message()} ${response.code()}--------------------------")
                    val inicializarPost = remote.postLoadInitial()
                    inicializarPost.enqueue(object : Callback<Void> {
                        override fun onResponse(call: Call<Void>, response: Response<Void>) {
                            if (response.code() == 200) {
                                println("---------------------------${response.message()} ${response.code()}--------------------------")
//CARREGAR POST
                                progressbar.setVisibility(View.VISIBLE)
                                carregarPost()

                                Toast.makeText(
                                    this@MainActivity,
                                    "Inicializado",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                            } else {
                                Toast.makeText(
                                    this@MainActivity,
                                    "${response.code()}",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }

                        override fun onFailure(call: Call<Void>, t: Throwable) {
                            Toast.makeText(
                                this@MainActivity,
                                "Problema ao inicializar inicializar carregamento das publicações",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                    })


                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "${response.code()}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<UserModel>, t: Throwable) {
                Toast.makeText(
                    this@MainActivity,
                    "Problema ao logar ",
                    Toast.LENGTH_SHORT
                ).show()
            }

        })
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {

        if (menuItem.itemId == R.id.nav_logout) {

            val login = Intent(this, Login_activity::class.java)
            removeUser();
            startActivity(login)
            return false

        } else {
            return super.onNavigationItemSelected(menuItem)
        }
    }

    fun loadUser(): UserModel {
        val sessionManager = SessionManager()
        sessionManager.init(applicationContext)

        return sessionManager.loadUser()

    }

    fun removeUser() {
        val sessionManager = SessionManager()
        sessionManager.init(applicationContext)
        sessionManager.removeUser()

    }


    fun postar(v: View) {
        usuarioLogado = loadUser()
        val id = usuarioLogado.id
        val conteudoTextoInput = conteudoTexto.text.toString()

        val autorPost = usuarioLogado.nome
        val fotoPerfilAutor = usuarioLogado.photo
        var datePost = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault()).toString()


        val post = PostModel(
            null,
            id,
            null,
            null,
            null,
            autorPost,
            conteudoTextoInput,
            fotoPerfilAutor,
            datePost,
            null
        )
        val postar = remote.postNew(post, id)

        postar.enqueue(object : retrofit2.Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.code() == 200) {
                    Toast.makeText(this@MainActivity, "Publicado", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "Não foi possivel publicar",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Não foi possivel publicar", Toast.LENGTH_SHORT)
                    .show()
            }

        })
    }

    fun carregarPost() {
        progressbar.setVisibility(View.VISIBLE)
        val carregarPost = remote.postLoadFeed()
     //   val carregarPost = remote.postLoadFeedAll(usuarioLogado.id)
        carregarPost.enqueue(object : Callback<List<PostModel>> {
            override fun onResponse(
                call: Call<List<PostModel>>,
                response: Response<List<PostModel>>
            ) {
                println("----------------response  post--------------------------"
                        + response.body()?.size)
                response.body()?.let { postAdapter.updateItems(it) }
                recyclerView.setVisibility(View.VISIBLE)
                Thread.sleep(20000)
                progressbar.setVisibility(View.GONE)


            }

            override fun onFailure(
                call: Call<List<PostModel>>,
                t: Throwable
            ) {
                println("---------------------------${t.message}, ${t.printStackTrace()}--------------------------")
                Toast.makeText(
                    this@MainActivity,
                    "Problema ao carregar as publicações ",
                    Toast.LENGTH_SHORT
                ).show()

            }

        })

    }

}


