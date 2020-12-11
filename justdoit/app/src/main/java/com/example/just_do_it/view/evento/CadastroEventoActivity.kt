package com.example.just_do_it.view.evento

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*
import com.example.just_do_it.R
import com.example.just_do_it.login.Login_activity
import com.example.just_do_it.login.SessionManager
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
    var usuario = UserModel()
    val sessionManager = SessionManager();

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_evento)
        usuario = loadUser()
        start()
    }

    override fun onResume() {
        super.onResume()
        checkDark()
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
                descricaoEvento,
                convidados = null,
                adm = usuario.id
            )

            val cadEvento = remote.postEvento(evento, usuario.id)
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

        sessionManager.init(applicationContext)

        return sessionManager.loadUser()

    }

    fun removeUser() {

        sessionManager.init(applicationContext)

        sessionManager.removeUser()

    }

    fun chooseThemeDialog() {

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Chose the Theme")
        val styles = arrayOf("Light","Dark")
        var checkedItem = 0
        if (sessionManager.checkDark()) {
            checkedItem = 1

        }

        builder.setSingleChoiceItems(styles, checkedItem) { dialog, which ->

            sessionManager.init(getApplicationContext())

            when (which) {
                0 -> {

                    changeLight()
                    sessionManager.rmDark()
                    dialog.dismiss()

                }
                1 -> {

                    changeDark()
                    sessionManager.setDark()
                    dialog.dismiss()
                }

            }
        }

        val dialog = builder.create()
        dialog.show()
    }

    fun changeLight() {


        val cadastroEvento = Intent(this, CadastroEventoActivity::class.java)


        startActivity(cadastroEvento)


    }

    fun changeDark() {


        var body = findViewById<ScrollView>(R.id.cadastro_layout)
        var tv_titulo = findViewById<TextView>(R.id.titulo_cadastro)
        var nomeEv = findViewById<TextView>(R.id.nomeDeEventoTxt)
        var nomeInput = findViewById<EditText>(R.id.nomeDeEventoInput)
        var cepTXT = findViewById<TextView>(R.id.cepTxt)
        var cepINPUT = findViewById<EditText>(R.id.cepInput)
//        var ll_posCep = findViewById<LinearLayout>(R.id.posCep)
        var logradouroTXT = findViewById<TextView>(R.id.logradouroTxt)
        var logradouroINPUT = findViewById<TextView>(R.id.logradouroInput)
        var complementoTXT = findViewById<TextView>(R.id.complementoTxt)
        var complementoINPUT = findViewById<EditText>(R.id.complementoInput)
        var bairroTXT = findViewById<TextView>(R.id.bairroTxt)
        var bairroINPUT = findViewById<TextView>(R.id.bairroInput)
        var localidadeTXT = findViewById<TextView>(R.id.localidadeTxt)
        var localidadeINPUT = findViewById<TextView>(R.id.localidadeInput)
        var ufTXT = findViewById<TextView>(R.id.ufTxt)
        var ufINPUT = findViewById<TextView>(R.id.ufInput)
//        var data_ll = findViewById<LinearLayout>(R.id.dataHoraInput)
        var dataTXT = findViewById<TextView>(R.id.dataTxt)
        var dataINPUT = findViewById<EditText>(R.id.dataInput)
//        var hora_ll = findViewById<LinearLayout>(R.id.campoHora)
        var horaTXT = findViewById<TextView>(R.id.horaTxt)
        var horaINPUT = findViewById<TextView>(R.id.horaInput)
        var descTXT = findViewById<TextView>(R.id.descricaoTxt)
        var descINPUT = findViewById<TextView>(R.id.descricaoInput)



        body.setBackgroundColor(Color.parseColor("#000000"))
        tv_titulo.setTextColor(Color.parseColor("#A9A9A9"))
        nomeEv.setTextColor(Color.parseColor("#A9A9A9"))
        nomeInput.setTextColor(Color.parseColor("#000000"))
//        campoData.setBackgroundColor(Color.parseColor("#A9A9A9"))

        nomeInput.setBackgroundColor(Color.parseColor("#A9A9A9"))
        cepTXT.setTextColor(Color.parseColor("#ffffff"))
        cepINPUT.setBackgroundColor(Color.parseColor("#A9A9A9"))
        logradouroTXT.setTextColor(Color.parseColor("#ffffff"))
        logradouroINPUT.setBackgroundColor(Color.parseColor("#A9A9A9"))
        complementoTXT.setTextColor(Color.parseColor("#ffffff"))
        complementoINPUT.setBackgroundColor(Color.parseColor("#A9A9A9"))
        bairroTXT.setTextColor(Color.parseColor("#ffffff"))
        bairroINPUT.setBackgroundColor(Color.parseColor("#A9A9A9"))
        localidadeTXT.setTextColor(Color.parseColor("#ffffff"))
        localidadeINPUT.setBackgroundColor(Color.parseColor("#A9A9A9"))
        ufTXT.setTextColor(Color.parseColor("#ffffff"))
        ufINPUT.setBackgroundColor(Color.parseColor("#A9A9A9"))
        dataTXT.setTextColor(Color.parseColor("#ffffff"))
        dataINPUT.setBackgroundColor(Color.parseColor("#A9A9A9"))
        horaTXT.setTextColor(Color.parseColor("#ffffff"))
        horaINPUT.setBackgroundColor(Color.parseColor("#A9A9A9"))
        descTXT.setTextColor(Color.parseColor("#ffffff"))
        descINPUT.setBackgroundColor(Color.parseColor("#A9A9A9"))


    }

    fun checkDark() {
        sessionManager.init(getApplicationContext())

        val isdark = sessionManager.checkDark()

        if (isdark) {
            changeDark()
        }

    }

}