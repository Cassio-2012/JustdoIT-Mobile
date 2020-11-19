package com.example.vamos_lucrar.utils

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.just_do_it.R
import com.example.just_do_it.login.SessionManager
import com.example.just_do_it.service.model.ConvidadoModel
import com.example.just_do_it.service.model.EventoModel
import com.example.just_do_it.service.model.UserModel
import com.example.just_do_it.service.repository.remote.EventoService
import com.example.just_do_it.service.repository.remote.RetrofitClient
import com.example.just_do_it.view.evento.DetalhesEventoActivity
import com.example.just_do_it.view.evento.ListaEventosActivity

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyAdapterConvidado(var contexto: Context, var resouces: Int, var itens: List<ConvidadoModel>) :
    ArrayAdapter<ConvidadoModel>(contexto, resouces, itens) {

    val remote = RetrofitClient.createService(EventoService::class.java)


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(contexto)
        val view: View = layoutInflater.inflate(resouces, null)

        val nomeTextView: TextView = view.findViewById(R.id.nomeParticipante)
        val emailTextView: TextView = view.findViewById(R.id.email)

        var mItem: ConvidadoModel = itens[position]

        nomeTextView.text = mItem.nomeConvidado
        emailTextView.text = mItem.email
        return view
    }
    }






