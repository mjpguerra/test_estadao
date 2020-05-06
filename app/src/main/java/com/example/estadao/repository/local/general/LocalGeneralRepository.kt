package com.example.estadao.repository.local.general

import android.content.Context
import android.content.SharedPreferences
import com.example.estadao.repository.local.general.resources.LocalGeneralResources
import io.reactivex.Completable
import io.reactivex.Single

class LocalGeneralRepository(private val applicationContext: Context) : LocalGeneralResources {

    companion object {
        const val TOKEN = "token"
        const val REPOSITORY = "local_general_repository"
    }

    private val sharedPreferences: SharedPreferences by lazy {
        applicationContext.getSharedPreferences(REPOSITORY, Context.MODE_PRIVATE)
    }


    override fun getToken(): Single<String> = Single.fromCallable {
        sharedPreferences.getString(TOKEN, "")
    }

    override fun saveToken(id: String): Completable = Completable.fromCallable {
        sharedPreferences.edit().putString(TOKEN, id).apply()
    }

    override fun cleanToken(): Completable = Completable.fromCallable {
        sharedPreferences.edit().putInt(TOKEN, 0).apply()
    }


}