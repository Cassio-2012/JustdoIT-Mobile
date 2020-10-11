package com.example.just_do_it.view.evento

import java.sql.Blob

data class Usuario(

    val email:String,
    val nome:String,
    val senha:String,
    val titulo:String,
    val cidade:String,
    val imagem:Blob

)
