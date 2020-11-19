package com.example.just_do_it.view.evento

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.example.just_do_it.R
import com.example.just_do_it.login.Login_activity
import com.example.just_do_it.login.SessionManager
import com.example.just_do_it.service.model.ConvidadoModel
import com.example.just_do_it.service.model.EventoModel
import com.example.just_do_it.service.repository.remote.EventoService
import com.example.just_do_it.service.repository.remote.RetrofitClient
import com.example.just_do_it.view.GenericActivity
import com.example.vamos_lucrar.utils.MyAdapter
import com.example.vamos_lucrar.utils.MyAdapterConvidado
import com.example.vamos_lucrar.utils.SharedPreferences
import kotlinx.android.synthetic.main.activity_detalhes_evento.*
import kotlinx.android.synthetic.main.activity_lista_participantes.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListaParticipantesActivity : GenericActivity()  {
    val sessionManager = SessionManager()
    val remote = RetrofitClient.createService(EventoService::class.java)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_participantes)
        start()

        var codigo = SharedPreferences(this).getId("codigo")
        val listaConvidados = remote.listarConvidados(codigo)
        listaConvidados.enqueue(object : Callback<List<ConvidadoModel>> {
            override fun onResponse(
                call: Call<List<ConvidadoModel>>,
                response: Response<List<ConvidadoModel>>
            ) {
            if(response.body().isNullOrEmpty() ){

              vazio.visibility = View.VISIBLE

            }else{
                val listView = findViewById<ListView>(R.id.listView)
                val list = mutableListOf<ConvidadoModel>()

                response.body()?.forEach {
                    list.add(
                        ConvidadoModel(
                            it.id,
                            it.nomeConvidado,
                            it.email
                        )
                    )
                    listView.adapter = MyAdapterConvidado(
                        this@ListaParticipantesActivity,
                        R.layout.row_convidados,
                        list
                    )

                }
            }}


            override fun onFailure(call: Call<List<ConvidadoModel>>, t: Throwable) {
                Toast.makeText(
                    applicationContext,
                    "erro ao listar contatos ${t.message}",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        })



    }

    override fun onBackPressed() {
        super.onBackPressed()


    }

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
}