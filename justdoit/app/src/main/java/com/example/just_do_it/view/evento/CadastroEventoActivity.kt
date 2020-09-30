package com.example.just_do_it.view.evento

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.just_do_it.R
import kotlinx.android.synthetic.main.activity_cadastro_evento.*


class CadastroEventoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_evento)
    }
    fun cancelarCadastro(v:View){
        val intent = Intent(this, ListaEventosActivity::class.java)
        startActivity(intent)
    }
    fun validarCadastro(v:View){
        val nomeEvento = nomeDeEventoInput
        val enderecoEvento = enderecoInput
        val dataEvento = dataInput
        val horaEvento = horainput
        val descricaoEvento = descricaoInput

        if (nomeEvento.text.toString().length == 0 &&
            enderecoEvento.text.toString().length == 0 &&
            dataEvento.text.toString().length == 0 &&
            horaEvento.text.toString().length == 0 &&
            descricaoEvento.text.toString().length == 0){
            Toast.makeText(
                this,
                "Todos os campos estão vazios",
                Toast.LENGTH_LONG
            ).show()
        }else{
            val intent = Intent(this,
                DetalhesEventoActivity::class.java)
            startActivity(intent)

        }
    }
}