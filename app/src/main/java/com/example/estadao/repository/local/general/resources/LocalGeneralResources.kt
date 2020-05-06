package com.example.estadao.repository.local.general.resources

import io.reactivex.Completable
import io.reactivex.Single

interface LocalGeneralResources {
    fun getToken(): Single<String>
    fun saveToken(token: String): Completable
    fun cleanToken(): Completable
}