package com.example.estadao.presentation.news.actions

import com.example.estadao.repository.Repository
import com.example.estadao.repository.remote.estadao.responses.DcumentoResponse
import io.reactivex.Single
import retrofit2.Response

class GetNewsId(private val repository: Repository,
                private val getToken : GetToken) {

    fun execute(id: String): Single<Response<List<DcumentoResponse>>> {
        return  getToken.execute()
            .flatMap {
                repository.remote.news.getNewsID(it, id.toInt())
            }
    }
}