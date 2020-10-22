package com.example.just_do_it.service.model

data class LoginModel(
    var nome: String,
    var senha: String,
    var mensagemErro: String,
    var validated: Boolean
)


