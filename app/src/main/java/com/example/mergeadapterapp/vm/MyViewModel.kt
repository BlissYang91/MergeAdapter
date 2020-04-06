package com.example.mergeadapterapp.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mergeadapterapp.domain.News
import com.example.mergeadapterapp.domain.TitleBean

/**
 * @Author yangtianfu
 * @CreateTime 2020/4/6 15:55
 * @Describe vm获取并提供数据
 */
class MyViewModel:ViewModel() {
    var listTitleBean = MutableLiveData<List<TitleBean>>()
    var listNews = MutableLiveData<List<News>>()
    //第一个adapter数据
    fun getTitleData(){
        var data = listOf(
            TitleBean("TitleBean1","TitleBean1 第一个adapter"),
            TitleBean("TitleBean2","TitleBean2 第一个adapter"),
            TitleBean("TitleBean3","TitleBean3 第一个adapter"),
            TitleBean("TitleBean4","TitleBean4 第一个adapter"),
            TitleBean("TitleBean5","TitleBean5 第一个adapter"),
            TitleBean("TitleBean6","TitleBean6 第一个adapter"),
            TitleBean("TitleBean7","TitleBean7 第一个adapter")
        )
        listTitleBean.value = data
    }
    //第二个adapter数据
    fun getNewsData(){
        var data = listOf(
            News("NewsBean1","NewsBean1 第二个adapter"),
            News("NewsBean2","NewsBean2 第二个adapter"),
            News("NewsBean3","NewsBean3 第二个adapter"),
            News("NewsBean4","NewsBean4 第二个adapter"),
            News("NewsBean5","NewsBean5 第二个adapter"),
            News("NewsBean6","NewsBean6 第二个adapter"),
            News("NewsBean7","NewsBean7 第二个adapter")
        )
        listNews.value = data
    }


}