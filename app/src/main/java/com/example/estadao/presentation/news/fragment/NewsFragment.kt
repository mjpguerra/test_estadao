package com.example.estadao.presentation.news.fragment

import android.os.Bundle
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.estadao.R
import com.example.estadao.core.common.BaseFragment
import com.example.estadao.core.navigator.extensions.start
import com.example.estadao.presentation.news.NewsActivity
import com.example.estadao.presentation.news.dialog.NewsDialog
import com.example.estadao.repository.remote.estadao.responses.NewsResponse
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_news.*
import org.jetbrains.anko.startActivity
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf


class NewsFragment : BaseFragment(), NewsContract {

    override val resLayout = R.layout.fragment_news

    private val presenter: NewsPresenter by inject { parametersOf(this) }

    private lateinit var adapter: NewstemsAdapter

    companion object {
        fun newInstance() = NewsFragment()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViews()
        setupRecyclerView()
        presenter.getNewInit()
    }

    override fun setViews() {
        emptyItemsTextView?.text = getString(R.string.videos_not_found)
    }

    override fun handleItemsVisibility(shouldShowItems: Boolean) {
        itemsRecyclerView?.isVisible = shouldShowItems
        emptyItemsTextView?.isVisible = !shouldShowItems
    }

    override fun hideLoading() {
        progressBar.isVisible = false
    }

    override fun showLoading() {
        progressBar.isVisible = true
    }

    override fun onNewsClick(newsItem: NewsResponse, position: Int) {
        NewsActivity.newsActivity!!.newsItem = newsItem
        this.context?.let { NewsDialog.buildIntent(it).start(it) }
        //activity!!.startActivity<NewsDialog>()
        activity!!.overridePendingTransition(R.anim.fadein, R.anim.fadeout)
    }

    override fun onLoadArticlesError() {
        Snackbar.make(insightBaseCoordinatorLayout,getString(R.string.articles_load_failed), Snackbar.LENGTH_LONG)
            .setBackgroundTint(ResourcesCompat.getColor(resources, R.color.redBackground, null))
            .setTextColor(ResourcesCompat.getColor(resources, R.color.white, null))
            .show()
    }

    override fun onLoadArticlesSuccessful(items: List<NewsResponse>) {
        updateAdapter(items)
    }


    override fun updateAdapter(items: List<NewsResponse>) {
        adapter.data = items
    }

    private fun setupRecyclerView(){
        adapter =
            NewstemsAdapter(this::onNewsClick)
        itemsRecyclerView?.adapter = adapter
        itemsRecyclerView?.layoutManager = LinearLayoutManager(context)
    }


}

