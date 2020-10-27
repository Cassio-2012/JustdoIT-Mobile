package com.example.just_do_it.cadastro

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.just_do_it.R
import com.example.just_do_it.service.model.UserModel
import com.example.just_do_it.service.repository.remote.LoginService
import com.example.just_do_it.service.repository.remote.RetrofitClient
import com.example.just_do_it.service.repository.remote.UserService
import com.example.just_do_it.view.evento.Usuario
import kotlinx.android.synthetic.main.activity_cadastro_three.*
import kotlinx.android.synthetic.main.activity_cadastro_two.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val IMAGE_PICK_CODE = 1000;
    private const val PERMISSION_CODE = 1001;

class CadastroThreeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_three)


        imageView.setOnClickListener {


            if (checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE) ==
                    PackageManager.PERMISSION_DENIED){
                    val permissions = arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE);

                    requestPermissions(permissions, PERMISSION_CODE);
                }
                else{

                    pickImageFromGallery();
                }
            }

        }

    private fun pickImageFromGallery() {

        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
}


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode){
            PERMISSION_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED){

                    pickImageFromGallery()
                }
                else{

                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE){
            imageView.setImageURI(data?.data)
        }
    }


    fun concluir(component: View) {
        val remote = RetrofitClient.createService(UserService::class.java)
        var userEmail = intent.extras?.getString("email")
        var userNome = intent.extras?.getString("nome")
        var userSenha = intent.extras?.getString("senha")
        var userEstado = intent.extras?.getString("_local")
        var userOcupacao = intent.extras?.getString("title")


        userEmail = if(userEmail!=null){userEmail}else{""}
        userNome = if(userNome!=null){userNome}else{""}
        userSenha = if(userSenha!=null){userSenha}else{""}
        userEstado = if(userEstado!=null){userEstado}else{""}
        userOcupacao = if(userOcupacao!=null){userOcupacao}else{""}



val usuario = UserModel()

        usuario.email = userEmail
        usuario.nome = userNome
        usuario.senha = userSenha
        usuario._local = userEstado
        usuario.title = userOcupacao
        val cadastro = remote.cadastroUser(usuario)
        cadastro.enqueue(object : Callback<UserModel> {
            override fun onFailure(call: Call<UserModel>, t: Throwable) {
                Toast.makeText(baseContext, "Erro $t", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                val usuario = response.body()
                Toast.makeText(baseContext, usuario?.nome,Toast.LENGTH_SHORT).show()
                Toast.makeText(baseContext, "Cadastrado com sucesso!!!", Toast.LENGTH_SHORT).show()
            }
        })


    }

    fun backToPrevious(component: View) {

        val cadastro2 = Intent(this, CadastroTwoActivity::class.java)

        startActivity(cadastro2)

    }

}