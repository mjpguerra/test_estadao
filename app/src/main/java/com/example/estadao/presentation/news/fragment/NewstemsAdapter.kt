package com.example.estadao.presentation.news.fragment

import android.view.View
import androidx.fragment.app.FragmentManager
import com.example.estadao.R
import com.example.estadao.core.common.BaseAdapter
import com.example.estadao.core.extensions.loadImage
import com.example.estadao.presentation.news.dialog.NewsDialog
import com.example.estadao.repository.remote.estadao.responses.NewsResponse
import kotlinx.android.synthetic.main.item_news.view.*

class NewstemsAdapter(private val newsAction: (NewsResponse, Int) -> Unit): BaseAdapter<NewsResponse>() {

    override val layoutResource = R.layout.item_news

    override fun bind(itemView: View, item: NewsResponse, position: Int) {
        itemView.newsTitle.text = item.titulo
        itemView.articleImage.loadImage(item.imagem, false, R.drawable.ic_no_image_found)
        itemView.articleDescription.text = item.linha_fina
        itemView.articleImage.setOnClickListener { newsAction.invoke(item, position) }
    }

}