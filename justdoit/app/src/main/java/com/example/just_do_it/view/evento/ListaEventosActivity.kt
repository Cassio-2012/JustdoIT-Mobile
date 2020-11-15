package com.example.just_do_it.view.evento

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Bundle
import android.util.Base64
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.example.just_do_it.R
import com.example.just_do_it.login.Login_activity
import com.example.just_do_it.login.SessionManager
import com.example.just_do_it.service.model.EventoModel
import com.example.just_do_it.service.repository.remote.EventoService
import com.example.just_do_it.service.repository.remote.RetrofitClient
import com.example.just_do_it.view.GenericActivity
import com.example.vamos_lucrar.utils.MyAdapter
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ListaEventosActivity : GenericActivity() {

    val sessionManager = SessionManager()

    val remote = RetrofitClient.createService(EventoService::class.java)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_eventos)
        start()
//        val usuarioLogado = loadUser()
        val listaEventos = remote.listarEventos()
        listaEventos.enqueue(object : Callback<List<EventoModel>> {
            override fun onResponse(
                call: Call<List<EventoModel>>,
                response: Response<List<EventoModel>>
            ) {

                val listView = findViewById<ListView>(R.id.listView)
                val list = mutableListOf<EventoModel>()

                response.body()?.forEach {
                    list.add(
                        EventoModel(
                            it.codigo,
                            it.nome,
                            it.cep,
                            it.logradouro,
                            it.complemento,
                            it.bairro,
                            it.localidade,
                            it.uf,
                            it.dataEvento,
                            it.horario,
                            it.descricao

                        )
                    )
                    listView.adapter = MyAdapter(this@ListaEventosActivity, R.layout.row, list)

                }
            }


            override fun onFailure(call: Call<List<EventoModel>>, t: Throwable) {
                Toast.makeText(applicationContext, "erro ao listar contatos ${t.message}", Toast.LENGTH_SHORT)
                    .show()
            }
        })



    }

    override fun onBackPressed() {
        super.onBackPressed()


    }
//
//    fun loadUser(): UserModel {
//
//        sessionManager.init(applicationContext)
//
//        return sessionManager.loadUser()
//       if(!super.onNavigationItemSelected(menuItem)) {
//
//            val login = Intent(this, Login_activity::class.java)
//            removeUser();
//            startActivity(login)
//        }
//    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {

        if(menuItem.itemId == R.id.nav_logout) {

            val login = Intent(this, Login_activity::class.java)
            removeUser();
            startActivity(login)
            return false

        }
        if(menuItem.itemId == R.id.nav_dark) {
            chooseThemeDialog()
            return false
        }
        else {
            return super.onNavigationItemSelected(menuItem)
        }
    }

    fun chooseThemeDialog() {

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Chose the Theme")
        val styles = arrayOf("Light","Dark")
        val checkedItem = 0

        builder.setSingleChoiceItems(styles, checkedItem) { dialog, which ->

            val linear = findViewById<LinearLayout>(R.id.body)
            val tv = findViewById<TextView>(R.id.titulo)
            val row = findViewById<LinearLayout>(R.id.ll_row)

            when (which) {
                0 -> {


                    linear.setBackgroundColor(Color.parseColor("#ffffff"))
                    row.setBackgroundColor(Color.parseColor("#ffffff"))
                    tv.setTextColor(Color.parseColor("#000000"))
                    dialog.dismiss()
                }
                1 -> {

                    linear.setBackgroundColor(Color.parseColor("#000000"))
                    row.setBackgroundColor(Color.parseColor("#000000"))
                    tv.setTextColor(Color.parseColor("#A9A9A9"))
                    dialog.dismiss()
                }

            }
        }

        val dialog = builder.create()
        dialog.show()
    }


    fun removeUser() {

        sessionManager.init(applicationContext)

        sessionManager.removeUser()

    }

//    fun testeImagem() {
//
//        val manager = SessionManager()
//        manager.init(getApplicationContext())
//
//        val photo: String? = manager.read("photo", null)
//        val pureBase64Encoded: String? = photo?.substring(photo.indexOf(",")  + 1);
//
//        val decodedBytes: ByteArray = Base64.decode(pureBase64Encoded, Base64.DEFAULT)
//
//        val decodedBitmap: Bitmap =
//            BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
//
//
//
//    }





}