package com.example.mergeadapterapp.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.mergeadapterapp.databinding.ItemNewsBinding
import com.example.mergeadapterapp.domain.News

/**
 * @Author yangtianfu
 * @CreateTime 2020/4/6 11:49
 * @Describe
 */
class NewsViewHolder(private val binding: ItemNewsBinding, private val onNewsListener: ((News) -> Unit)?): RecyclerView.ViewHolder(binding.root){
    fun bind(news: News) = news.run {
        binding.dateCategoryTextView.text = dateCategory
        binding.titleTextView.text = title
        itemView.setOnClickListener { onNewsListener?.invoke(this) }
    }
}