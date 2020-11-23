package com.example.just_do_it.view


import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.util.Base64
import android.view.MenuItem
import android.view.View
import android.widget.ListView
import android.widget.Toast
import com.example.just_do_it.R
import com.example.just_do_it.login.Login_activity
import com.example.just_do_it.login.SessionManager

import com.example.just_do_it.service.model.EventoModel
import com.example.just_do_it.service.model.PostModel
import com.example.just_do_it.service.model.UserModel

import com.example.just_do_it.service.repository.remote.EventoService
import com.example.just_do_it.service.repository.remote.PostService
import com.example.just_do_it.service.repository.remote.RetrofitClient
import com.example.just_do_it.utils.MyAdapterPublicacoes

import com.google.android.gms.common.util.Base64Utils.decode
import kotlinx.android.synthetic.main.activity_cadastro_evento.*
import kotlinx.android.synthetic.main.activity_detalhes_evento.*
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat

import java.util.*


class MainActivity : GenericActivity() {
    val remote = RetrofitClient.createService(PostService::class.java)
    var usuarioLogado = UserModel()
    val sessionManager = SessionManager()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        start()
        usuarioLogado = loadUser()
        val idUsuarioLog = usuarioLogado.id
        if (idUsuarioLog != null){

            val inicializarPost = remote.postLoadInitial(idUsuarioLog)

            inicializarPost.enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    Toast.makeText(this@MainActivity, "Inicializado", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(
                        this@MainActivity,
                        "Problema ao inicializar inicializar carregamento das publicações",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            })
        }


        val carregarPost = remote.postLoadFeedAll()
        carregarPost.enqueue(object : Callback<List<PostModel>> {
            override fun onResponse(
                call: Call<List<PostModel>>,
                response: Response<List<PostModel>>
            ) {
                val listView = findViewById<ListView>(R.id.listView)
                val list = mutableListOf<PostModel>()
                Toast.makeText(
                    this@MainActivity,
                    "${idUsuarioLog}, ${response.body()}, ${response.code()}",
                    Toast.LENGTH_SHORT
                ).show()
                response.body()?.forEach {
                    list.add(
                        PostModel(
                            it.id,
                            it.id_user,
                            it.reacao,
                            it.total,
                            it.isImg,
                            it.nome,
                            it.conteudo,
                            it.imagem,
                            it.data,
                            it.img_conteudo
                        )
                    )
                    listView.adapter =
                        MyAdapterPublicacoes(this@MainActivity, R.layout.row_publicacoes, list)
                }
            }

            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                Toast.makeText(
                    this@MainActivity,
                    "Problema ao carregar as publicações ",
                    Toast.LENGTH_SHORT
                ).show()
                println("---------------------------${t.message}, ${t.printStackTrace()}--------------------------")
            }

        })


    }
    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {

        if(menuItem.itemId == R.id.nav_logout) {

            val login = Intent(this, Login_activity::class.java)
            removeUser();
            startActivity(login)
            return false

        }else {
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


        val post =  PostModel(
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
        val postar = remote.postNew(post,id)

        postar.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                Toast.makeText(this@MainActivity, "Publicado", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Não foi possivel publicar", Toast.LENGTH_SHORT).show()
            }

        })
        }

    }


