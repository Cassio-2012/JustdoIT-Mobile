package com.example.just_do_it.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.just_do_it.R
import com.example.just_do_it.cadastro.CadastroOneActivity
import com.example.just_do_it.cadastro.CadastroTwoActivity
import com.example.just_do_it.service.model.LoginModel
import com.example.just_do_it.service.model.UserModel
import com.example.just_do_it.service.repository.remote.LoginService
import com.example.just_do_it.service.repository.remote.RetrofitClient
import com.example.just_do_it.view.evento.ListaEventosActivity
import com.example.just_do_it.view.evento.Usuario
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

                    goToEvents(usuario);

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

    fun goToEvents(usuario:UserModel?) {

        val events = Intent(this, ListaEventosActivity::class.java)

        events.putExtra("id", usuario?.id)
        events.putExtra("email", usuario?.email)
        events.putExtra("nome", usuario?.nome)
        events.putExtra("photo", usuario?.photo)

        startActivity(events)

    }

    fun goToRegister(component:View) {

        val register = Intent(this, CadastroOneActivity::class.java)

        startActivity(register)

    }

}

