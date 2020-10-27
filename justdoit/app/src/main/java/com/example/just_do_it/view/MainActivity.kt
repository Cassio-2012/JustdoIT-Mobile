package com.example.just_do_it.view


import android.os.Bundle
import com.example.just_do_it.R

import com.example.just_do_it.service.repository.remote.EventoService
import com.example.just_do_it.service.repository.remote.RetrofitClient


class MainActivity : GenericActivity() {
    val remote = RetrofitClient.createService(EventoService::class.java)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        start()
}
}
