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
        val userEmail = intent.extras?.getString("email")
        val userSenha = intent.extras?.getString("senha")

        val nome = et_name.text.toString()
        val ocupacao = et_ocupacao.text.toString()
        val estado = et_estado.text.toString()

        if (nome.isEmpty() || ocupacao.isEmpty() || estado.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos corretamente"
                , Toast.LENGTH_SHORT).show()
            return
        }

        goScreen3(nome,estado,ocupacao,userEmail,userSenha)
    }

    fun backToPrevious(component: View) {

        val cadastro1 = Intent(this, CadastroOneActivity::class.java)

        startActivity(cadastro1)

    }

    fun goScreen3(nome:String,estado:String,ocupacao:String,userEmail:String?,userSenha:String?) {
        val tela3 = Intent(this, CadastroThreeActivity::class.java)

        tela3.putExtra("email",userEmail)
        tela3.putExtra("nome", nome)
        tela3.putExtra("local", estado)
        tela3.putExtra("title", ocupacao)
        tela3.putExtra("senha",userSenha)
        startActivity(tela3)
    }
}