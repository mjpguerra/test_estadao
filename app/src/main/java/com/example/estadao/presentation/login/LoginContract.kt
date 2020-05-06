package com.example.estadao.presentation.login

import android.content.Context

interface LoginContract {

    fun navigateToNews()
    fun context(): Context
    fun username(): String
    fun password(): String
    fun loadingShow()
    fun loadingHide()
}