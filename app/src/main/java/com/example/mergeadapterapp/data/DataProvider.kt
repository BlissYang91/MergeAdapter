package com.example.mergeadapterapp.data

import com.example.mergeadapterapp.domain.News
import com.example.mergeadapterapp.domain.TitleBean
import java.util.Random
import java.util.Timer
import java.util.TimerTask

import java.util.concurrent.TimeUnit

//顶层声明，私有当前文件可见，避免误调,也可以放全局常量
//同一个模块中全局可见
//顶层声明中的方法全局可用，可以直接调用
internal fun createNewsList() = mutableListOf<News>().apply {
    for (i in 1..8) {
        add(News("News $i", "第二个adapter的item内容"))
    }
}
internal fun createTitleList() = mutableListOf<TitleBean>().apply {
    for (i in 1..10) {
        add(TitleBean("title $i", "第一个adapter的item内容"))
    }
}
