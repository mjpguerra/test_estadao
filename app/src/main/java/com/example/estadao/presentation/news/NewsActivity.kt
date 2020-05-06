package com.example.estadao.presentation.news

import android.content.Context
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.FragmentTransaction
import com.example.estadao.R
import com.example.estadao.core.common.BaseActivity
import com.example.estadao.presentation.news.fragment.NewsFragment
import com.example.estadao.repository.remote.estadao.responses.NewsResponse
import kotlinx.android.synthetic.main.activity_news.*
import kotlinx.android.synthetic.main.news_toolbar.view.*

class NewsActivity : BaseActivity() {

    var newsItem: NewsResponse? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        newsActivity = this

        setupViews()
        setupToolbar()

    }

    private fun setupToolbar() {
        val toolbar = newsToolbar
        let {
            val mainActivity = it as NewsActivity
            mainActivity.setSupportActionBar(toolbar as Toolbar)
            mainActivity.supportActionBar?.setDisplayHomeAsUpEnabled(true)

            toolbar.tsTxtTitle.text = "Noticias"
        }
    }

    override fun onBackPressed() {
        finish()
    }


    fun changeActionBar() {
        actionBar?.setBackgroundDrawable(
            ColorDrawable(
                ResourcesCompat.getColor(resources, R.color.colorPrimaryDark, null)
            )
        )
    }

    override fun onResume() {
        super.onResume()
        let { changeActionBar() }
    }

    private fun setupViews() {
        supportFragmentManager.beginTransaction().let {
            addExtraFragments(it)
            it.commit()
        }
    }

    private fun addExtraFragments(fragmentTransaction: FragmentTransaction) {
        fragmentTransaction.add(R.id.mainNewsContainer, NewsFragment.newInstance())
    }

    companion object {
        var newsActivity : NewsActivity? = null
        fun buildIntent(context: Context): Intent = Intent(context, NewsActivity::class.java)
    }
}
