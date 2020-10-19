package com.example.just_do_it.service.repository

import android.widget.Toast

import com.example.just_do_it.service.model.EventoModel
import com.example.just_do_it.service.repository.remote.EventoService
import com.example.just_do_it.service.repository.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EventoRepository {
    val remote = RetrofitClient.createService(EventoService::class.java)

    fun cadastro(
        nome: String,
        cep: String,
        logradouro: String,
        complemento: String,
        bairro: String,
        localidade: String,
        uf: String,
        data: String,
        horario: String,
        descricao: String
    ) {

        val call: Call<EventoModel> = remote.cadastroEvento(
            nome,
            cep,
            logradouro,
            complemento,
            bairro,
            localidade,
            uf,
            data,
            horario,
            descricao
        )
        call.enqueue(object : Callback<EventoModel> {
            override fun onFailure(call: Call<EventoModel>, t: Throwable) {
                t.message
            }

            override fun onResponse(call: Call<EventoModel>, response: Response<EventoModel>) {
                response.body()
            }

        })
    }

    fun listarEventos() {
        val call: Call<List<EventoModel>> = remote.listarEventos()
        call.enqueue(object : Callback<List<EventoModel>> {
            override fun onFailure(call: Call<List<EventoModel>>, t: Throwable) {
                t.message
            }

            override fun onResponse(
                call: Call<List<EventoModel>>,
                response: Response<List<EventoModel>>
            ) {
                response.body()

            }

        })

    }
}
