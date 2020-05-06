package com.example.estadao.repository.remote.estadao

import com.autopass.autopay.repository.remote.update_management.producers.AutenticateLoginProducer
import com.example.estadao.repository.remote.estadao.resources.RemoteNewsResources
import com.example.estadao.repository.remote.estadao.responses.DcumentoResponse
import com.example.estadao.repository.remote.estadao.responses.LoginResponse
import com.example.estadao.repository.remote.estadao.responses.NewsResponse
import com.example.estadao.repository.remote.estadao.services.NewsServices
import io.reactivex.Observable

import io.reactivex.Single
import retrofit2.Response

class RemoteNewsRepository(
    private val services: NewsServices,
    private val autenticateLoginProducer : AutenticateLoginProducer
) : RemoteNewsResources {

    override fun autenticate(user: String, pass: String): Single<Response<LoginResponse>> {
        return services.autenticate(login = autenticateLoginProducer.execute(user, pass))
    }

    override fun getNews(token : String): Single<Response<List<NewsResponse>>> {
        return services.getNews(token = "Bearer $token")
    }

    override fun getNewsID(token: String, id: Int): Single<Response<List<DcumentoResponse>>> {
        return services.getNewsID(token = "Bearer $token", id = id)
    }

}