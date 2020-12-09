package com.example.just_do_it.view

import android.content.Intent
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.core.graphics.drawable.RoundedBitmapDrawable
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import android.util.Base64
import android.view.MenuItem
import com.example.just_do_it.R
import com.example.just_do_it.login.Login_activity
import com.example.just_do_it.login.SessionManager
import com.example.just_do_it.service.model.UserModel
import com.example.just_do_it.service.repository.remote.RetrofitClient
import com.example.just_do_it.service.repository.remote.UserService
import kotlinx.android.synthetic.main.activity_perfil.*

class PerfilActivity : GenericActivity() {
    val remote = RetrofitClient.createService(UserService::class.java)
    var usuarioLogado = UserModel()
    val sessionManager = SessionManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)
        usuarioLogado = loadUser()


        var fotoPerfil = usuarioLogado.photo?.let { convertImg(it)?.let { roundedBitmap(it) } }

        name_perfil.text = usuarioLogado.nome.toString()
        work_name_project.text = usuarioLogado.title.toString()

        et_name.setHint(usuarioLogado.nome)
        et_Email.setHint(usuarioLogado.email)
        img_perfil.setImageDrawable(fotoPerfil)

        println(usuarioLogado.nome)
        println(usuarioLogado.email)
    }


    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {

        if (menuItem.itemId == R.id.nav_logout) {

            val login = Intent(this, Login_activity::class.java)
            removeUser();
            startActivity(login)
            return false

        } else {
            return super.onNavigationItemSelected(menuItem)
        }
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


    fun convertImg(foto: String): Bitmap? {
        val base64String = foto
        val base64Image = base64String?.split(",".toRegex())?.toTypedArray()?.get(1)
        val decodedString = Base64.decode(base64Image, Base64.DEFAULT)
        val decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)
        return decodedByte
    }

    fun roundedBitmap(bitmap: Bitmap): RoundedBitmapDrawable {
        val roundedBitmapDrawable =
            RoundedBitmapDrawableFactory.create(Resources.getSystem(), bitmap)
        roundedBitmapDrawable.isCircular = true
        roundedBitmapDrawable.cornerRadius = Math.max(bitmap.width, bitmap.height) / 3.0f
        return roundedBitmapDrawable

    }

}