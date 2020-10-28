package com.example.just_do_it.cadastro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.just_do_it.R
import com.example.just_do_it.login.Login_activity
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


        if(email.isEmpty()) {
            messages.add("Por favor preencha o campo e-mail corretamente")
        }

        if (senha.length < 8) {
            messages.add("Sua senha precisa ser mais forte")
        }

        if (messages.size > 0) {
            Toast.makeText(this, messages[0], Toast.LENGTH_SHORT).show()
            return
        }
        goScreen2(email,senha)
    }

    fun goScreen2(email:String,senha:String) {
        val tela2 = Intent(this, CadastroTwoActivity::class.java)

        tela2.putExtra("email", email)
        tela2.putExtra("senha", senha)

        startActivity(tela2)
    }

    fun goToLogin(component: View) {

        val login = Intent(this, Login_activity::class.java)

        startActivity(login)

    }

}