package com.example.just_do_it.service.repository.remote

import com.example.just_do_it.service.model.EventoModel
import com.example.just_do_it.service.model.PostModel
import com.example.just_do_it.service.model.UserModel
import retrofit2.Call
import retrofit2.http.Body

import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PostService {


    @POST("/post/new/{id}")
    fun postNew(@Body post: PostModel,
                @Path("id")id:Int?): Call<Void>

    @GET("/post/load/initial/{id}")
    fun postLoadInitial(@Path("id")id:Int?): Call<Void>

    @GET("/post/load/feed")
    fun  postLoadFeed(): Call<List<PostModel>>

    @GET("/post/load/all")
    fun  postLoadFeedAll(): Call<List<PostModel>>

}