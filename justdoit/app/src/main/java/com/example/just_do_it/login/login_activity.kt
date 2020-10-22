package com.example.just_do_it.login

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.example.just_do_it.R
import com.example.just_do_it.service.model.LoginModel
import com.example.just_do_it.service.repository.remote.LoginService
import com.example.just_do_it.service.repository.remote.RetrofitClient
import com.example.just_do_it.view.MainActivity
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.CommonStatusCodes
import com.google.android.gms.safetynet.SafetyNet
import kotlinx.android.synthetic.main.activity_login_activity.*
import org.json.JSONArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class login_activity : AppCompatActivity() {

    val remote = RetrofitClient.createService(LoginService::class.java)
    companion object {
        const val TAG = "LoginActivity"
        const val SITE_KEY = "6LdaTsgZAAAAAKfNzRRnShR_oI_UOG3r2cubtiPk"
    }

    var login: String = ""
    var senha: String = ""
    var mensagemErro: String = ""
    var validated: Boolean = false
    lateinit var home: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_activity)
    }

    fun Login(Componente: View) {
        login = loginInput.text.toString()
        senha = senhaInput.text.toString()

        if (login.length == 0 || senha.length == 0) {
            Toast.makeText(this, "Por favor não deixe nenhum campo em vazio", Toast.LENGTH_SHORT)
                .show()
        } else {
            if(checkbox_recaptcha.isChecked()){
                SafetyNet.getClient(this).verifyWithRecaptcha(SITE_KEY)
                    .addOnSuccessListener(this) { response ->
                        if (!response.tokenResult.isEmpty()) {
                            Toast.makeText(this, "Verificando...", Toast.LENGTH_SHORT).show()
                            checkbox_recaptcha.setTextColor(Color.GREEN)

                        }
                    }
            }
            LoginCaptcha()
        }
    }


    fun LoginCaptcha() {
        val loginrecaptcha = remote.logar(login, senha, mensagemErro, validated)
        loginrecaptcha.enqueue(object : Callback<LoginModel> {
            override fun onFailure(call: Call<LoginModel>, t: Throwable) {
                Toast.makeText(baseContext, "Erro $t", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<LoginModel>, response: Response<LoginModel>) {
                val login = response.body()
                if (login.hashCode().equals(200)) {
                    startActivity(home)
                }
            }
        })

    }
}

