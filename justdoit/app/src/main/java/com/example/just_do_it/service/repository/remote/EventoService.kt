package com.example.just_do_it.service.repository.remote


import com.example.just_do_it.service.model.Cep
import com.example.just_do_it.service.model.EventoModel
import com.example.just_do_it.service.model.UserModel
import retrofit2.Call
import retrofit2.http.*

interface EventoService {

    @POST("cadastrarEvento/{id}")
    fun postEvento(@Body evento:EventoModel,
                   @Path("id")id:Int?): Call<EventoModel>

    @GET("cep/{cep}")
    fun getCep(@Path("cep") id:String): Call<Cep>


    @GET("eventos")
    fun listarEventos(): Call<List<EventoModel>>


    @GET("eventos/{codigo}")
    fun pesquisarEvento(@Path("codigo") codigo:Long): Call<EventoModel>

    @DELETE("evento/{codigo}/{id}")
    fun deleteEvento(@Path("codigo") codigo: Long?,
                     @Path("id") id: Int?  ): Call<Void>


}