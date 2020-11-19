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
    var descricao: String?,
    var convidados: Array<String>?,
    var adm: Int?

)

/*
{
    "codigo": 36,
    "nome": "Evento teste",
    "cep": "05886120",
    "logradouro": "Rua Luís de Oliveira",
    "bairro": "Jardim Dom José",
    "localidade": "São Paulo",
    "uf": "SP",
    "complemento": "Casa 3",
    "dataEvento": null,
    "horario": "",
    "descricao": "Evento show",
    "convidados": [],
    "adm": null
}*/