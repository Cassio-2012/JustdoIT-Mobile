package com.example.just_do_it.view.evento

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ListView
import android.widget.Toast
import com.example.just_do_it.R
import com.example.just_do_it.login.Login_activity
import com.example.just_do_it.login.SessionManager
import com.example.just_do_it.service.model.EventoModel
import com.example.just_do_it.service.model.UserModel
import com.example.just_do_it.service.repository.remote.EventoService
import com.example.just_do_it.service.repository.remote.RetrofitClient
import com.example.just_do_it.view.GenericActivity
import com.example.vamos_lucrar.utils.MyAdapter
import com.example.vamos_lucrar.utils.SharedPreferences
import kotlinx.android.synthetic.main.activity_detalhes_evento.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetalhesEventoActivity : GenericActivity() {
    val remote = RetrofitClient.createService(EventoService::class.java)
    val sessionManager = SessionManager()
    var usuarioLogado = UserModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_evento)
        usuarioLogado = loadUser()
        start()

        val codigo = SharedPreferences(this).getId("codigo")

        val evento = remote.pesquisarEvento(codigo)
        evento.enqueue(object : Callback<EventoModel> {
            override fun onResponse(
                call: Call<EventoModel>,
                response: Response<EventoModel>
            ) {


               val evento = response.body()

                          tituloEventoDetalhes.text = evento?.nome
                dataHoraEventoDetalhes.text = "Data: ${evento?.dataEvento} - Hora: ${evento?.horario}"
                enderecoEventoDetalhes.text = "Endereço : ${evento?.logradouro} ${evento?.bairro} ${evento?.localidade} ${evento?.uf}"
                detalhesEventoDetalhes.text = evento?.descricao
                }

            override fun onFailure(call: Call<EventoModel>, t: Throwable) {
                Toast.makeText(applicationContext, "erro ao listar o evento", Toast.LENGTH_SHORT)
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

        }else {
            return super.onNavigationItemSelected(menuItem)
        }
    }


    fun loadUser(): UserModel {

        sessionManager.init(applicationContext)

        return sessionManager.loadUser()

    }

    fun removeUser() {

        sessionManager.init(applicationContext)

        sessionManager.removeUser()

    }

}