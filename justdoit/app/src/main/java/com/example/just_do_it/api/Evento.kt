package com.example.just_do_it.api

data class Evento (
    val codigo:Int ,
    val nome: String,
    val cep: String,
    val logradouro: String,
    val complemento: String,
    val bairro: String,
    val localidade: String,
    val uf: String,
    val data: String,
    val horario: String,
    val descricao: String
)