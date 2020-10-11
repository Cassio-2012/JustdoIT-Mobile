package com.example.just_do_it.cadastro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.just_do_it.R
import kotlinx.android.synthetic.main.activity_cadastro_one.*
import kotlinx.android.synthetic.main.activity_cadastro_one.et_senha
import kotlinx.android.synthetic.main.activity_cadastro_two.*

class CadastroTwoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_two)
    }

    fun sendToNext(component: View) {
        val nome = et_name.text.toString()
        val ocupacao = et_ocupacao.text.toString()
        val estado = et_estado.text.toString()

        if (nome.isEmpty() || ocupacao.isEmpty() || estado.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos corretamente"
                , Toast.LENGTH_SHORT).show()
            return
        }

        val cadastro3 = Intent(this, CadastroThreeActivity::class.java)

        startActivity(cadastro3)
    }

    fun backToPrevious(component: View) {

        val cadastro1 = Intent(this, CadastroOneActivity::class.java)

        startActivity(cadastro1)

    }
}