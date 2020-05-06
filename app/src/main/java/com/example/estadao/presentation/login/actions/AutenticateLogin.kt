package com.example.estadao.presentation.login.actions

import com.example.estadao.repository.Repository
import com.example.estadao.repository.remote.estadao.responses.LoginResponse
import io.reactivex.Single
import retrofit2.Response

class AutenticateLogin(private val repository: Repository ) {

    fun execute(user: String, pass: String): Single<Response<LoginResponse>> {
        return repository.remote.news.autenticate(user, pass)
    }
}