package com.example.just_do_it.view.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.just_do_it.R
import com.example.just_do_it.cadastro.CadastroOneActivity
import com.example.just_do_it.login.login_activity
import com.example.just_do_it.view.MainActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            val intent = Intent(this,

                //tela que aparecerá apos a splashActivity
              MainActivity::class.java)
            startActivity(intent)
        },3000)
    }
}