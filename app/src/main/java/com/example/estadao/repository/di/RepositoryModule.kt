package com.example.estadao.repository.di

import com.example.estadao.BuildConfig
import com.example.estadao.repository.Repository
import com.example.estadao.repository.remote.Api
import com.example.estadao.repository.remote.estadao.services.NewsServices
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

object RepositoryModule {

    val modules = module {

        /** Repository */
        single { Repository(androidApplication()) }

        /** Passenger Services */
        factory {
            Api<NewsServices>().create(
                NewsServices::class.java,
                BuildConfig.THEMOVIE_URL
            )
        }

    }
}