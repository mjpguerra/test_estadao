package com.example.estadao.di


import com.example.estadao.presentation.login.LoginContract
import com.example.estadao.presentation.login.LoginPresenter
import com.example.estadao.presentation.login.actions.*
import com.example.estadao.presentation.news.fragment.NewsContract
import com.example.estadao.presentation.news.fragment.NewsPresenter
import com.example.estadao.presentation.news.actions.GetNews
import com.example.estadao.presentation.news.actions.GetNewsId
import com.example.estadao.presentation.news.actions.GetToken
import com.example.estadao.presentation.news.dialog.NewsDialogContract
import com.example.estadao.presentation.news.dialog.NewsDialogPresenter
import org.koin.dsl.module

object PresenterModule {

    val modules = module {

        /** Register */
        factory { (contract: LoginContract) -> LoginPresenter(contract, get(), get()) }

        factory { (contract: NewsContract) -> NewsPresenter(contract, get()) }

        factory { (contract: NewsDialogContract) -> NewsDialogPresenter(contract, get()) }

        factory { SaveToken(get())}
        factory { GetToken(get())}
        factory { AutenticateLogin(get())}
        factory { GetNews(get(), get())}
        factory { GetNewsId(get(), get())}



    }
}