package com.example.just_do_it.view.evento

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.just_do_it.R
import com.example.just_do_it.view.GenericActivity

class ListaEventosActivity : GenericActivity() {

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