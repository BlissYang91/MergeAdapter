package com.example.mergeadapterapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView

/**
 * @Author yangtianfu
 * @CreateTime 2020/4/2 16:50
 * @Describe recycleView统配adapter
 */
abstract class BaseAdapter<T>(var data: List<T> = listOf()):RecyclerView.Adapter<BaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder{
        return BaseViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent?.context), viewType, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun refreshData(newData: List<T>) {
        this.data = newData
        this.notifyDataSetChanged()
    }
    //  增加点击和长按事件
    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
//        fun onItemLongClick(view: View,position: Int): Boolean
    }

}