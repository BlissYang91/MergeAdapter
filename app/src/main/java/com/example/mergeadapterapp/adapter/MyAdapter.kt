package com.example.mergeadapterapp.adapter

import androidx.databinding.ViewDataBinding
import com.example.mergeadapterapp.BR

/**
 * @Author yangtianfu
 * @CreateTime 2020/4/2 16:59
 * @Describe recycleView通用adapter
 */
class MyAdapter<T> constructor(layout:Int) : BaseAdapter<T>() {
    var layout:Int = layout
    private lateinit var onItemClickListener: OnItemClickListener

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.onItemClickListener = listener
    }
    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        var binding : ViewDataBinding = holder.dataBinding
        binding.setVariable(BR.myData,data.get(position))
        holder.itemView.setOnClickListener {
            onItemClickListener.onItemClick(holder.itemView,position)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return this.layout
    }
}