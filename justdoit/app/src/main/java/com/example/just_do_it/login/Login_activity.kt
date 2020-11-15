package com.example.just_do_it.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.just_do_it.cadastro.CadastroOneActivity
import com.example.just_do_it.service.model.UserModel
import com.example.just_do_it.service.repository.remote.LoginService
import com.example.just_do_it.service.repository.remote.RetrofitClient
import com.example.just_do_it.view.evento.ListaEventosActivity
import kotlinx.android.synthetic.main.activity_login_activity.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Login_activity : AppCompatActivity() {

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
//            if(checkbox_recaptcha.isChecked()){
//                SafetyNet.getClient(this).verifyWithRecaptcha(SITE_KEY)
//                    .addOnSuccessListener(this) { response ->
//                        if (!response.tokenResult.isEmpty()) {
//                            Toast.makeText(this, "Verificando...", Toast.LENGTH_SHORT).show()
//                            checkbox_recaptcha.setTextColor(Color.GREEN)
//
//                        }
//                    }
//            }
//            LoginCaptcha()
        var usuario = UserModel()
            usuario.email = login
            usuario.senha = senha

            var logar = remote.loginUser(usuario)
            logar.enqueue(object : Callback<UserModel> {
                override fun onFailure(call: Call<UserModel>, t: Throwable) {
                    Toast.makeText(baseContext, "Erro $t", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {

                    val usuario:UserModel? = response.body()

                    prepareEvents(usuario);

                }
            })

        }
    }


//    fun LoginCaptcha() {
//        val loginrecaptcha = remote.logar(login, senha, mensagemErro, validated)
//        loginrecaptcha.enqueue(object : Callback<LoginModel> {
//            override fun onFailure(call: Call<LoginModel>, t: Throwable) {
//                Toast.makeText(baseContext, "Erro $t", Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onResponse(call: Call<LoginModel>, response: Response<LoginModel>) {
//                val login = response.body()
//                if (login.hashCode().equals(200)) {
//                    startActivity(home)
//                }
//            }
//        })
//
//    }
//
    fun prepareEvents(usuario:UserModel?) {


        val manager = SessionManager()
        manager.init(getApplicationContext())

        val user: String? = manager.read("usuario", null)

        if (user == null) {
            manager.writeUser(usuario!!)
            goToEvents()
        }
        else {
            Toast.makeText(this, "erro de conexão", Toast.LENGTH_SHORT).show()
            return
        }

    }

    fun goToEvents() {

        val events = Intent(this, ListaEventosActivity::class.java)

        startActivity(events)

    }

    fun goToRegister(component:View) {

        val register = Intent(this, CadastroOneActivity::class.java)

        startActivity(register)

    }





}

