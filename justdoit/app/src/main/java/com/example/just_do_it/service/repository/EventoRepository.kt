package com.example.just_do_it.service.repository

import com.example.just_do_it.service.repository.remote.EventoService
import com.example.just_do_it.service.repository.remote.RetrofitClient

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
     /*   remote.cadastroEvento(
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


        )*/
    }
}