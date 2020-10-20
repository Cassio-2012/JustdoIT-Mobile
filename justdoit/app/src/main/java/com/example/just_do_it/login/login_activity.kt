package com.example.just_do_it.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.just_do_it.R
import kotlinx.android.synthetic.main.activity_login_activity.*

class login_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_activity)
    }

    val login = loginInput.text
    val senha = senhaInput.text

    fun Login (Componente: View){
        if (login.length==0 || senha.length==0){
            Toast.makeText(this, "Por favor não deixe nenhum campo em vazio", Toast.LENGTH_SHORT).show()
        }


        else{

        }
    }
}