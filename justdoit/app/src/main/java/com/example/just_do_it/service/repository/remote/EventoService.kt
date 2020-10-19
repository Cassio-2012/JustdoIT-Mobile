package com.example.just_do_it.service.repository.remote


import com.example.just_do_it.service.model.EventoModel
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface EventoService {
    @POST("cadastrarEvento")//cadastrarEvento,objet
    @FormUrlEncoded
    fun cadastroEvento(
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
    ): Call<EventoModel>

    @GET("eventos")
    fun listarEventos(): Call<List<EventoModel>>

    @GET("eventos/codigo")
    fun pesquisarEvento()

    @DELETE("evento/codigo")
    fun deletarEvento()
}