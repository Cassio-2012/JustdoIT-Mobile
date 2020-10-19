package com.example.just_do_it.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.just_do_it.R
import kotlinx.android.synthetic.main.activity_cadastro_evento.*
import kotlinx.android.synthetic.main.activity_cadastro_one.*
import kotlinx.android.synthetic.main.activity_cadastro_one.et_email
import kotlinx.android.synthetic.main.activity_cadastro_one.et_senha
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun validarLogin(v:View){
        val email = et_email.text.toString()
        val senha = et_senha.text.toString()

        if (email.isEmpty()) {
            et_email.error = "Nome do evento obrigatorio"
            et_email.requestFocus()

        }
        if (senha.isEmpty()) {
            et_senha.error = getString(R.string.campo_obrigatorio)
            et_senha.requestFocus()

        }
    }

}