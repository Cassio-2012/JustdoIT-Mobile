package com.example.just_do_it.login

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.just_do_it.R
import com.example.just_do_it.cadastro.CadastroOneActivity
import com.example.just_do_it.service.model.UserModel
import com.example.just_do_it.service.repository.remote.LoginService
import com.example.just_do_it.service.repository.remote.RetrofitClient
import com.example.just_do_it.view.evento.ListaEventosActivity
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.CommonStatusCodes
import com.google.android.gms.safetynet.SafetyNet
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import kotlinx.android.synthetic.main.activity_login_activity.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.Executor


class Login_activity : AppCompatActivity() {

    val remote = RetrofitClient.createService(LoginService::class.java)


    companion object {
        const val TAG = "LoginActivity"
        const val SITE_KEY = "6Ldf9_YZAAAAAOesE7FPr6H3EfrY2QjzqaH4_KBa"
        const val CAPTCHA_KEY = "6LcUiv0ZAAAAAM9euoLRqq5yb22AUM6qTig6idNz"
    }


    var login: String = ""
    var senha: String = ""
    var mensagemErro: String = ""
    var validated: Boolean = false
    lateinit var home: Intent
    val manager = SessionManager()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.just_do_it.R.layout.activity_login_activity)
        manager.init(getApplicationContext())

        val user: String? = manager.read("nome", null)

        if (user != null) {
            goToEvents()
        }


    }


    fun Login(Componente: View) {
        login = loginInput.text.toString()
        senha = senhaInput.text.toString()

        if (login.length == 0 || senha.length == 0) {
            Toast.makeText(this, "Por favor não deixe nenhum campo em vazio", Toast.LENGTH_SHORT)
                .show()
        } else {
            var usuario = UserModel()
            usuario.email = login
            usuario.senha = senha
            if (validated == true) {
                var logar = remote.loginUser(usuario)
                logar.enqueue(object : Callback<UserModel> {
                    override fun onFailure(call: Call<UserModel>, t: Throwable) {
                        Toast.makeText(baseContext, "Erro $t", Toast.LENGTH_SHORT).show()
                    }

                    override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {

                        val usuario: UserModel? = response.body()

                        prepareEvents(usuario);

                    }
                })
            }

        }

    }

    fun loginCaptcha(Componente: View) {
/*
        if (checkbox_recaptcha.isChecked) {
            val loginrecaptcha = remote.recaptcha(CAPTCHA_KEY)
            loginrecaptcha.enqueue(object : Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    Toast.makeText(
                        this@Login_activity,
                        "${response.body()} ${response.code()}",
                        Toast.LENGTH_SHORT
                    ).show()
                    validated = true
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    Toast.makeText(this@Login_activity, "${t.message}", Toast.LENGTH_SHORT).show()
                    validated = false
                }
            })
        }*/

        SafetyNet.getClient(this).verifyWithRecaptcha(CAPTCHA_KEY)

            .addOnSuccessListener(this as Executor, OnSuccessListener { response ->
                // Indicates communication with reCAPTCHA service was
                // successful.
                val userResponseToken = response.tokenResult
                if (response.tokenResult?.isNotEmpty() == true) {
                    val loginrecaptcha = remote.recaptcha(CAPTCHA_KEY)
                    loginrecaptcha.enqueue(object : Callback<String> {
                        override fun onResponse(call: Call<String>, response: Response<String>) {
                            Toast.makeText(
                                this@Login_activity,
                                "${response.body()} ${response.code()}",
                                Toast.LENGTH_SHORT
                            ).show()
                            validated = true
                        }

                        override fun onFailure(call: Call<String>, t: Throwable) {
                            Toast.makeText(this@Login_activity, "${t.message}", Toast.LENGTH_SHORT).show()
                            validated = false
                        }
                    })
                }
            })
            .addOnFailureListener(this as Executor, OnFailureListener { e ->
                if (e is ApiException) {
                    // An error occurred when communicating with the
                    // reCAPTCHA service. Refer to the status code to
                    // handle the error appropriately.
                    Log.d(TAG, "Error: ${CommonStatusCodes.getStatusCodeString(e.statusCode)}")
                } else {
                    // A different, unknown type of error occurred.
                    Log.d(TAG, "Error: ${e.message}")
                }
            })











    }

    fun prepareEvents(usuario: UserModel?) {


        val manager = SessionManager()
        manager.init(getApplicationContext())

        val user: String? = manager.read("usuario", null)

        if (user == null) {
            manager.writeUser(usuario!!)
            goToEvents()
        } else {
            Toast.makeText(this, "erro de conexão", Toast.LENGTH_SHORT).show()
            return
        }

    }

    fun goToEvents() {

        val events = Intent(this, ListaEventosActivity::class.java)

        startActivity(events)

    }

    fun goToRegister(component: View) {

        val register = Intent(this, CadastroOneActivity::class.java)

        startActivity(register)

    }


}

