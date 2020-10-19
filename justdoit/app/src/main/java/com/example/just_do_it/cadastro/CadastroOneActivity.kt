package com.example.just_do_it.cadastro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.just_do_it.R
import kotlinx.android.synthetic.main.activity_cadastro_one.*

class CadastroOneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_one)
    }

    fun sendToNext(component: View) {
        val email = et_email.text.toString()
        val senha = et_senha.text.toString()

        var messages: MutableList<String> = ArrayList()

        if (android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            messages.add("Preencha o campo e-mail corretamente")
        }
        if (senha.length < 8) {
            messages.add("Sua senha precisa ser mais forte")
        }

        if (messages.size > 0) {
            Toast.makeText(this, messages[0], Toast.LENGTH_SHORT).show()
            return
        }

        val cadastro2 = Intent(this, CadastroTwoActivity::class.java)

        startActivity(cadastro2)
    }

}