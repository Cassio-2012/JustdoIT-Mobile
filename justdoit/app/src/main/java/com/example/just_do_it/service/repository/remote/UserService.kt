package com.example.just_do_it.service.repository.remote

import com.example.just_do_it.service.model.UserModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UserService {
    @POST("/login")
    @FormUrlEncoded
    fun login(  @Field("email") email: String,
                @Field("senha") senha: String
    ): Call<UserModel>

    fun cadastro(
        @Field("nome") nome: String,
        @Field("email") email: String,
        @Field("photo") photo: String,
        @Field("senha") senha: String,
        @Field("sobre") sobre: String,
        @Field("local") local: String,
        @Field("title") title: String
    ): Call<UserModel>

}