package com.example.mergeadapterapp.vm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mergeadapterapp.domain.News
import com.example.mergeadapterapp.domain.TitleBean
import com.example.myapp.bean.Article
import com.example.myapp.bean.WBean
import com.wjx.android.wanandroidmvvm.base.https.ApiService
import com.wjx.android.wanandroidmvvm.base.https.RetrofitFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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

    //网络数据
    //   vm持有数据层引用，并利用livedata赋值更新UI
        private val _articleListData = MutableLiveData<List<Article>>()
        //保证外部只能观察此数据，不同通过setValue修改 model调用articleListData拿到网络请求数据交个观察者，但是不能修改
        val articleListData: LiveData<List<Article>> = _articleListData

        private val _errorMsg = MutableLiveData<String?>()
        val errorMsg: LiveData<String?> = _errorMsg

        fun fetch(page:Int){
            viewModelScope.launch {
                var result = RetrofitFactory.instance.getService(ApiService::class.java).getArticleList(page)
                //请求到的数据用livedata包裹
                _articleListData.value = result.data.datas
            }

        }


}