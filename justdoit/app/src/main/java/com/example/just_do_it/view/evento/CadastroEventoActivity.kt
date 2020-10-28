package com.example.just_do_it.view.evento

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.just_do_it.R
import com.example.just_do_it.service.model.Cep

import com.example.just_do_it.service.model.EventoModel
import com.example.just_do_it.service.model.UserModel
import com.example.just_do_it.service.repository.remote.EventoService
import com.example.just_do_it.service.repository.remote.RetrofitClient
import com.example.just_do_it.view.GenericActivity
import kotlinx.android.synthetic.main.activity_cadastro_evento.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CadastroEventoActivity : GenericActivity() {
 val remote  = RetrofitClient.createService(EventoService::class.java)
    var idUser: Int? = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_evento)

        idUser = intent.extras?.getInt("id").toString().toInt();

        start()
    }

    fun cancelarCadastro(v: View) {
        val intent = Intent(this, ListaEventosActivity::class.java)
        startActivity(intent)
    }

    fun validarCadastro(v: View) {
        val nomeEvento = nomeDeEventoInput.text.toString()
        val cep = cepInput.text.toString()
        var logradouro = logradouroInput.text.toString()
        var bairro = bairroInput.text.toString()
        var localidade = localidadeInput.text.toString()
        var uf = ufInput.text.toString()
        val dataEvento = dataInput.text.toString()
        val horaEvento = horaInput.text.toString()
        val descricaoEvento = descricaoInput.text.toString()
        val complemento = complementoInput.text.toString()

        var validacaoInput = 10

            if (nomeEvento.isEmpty()) {
                nomeDeEventoInput.error = "Nome do evento obrigatorio"
                nomeDeEventoInput.requestFocus()
                validacaoInput--
            }
            if (cep.isEmpty()) {
                cepInput.error = getString(R.string.campo_obrigatorio)
                cepInput.requestFocus()
                validacaoInput--
            }
            if (logradouro.isEmpty()) {
                logradouroInput.error = getString(R.string.campo_obrigatorio)
                logradouroInput.requestFocus()
                validacaoInput--
                   }

            if (bairro.isEmpty()) {
                bairroInput.error = getString(R.string.campo_obrigatorio)
                bairroInput.requestFocus()
                validacaoInput--
                 }
            if (localidade.isEmpty()) {
                localidadeInput.error = getString(R.string.campo_obrigatorio)
                localidadeInput.requestFocus()
                validacaoInput--
                 }
            if (uf.isEmpty()) {
                ufInput.error = getString(R.string.campo_obrigatorio)
                ufInput.requestFocus()
                validacaoInput--
                  }
            if (dataEvento.isEmpty()) {
                dataInput.error = getString(R.string.campo_obrigatorio)
                dataInput.requestFocus()
                validacaoInput--
                  }
            if (horaEvento.isEmpty()) {
                horaInput.error = getString(R.string.campo_obrigatorio)
                horaInput.requestFocus()
                validacaoInput--
                  }
            if (descricaoEvento.isEmpty()) {
                descricaoInput.error = getString(R.string.campo_obrigatorio)
                descricaoInput.requestFocus()
                validacaoInput--
              }
            if (complemento.isEmpty()) {
                complementoInput.error = getString(R.string.campo_obrigatorio)
                complementoInput.requestFocus()
                validacaoInput--
            }
        if(validacaoInput == 10){

            val evento = EventoModel(
                null,
                nomeEvento,
                cep,
                logradouro,
                complemento,
                bairro,
                localidade,
                uf,
                dataEvento,
                horaEvento,
                descricaoEvento

            )

            val cadEvento = remote.postEvento(evento, idUser)
        cadEvento.enqueue(object : Callback<EventoModel> {
            override fun onResponse(call: Call<EventoModel>, response: Response<EventoModel>) {

                Toast.makeText(this@CadastroEventoActivity, "Evento cadastrado ${response.hashCode()}", Toast.LENGTH_LONG)
                    .show()
            }

            override fun onFailure(call: Call<EventoModel>, t: Throwable) {
                Toast.makeText(this@CadastroEventoActivity, "Erro ao cadastrar evento", Toast.LENGTH_SHORT).show()
            }

        })

        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        val usuarioLogado = loadUser()
        return super.onNavigationItemSelectedAdapt(menuItem, usuarioLogado)
    }

fun pesquisarCep(v: View){
    if(cepInput.text.isEmpty() ){
            cepInput.error = getString(R.string.campo_obrigatorio)
            cepInput.requestFocus()

    }else {
        val cep = remote.getCep(cepInput.text.toString())
        cep.enqueue(object : Callback<Cep> {
            override fun onResponse(call: Call<Cep>, response: Response<Cep>) {
                val respostaCep = response.body()
                if (respostaCep != null) {
                    logradouroInput.text = respostaCep.logradouro
                    bairroInput.text = respostaCep.bairro
                    localidadeInput.text = respostaCep.localidade
                    ufInput.text = respostaCep.uf
                    botaoBuscarCep.visibility = View.GONE
                    posCep.visibility = View.VISIBLE
                }

            }

            override fun onFailure(call: Call<Cep>, t: Throwable) {
                Toast.makeText(
                    this@CadastroEventoActivity,
                    "Cep não encontrado",
                    Toast.LENGTH_SHORT
                ).show()
            }

        })
    }
}

    fun loadUser(): UserModel {

        val userID = intent.extras?.getInt("id")
        val userNome = intent.extras?.getString("nome")
        val userEmail = intent.extras?.getString("email")
//        val userPhoto = intent.extras?.getString("photo")

        val usuarioLogado = UserModel()

        usuarioLogado.id = userID
        usuarioLogado.nome = userNome
        usuarioLogado.email = userEmail
//        usuarioLogado.photo = userPhoto
//

        return usuarioLogado

    }

}