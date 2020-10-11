package com.example.just_do_it.view

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.just_do_it.R
import com.example.just_do_it.view.evento.CadastroEventoActivity
import com.example.just_do_it.view.evento.ListaEventosActivity
import com.google.android.material.navigation.NavigationView


class MainActivity : GenericActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      start()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        return super.onNavigationItemSelected(menuItem)
    }
}
