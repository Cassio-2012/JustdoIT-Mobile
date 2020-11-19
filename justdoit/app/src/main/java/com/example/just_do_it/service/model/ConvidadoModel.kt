package com.example.just_do_it.service.model

data class ConvidadoModel (
    var id: Int? = null,
    var nomeConvidado: String? = null,
    var email: String? = null,
    var evento: EventoModel? =null
)