package com.example.estadao.presentation.news.dialog

import com.example.estadao.repository.remote.estadao.responses.NewsIdResponse
import com.example.estadao.repository.remote.estadao.responses.NewsResponse

interface NewsDialogContract {
    fun getIdNews() : String
    fun setNewsIdResponse(item : NewsIdResponse)
    fun initNews()
    fun showLoading()
    fun hideLoading()
}