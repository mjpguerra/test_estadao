package com.example.estadao.presentation.news.actions

import com.example.estadao.repository.Repository
import com.example.estadao.repository.remote.estadao.responses.LoginResponse
import com.example.estadao.repository.remote.estadao.responses.NewsResponse
import io.reactivex.Single
import retrofit2.Response

class GetNews(private val repository: Repository ,
              private val getToken : GetToken) {

    fun execute(): Single<Response<List<NewsResponse>>> {
        return  getToken.execute()
            .flatMap {
                repository.remote.news.getNews(it)
            }
    }
}