package com.example.estadao.repository.remote.estadao.services

import com.example.estadao.repository.remote.estadao.model.Login
import com.example.estadao.repository.remote.estadao.responses.DcumentoResponse
import com.example.estadao.repository.remote.estadao.responses.LoginResponse
import com.example.estadao.repository.remote.estadao.responses.NewsResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.*

interface NewsServices {

    @POST("login")
    fun autenticate(
        @Header("Content-Type") contentType: String = "application/json",
        @Body login: Login): Single<Response<LoginResponse>>

    @GET("news")
    fun getNews(@Header("Authorization") token: String): Single<Response<List<NewsResponse>>>

    @GET("news/{id}")
    fun getNewsID(@Header("Authorization") token: String , @Path("id") id: Int): Single<Response<List<DcumentoResponse>>>

}