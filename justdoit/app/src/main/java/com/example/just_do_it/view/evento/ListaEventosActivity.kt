package com.example.just_do_it.view.evento

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.just_do_it.R
import com.example.just_do_it.service.repository.EventoRepository
import com.example.just_do_it.view.GenericActivity
import kotlinx.android.synthetic.main.activity_detalhes_evento.*

class ListaEventosActivity : GenericActivity() {
    lateinit var repository: EventoRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_eventos)
        start()

    }

    override fun onBackPressed() {
        super.onBackPressed()


    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        return super.onNavigationItemSelected(menuItem)
    }


}