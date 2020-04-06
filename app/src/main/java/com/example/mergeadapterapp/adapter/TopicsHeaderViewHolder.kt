package com.example.mergeadapterapp.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.mergeadapterapp.R
import com.example.mergeadapterapp.databinding.ItemTopicsHeaderBinding

/**
 * @Author yangtianfu
 * @CreateTime 2020/4/6 12:03
 * @Describe viewHolder
 */
class TopicsHeaderViewHolder(private val binding: ItemTopicsHeaderBinding, private val onTopicsHeaderListener: ((String) -> Unit)?)  : RecyclerView.ViewHolder(binding.root){
    //run函数最后一行作为返回值
    fun bind() = itemView.run {
        val headerTitle = context.getString(R.string.header_text)
        binding.titleTextView.text = headerTitle
        setOnClickListener { onTopicsHeaderListener?.invoke(headerTitle) }
    }
}