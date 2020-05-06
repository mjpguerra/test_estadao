package com.example.estadao.presentation.news.dialog

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import com.example.estadao.R
import com.example.estadao.core.common.BaseActivity
import com.example.estadao.core.extensions.isVisible
import com.example.estadao.core.extensions.loadImage
import com.example.estadao.presentation.login.LoginActivity
import com.example.estadao.presentation.news.NewsActivity
import com.example.estadao.repository.remote.estadao.responses.NewsIdResponse
import kotlinx.android.synthetic.main.fragment_dialog_news.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf


/**
 * @author Mario Guerra on 10/07/2019
 */
const val PAGE_URL = "pageUrl"
const val MAX_PROGRESS = 100

class NewsDialog : BaseActivity(), NewsDialogContract{

    private val presenter: NewsDialogPresenter by inject { parametersOf(this) }
    private var newsIdResponse : NewsIdResponse? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_dialog_news)

        presenter.getNewInit()
    }

    override fun initNews(){
        runOnUiThread {
            newsEditoria.text = newsIdResponse!!.editoria
            newsCredit.text = newsIdResponse!!.credito
            newsOri.text = newsIdResponse!!.origem + "   " + newsIdResponse!!.datapub + " - " + newsIdResponse!!.horapub
            newsTitle.text = newsIdResponse!!.titulo
            newsImage.loadImage(newsIdResponse!!.imagem, false, R.drawable.ic_no_image_found)
            newsDescription.text = newsIdResponse!!.linhafina
        }

    }

    override fun hideLoading() {
        progressBar.isVisible = false
    }

    override fun showLoading() {
        progressBar.isVisible = true
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun setNewsIdResponse(item :  NewsIdResponse){
        newsIdResponse = item
    }

    override fun getIdNews() : String{
       return NewsActivity.newsActivity!!.newsItem!!.id_documento
   }

    companion object {
        fun buildIntent(context: Context): Intent = Intent(context, NewsDialog::class.java)
    }

}