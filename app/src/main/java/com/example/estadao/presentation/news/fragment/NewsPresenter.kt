package com.example.estadao.presentation.news.fragment

import android.util.Log
import com.example.estadao.core.common.BasePresenter
import com.example.estadao.presentation.news.actions.GetNews
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NewsPresenter(private val contract: NewsContract,
                    private val getNews : GetNews
) : BasePresenter() {

    fun getNewInit() {
        contract.showLoading()
        getNews.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    contract.handleItemsVisibility(shouldShowItems = it.body()!!.isNotEmpty())
                    contract.onLoadArticlesSuccessful(items = it.body()!!)
                    contract.hideLoading()

                },
                {
                    onLoadArticlesError()
                    Log.e(AUTOCARD_ERRORS, "TODO: Error Handler - NewsPresenter") }
            ).also { addDisposable(it) }

    }


    fun onLoadArticlesError() {
            contract.handleItemsVisibility(shouldShowItems = false)
            contract.onLoadArticlesError()
            contract.hideLoading()
    }

}