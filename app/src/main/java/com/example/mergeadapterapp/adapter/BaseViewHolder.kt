package com.example.mergeadapterapp.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * @Author yangtianfu
 * @CreateTime 2020/4/2 16:56
 * @Describe recycleView封装ViewHolder
 */
open class BaseViewHolder(var dataBinding: ViewDataBinding):RecyclerView.ViewHolder(dataBinding.root) {
}