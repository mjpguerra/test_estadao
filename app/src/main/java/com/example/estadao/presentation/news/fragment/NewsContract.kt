package com.example.estadao.presentation.news.fragment

import com.example.estadao.repository.remote.estadao.responses.NewsResponse

interface NewsContract {
    fun setViews()
    fun showLoading()
    fun hideLoading()
    fun updateAdapter(items: List<NewsResponse>)
    fun onLoadArticlesSuccessful(items: List<NewsResponse>)
    fun onLoadArticlesError()
    fun handleItemsVisibility(shouldShowItems: Boolean)
    fun onNewsClick(newsItem: NewsResponse, position: Int)
}