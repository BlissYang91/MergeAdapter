package com.example.mergeadapterapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.mergeadapterapp.databinding.ItemNewsBinding
import com.example.mergeadapterapp.domain.News

/**
 * @Author yangtianfu
 * @CreateTime 2020/4/6 11:48
 * @Describe
 */
class NewsAdapter : ListAdapter<News, NewsViewHolder> (NewsDiffCallback()){
    var onNewsListener: ((News) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        NewsViewHolder(ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false), onNewsListener)

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = getItem(position)
        holder.bind(news)
    }

    fun onClear() {
        onNewsListener = null
    }
}