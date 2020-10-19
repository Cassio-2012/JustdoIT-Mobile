package com.example.just_do_it.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.just_do_it.R;
import com.example.just_do_it.cadastro.CadastroOneActivity;
import com.example.just_do_it.view.evento.CadastroEventoActivity;
import com.example.just_do_it.view.evento.ListaEventosActivity;
import com.google.android.material.navigation.NavigationView;

import java.nio.file.OpenOption;

public class GenericActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //variaveis
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;

    public void start() {
        //Hoocks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toobar);
        //Tool Bar
        setSupportActionBar(toolbar);

        //Navigation Drawer Menu


        navigationView.bringToFront();
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);
    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                Intent home = new Intent(this, MainActivity.class);
                startActivity(home);
                break;
            case R.id.nav_recomendation:
                break;
            case R.id.nav_person:
                break;
            case R.id.nav_logout:
                Intent cadastro = new Intent(this, CadastroOneActivity.class);
                startActivity(cadastro);
                break;
            case R.id.nav_all_events:
                Intent listaEvento = new Intent(this, ListaEventosActivity.class);
                startActivity(listaEvento);
                break;
            case R.id.nav_cad_event:
                Intent cadastroEvento = new Intent(this, CadastroEventoActivity.class);
                startActivity(cadastroEvento);
                break;
            case R.id.nav_help:
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}
