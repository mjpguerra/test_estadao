package com.example.estadao.presentation.news.actions

import com.example.estadao.repository.Repository
import io.reactivex.Single

class GetToken(private val repository: Repository ) {

    fun execute(): Single<String> {
        return repository.local.general.getToken()
    }
}