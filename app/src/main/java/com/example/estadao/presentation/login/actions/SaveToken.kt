package com.example.estadao.presentation.login.actions

import com.example.estadao.repository.Repository
import io.reactivex.Single

class SaveToken(private val repository: Repository ) {

    fun execute(token : String): Single<String> {
        return repository.local.general.saveToken(token).toSingleDefault(token)
    }
}