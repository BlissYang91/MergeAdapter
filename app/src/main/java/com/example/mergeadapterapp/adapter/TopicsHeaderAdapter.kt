package com.example.mergeadapterapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mergeadapterapp.databinding.ItemTopicsHeaderBinding

/**
 * @Author yangtianfu
 * @CreateTime 2020/4/6 12:02
 * @Describe
 */
class TopicsHeaderAdapter: RecyclerView.Adapter<TopicsHeaderViewHolder>() {
    var onTopicsHeaderListener: ((String) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicsHeaderViewHolder =
        TopicsHeaderViewHolder(
            ItemTopicsHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onTopicsHeaderListener)

    override fun getItemCount()=HEADER

    override fun onBindViewHolder(holder: TopicsHeaderViewHolder, position: Int) {
        holder.bind()
    }

    companion object {
        private const val HEADER = 5
    }
    fun onClear() {
        onTopicsHeaderListener = null
    }
}