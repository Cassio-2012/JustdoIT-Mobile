package com.example.just_do_it.view.evento

import android.content.Intent

import android.os.Bundle

import android.view.MenuItem
import android.view.View

import android.widget.Toast
import com.example.just_do_it.R
import com.example.just_do_it.login.Login_activity
import com.example.just_do_it.login.SessionManager
import com.example.just_do_it.service.model.ConvidadoModel
import com.example.just_do_it.service.model.EventoModel
import com.example.just_do_it.service.model.UserModel
import com.example.just_do_it.service.repository.remote.EventoService
import com.example.just_do_it.service.repository.remote.RetrofitClient
import com.example.just_do_it.utils.SharedPreferences
import com.example.just_do_it.view.GenericActivity

import kotlinx.android.synthetic.main.activity_detalhes_evento.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class DetalhesEventoActivity : GenericActivity() {
    val remote = RetrofitClient.createService(EventoService::class.java)
    val sessionManager = SessionManager()
    var usuarioLogado = UserModel()
    var eventoConsulta: EventoModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_evento)

        usuarioLogado = loadUser()
        start()

        var codigo = SharedPreferences(this).getId("codigo")
        val evento = remote.pesquisarEvento(codigo)


        evento.enqueue(object : Callback<EventoModel> {
            override fun onResponse(
                call: Call<EventoModel>,
                response: Response<EventoModel>
            ) {

                val evento = response.body()
                tituloEventoDetalhes.text = evento?.nome
                dataHoraEventoDetalhes.text =
                    "Data: ${evento?.dataEvento} - Hora: ${evento?.horario}"
                enderecoEventoDetalhes.text =
                    "Endereço : ${evento?.logradouro} ${evento?.bairro} ${evento?.localidade} ${evento?.uf}"
                detalhesEventoDetalhes.text = evento?.descricao

                eventoConsulta = evento

                if (usuarioLogado.id == evento?.adm) {
                    cadastrarBotao.visibility = View.GONE
                }
                if (evento?.adm != usuarioLogado.id) {
                    deletarEvento.visibility = View.GONE
                }
                if (evento?.adm != usuarioLogado.id) {
                    listaParticipantes.visibility = View.GONE
                }
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

        sessionManager.init(applicationContext)

        return sessionManager.loadUser()

    }

    fun removeUser() {

        sessionManager.init(applicationContext)

        sessionManager.removeUser()

    }

    fun deletarEvento(v: View) {
        var codigo = SharedPreferences(this).getId("codigo").toInt()
        val deletarContato = remote.deleteEvento(codigo,usuarioLogado.id)

        deletarContato.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {

                Toast.makeText(this@DetalhesEventoActivity, "${response.body()} ${response.code()}", Toast.LENGTH_SHORT).show()
                if (response.code() == 403) {
                    Toast.makeText(
                        this@DetalhesEventoActivity, "Você não é o administrador deste evento.",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                if (response.code() == 200) {
                    Toast.makeText(
                        this@DetalhesEventoActivity, "Evento deletado com sucesso .",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(
                    this@DetalhesEventoActivity, "Erro ao deletar",
                    Toast.LENGTH_SHORT
                ).show()
                return
            }

        })


    }

    fun participarEvento(v: View) {
        val id = usuarioLogado.id
        var codigo = SharedPreferences(this).getId("codigo")
        if (eventoConsulta?.adm == id) {
            Toast.makeText(
                this,
                "Você não pode participar desse evento por ser o administrados",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            val convidado = ConvidadoModel(null, usuarioLogado.nome, usuarioLogado.email, null)
            val cadastrarConvidado = remote.postConvidado(codigo, convidado, id)

            cadastrarConvidado.enqueue(object : Callback<ConvidadoModel> {
                override fun onResponse(
                    call: Call<ConvidadoModel>,
                    response: Response<ConvidadoModel>
                ) {
                    if (response.code() == 200) {
                        Toast.makeText(
                            this@DetalhesEventoActivity,
                            "Presença marcada no evento",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        Toast.makeText(
                            this@DetalhesEventoActivity,
                            "Problemas ao marcar presença ao evento",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onFailure(call: Call<ConvidadoModel>, t: Throwable) {
                    Toast.makeText(
                        this@DetalhesEventoActivity,
                        "Falha ao marcar presença ao evento",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            })
        }
    }

    fun listarParticipantes(v: View) {
        val detalhes = Intent(this, ListaParticipantesActivity::class.java)
        startActivity(detalhes)

    }


}