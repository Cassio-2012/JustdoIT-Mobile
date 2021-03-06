package com.example.just_do_it

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.graphics.drawable.RoundedBitmapDrawable
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import android.util.Base64
import com.example.just_do_it.login.SessionManager
import com.example.just_do_it.service.model.UserModel
import com.example.just_do_it.service.repository.remote.RetrofitClient
import com.example.just_do_it.service.repository.remote.UserService
import com.example.just_do_it.view.GenericActivity
import kotlinx.android.synthetic.main.activity_perfil.*
import retrofit2.Retrofit
import java.util.*

/*
class Perfil : GenericActivity()  {
    val  remote = RetrofitClient.createService(UserService::class.java)
    var usuarioLogado = UserModel()
    val sessionManager = SessionManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)
        start()
        usuarioLogado = loadUser()

        var fotoPerfil = usuarioLogado.photo?.let { convertImg(it) }
        img_perfil.setImageBitmap(fotoPerfil)
        name.text = "Nome: ${usuarioLogado.nome}"
        email.text = "Email: ${usuarioLogado.email}"
        obs.text = "Ocupação: ${usuarioLogado.title}"
    }
    fun convertImg(foto: String): Bitmap? {
        val base64String = foto
        val base64Image = base64String?.split(",".toRegex())?.toTypedArray()?.get(1)
        val decodedString = Base64.decode(base64Image, Base64.DEFAULT)
        val decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)
        return decodedByte
    }

    //METODO PARA ARrEDONDAR BORDA DA IMAGEM
    fun roundedBitmap(bitmap: Bitmap): RoundedBitmapDrawable {
        val roundedBitmapDrawable =
                RoundedBitmapDrawableFactory.create(Resources.getSystem(), bitmap)
        roundedBitmapDrawable.isCircular = true
        roundedBitmapDrawable.cornerRadius = Math.max(bitmap.width, bitmap.height) / 2.0f
        return roundedBitmapDrawable

    }
    fun loadUser(): UserModel {
        val sessionManager = SessionManager()
        sessionManager.init(applicationContext)

        return sessionManager.loadUser()

    }

    fun removeUser() {
        val sessionManager = SessionManager()
        sessionManager.init(applicationContext)
        sessionManager.removeUser()

    }

}*/