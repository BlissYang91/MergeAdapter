package com.example.mergeadapterapp.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.mergeadapterapp.domain.News

/**
 * @Author yangtianfu
 * @CreateTime 2020/4/6 11:52
 * @Describe
 */
class NewsDiffCallback: DiffUtil.ItemCallback<News>() {
    override fun areItemsTheSame(oldItem: News, newItem: News)=
        oldItem.title == newItem.title && oldItem.dateCategory == newItem.dateCategory

    override fun areContentsTheSame(oldItem: News, newItem: News)= oldItem == newItem
}