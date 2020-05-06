package com.example.estadao.repository.remote.estadao.resources

import com.example.estadao.repository.remote.estadao.responses.DcumentoResponse
import com.example.estadao.repository.remote.estadao.responses.LoginResponse
import com.example.estadao.repository.remote.estadao.responses.NewsResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.Path

interface RemoteNewsResources {
    fun autenticate(user: String, pass: String): Single<Response<LoginResponse>>
    fun getNews(token : String): Single<Response<List<NewsResponse>>>
    fun getNewsID(token: String , id: Int): Single<Response<List<DcumentoResponse>>>
}