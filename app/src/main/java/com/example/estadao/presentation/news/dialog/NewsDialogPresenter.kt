package com.example.estadao.presentation.news.dialog

import android.util.Log
import com.example.estadao.core.common.BasePresenter
import com.example.estadao.presentation.news.actions.GetNews
import com.example.estadao.presentation.news.actions.GetNewsId
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NewsDialogPresenter(private val contract: NewsDialogContract,
                          private val getNews : GetNewsId
) : BasePresenter() {

    fun getNewInit() {
        contract.showLoading()
        getNews.execute(contract.getIdNews())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                it.body()!!.map {
                      contract.setNewsIdResponse(it.documento)
                }
            }
            .subscribe(
                {
                    contract.initNews()
                    contract.hideLoading()
                },
                {
                    contract.hideLoading()
                    Log.e(AUTOCARD_ERRORS, "TODO: Error Handler - NewsPresenter") }
            ).also { addDisposable(it) }

    }



}