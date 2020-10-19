package com.example.just_do_it.view.evento

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.example.just_do_it.R
import com.example.just_do_it.cadastro.CadastroOneActivity

import com.example.just_do_it.service.model.EventoModel
import com.example.just_do_it.service.repository.EventoRepository
import com.example.just_do_it.view.GenericActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_cadastro_evento.*


class CadastroEventoActivity : GenericActivity() {
    private val repository = EventoRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_evento)
        start()
    }

    fun cancelarCadastro(v: View) {
        val intent = Intent(this, ListaEventosActivity::class.java)
        startActivity(intent)
    }

    fun validarCadastro(v: View) {
        val nomeEvento = nomeDeEventoInput.text.toString()
        val cep = cepInput.text.toString()
        val logradouro = logradouroInput.text.toString()
        val bairro = bairroInput.text.toString()
        val localidade = localidadeInput.text.toString()
        val uf = ufInput.text.toString()
        val dataEvento = dataInput.text.toString()
        val horaEvento = horaInput.text.toString()
        val descricaoEvento = descricaoInput.text.toString()
        val complemento = complementoInput.text.toString()


            if (nomeEvento.isEmpty()) {
                nomeDeEventoInput.error = "Nome do evento obrigatorio"
                nomeDeEventoInput.requestFocus()
            }
            if (cep.isEmpty()) {
                cepInput.error = getString(R.string.campo_obrigatorio)
                cepInput.requestFocus()

            }
            if (logradouro.isEmpty()) {
                logradouroInput.error = getString(R.string.campo_obrigatorio)
                logradouroInput.requestFocus()
                   }

            if (bairro.isEmpty()) {
                bairroInput.error = getString(R.string.campo_obrigatorio)
                bairroInput.requestFocus()
                 }
            if (localidade.isEmpty()) {
                localidadeInput.error = getString(R.string.campo_obrigatorio)
                localidadeInput.requestFocus()
                 }
            if (uf.isEmpty()) {
                ufInput.error = getString(R.string.campo_obrigatorio)
                ufInput.requestFocus()
                  }
            if (dataEvento.isEmpty()) {
                dataInput.error = getString(R.string.campo_obrigatorio)
                dataInput.requestFocus()
                  }
            if (horaEvento.isEmpty()) {
                horaInput.error = getString(R.string.campo_obrigatorio)
                horaInput.requestFocus()
                  }
            if (descricaoEvento.isEmpty()) {
                descricaoInput.error = getString(R.string.campo_obrigatorio)
                descricaoInput.requestFocus()
              }
            if (complemento.isEmpty()) {
                complementoInput.error = getString(R.string.campo_obrigatorio)
                complementoInput.requestFocus()
              }

        repository.cadastro(
            nomeEvento,
            cep,
            logradouro,
            complemento,
            bairro,
            localidade,
            uf,
            dataEvento,
            horaEvento,
            descricaoEvento)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        return super.onNavigationItemSelected(menuItem)
    }


}