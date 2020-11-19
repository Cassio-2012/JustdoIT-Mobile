package com.example.just_do_it.view


import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.util.Base64
import android.widget.Toast
import com.example.just_do_it.R
import com.example.just_do_it.login.SessionManager
import com.example.just_do_it.service.model.UserModel

import com.example.just_do_it.service.repository.remote.EventoService
import com.example.just_do_it.service.repository.remote.RetrofitClient
import com.google.android.gms.common.util.Base64Utils.decode
import kotlinx.android.synthetic.main.activity_main.*

import java.util.*


class MainActivity : GenericActivity() {
    val remote = RetrofitClient.createService(EventoService::class.java)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val shared = SessionManager()
        shared.init(getApplicationContext())
        start()
        var usuarioLogado = UserModel()
        usuarioLogado = loadUser()


//        val imageBytes = Base64.decode(usuarioLogado.photo, Base64.DEFAULT)
    //    val decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
  //      photoPerfil.setImageBitmap(decodedImage)
    }

    fun loadUser(): UserModel {
        val sessionManager = SessionManager()
        sessionManager.init(applicationContext)

        return sessionManager.loadUser()

    }

}
