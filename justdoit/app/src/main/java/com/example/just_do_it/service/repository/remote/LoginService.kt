package com.example.just_do_it.service.repository.remote

import com.example.just_do_it.service.model.EventoModel
import com.example.just_do_it.service.model.LoginModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginService {

    @POST("user/login")//LoginUsuario,objet
    @FormUrlEncoded
    fun logar(
        @Field("nome")
        nome: String,
        @Field("senha")
        senha: String,
        @Field("mensagemErro")
        mensagemErro: String,
        @Field("validated")
        validated: Boolean

    ): Call<LoginModel>
    @POST("/user/recaptcha")
    @FormUrlEncoded
    fun recaptcha(
        @Field("token")
        token:String): Call<String>
}