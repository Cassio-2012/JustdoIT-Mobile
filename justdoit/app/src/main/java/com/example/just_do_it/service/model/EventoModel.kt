package com.example.just_do_it.service.model

data class EventoModel(
    var codigo:Long?,
    var nome: String?,
    var cep: String?,
    var logradouro: String?,
    var complemento: String?,
    var bairro: String?,
    var localidade: String?,
    var uf: String?,
    var dataEvento: String?,
    var horario: String?,
    var descricao: String?

)