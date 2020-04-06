package com.example.mergeadapterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.MergeAdapter
import com.example.mergeadapterapp.adapter.*
import com.example.mergeadapterapp.data.createNewsList
import com.example.mergeadapterapp.data.createTitleList
import com.example.mergeadapterapp.databinding.ActivityMainBinding
import com.example.mergeadapterapp.domain.News
import com.example.mergeadapterapp.domain.TitleBean
import com.example.mergeadapterapp.vm.MyViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @Author yangtianfu
 * @CreateTime 2020/4/6 12:07
 * @Describe 
 */
class MainActivity : AppCompatActivity() {
    lateinit var myViewModel: MyViewModel
    private var mAdapter1 : MyAdapter<TitleBean>? =null
    private var mAdapter2 : MyAdapter1<News>? =null
    lateinit var binding:ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        myViewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)
//       本地数据获取方式一
//        myViewModel.getTitleData()
//        myViewModel.getNewsData()
//       本地数据获取方式二
       myViewModel.listTitleBean.value = createTitleList()
       myViewModel.listNews.value = createNewsList()
        initRecyclerView()

        // ViewModel获取网络数据 协程请求网络数据
        myViewModel.fetch(1)

        observerNetData()

    }

    /**
     * 监听网络请求数据
     */
    private fun observerNetData() {
        //观察文章列表数据
        myViewModel.articleListData.observe(this, Observer { list ->
            //articleListData 的值改变时触发此监听
            Toast.makeText(this,"网络数据请求成功：${list.toString()}",Toast.LENGTH_SHORT).show()
        })
    }

    private fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        mAdapter1 =  MyAdapter(R.layout.item_topics_header)
        mAdapter2 =  MyAdapter1(R.layout.item_news)
        val mergeAdapter = MergeAdapter(mAdapter1,mAdapter2)
        binding.recyclerView.adapter = mergeAdapter
        binding.recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        mAdapter1?.setOnItemClickListener(object : BaseAdapter.OnItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                showSnackbar("点击mAdapter1 - ${position}")
            }
        })
        mAdapter2?.setOnItemClickListener(object : BaseAdapter.OnItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                showSnackbar("点击mAdapter2 - ${position}")
            }
        })

        myViewModel.listTitleBean.observe(this, Observer {
            mAdapter1!!.refreshData(it)
            mAdapter1?.notifyDataSetChanged()
        })
        myViewModel.listNews.observe(this, Observer {
            mAdapter2!!.refreshData(it)
            mAdapter2?.notifyDataSetChanged()
        })
    }

    private fun showSnackbar(message: String) = Snackbar.make(window.decorView, message, Snackbar.LENGTH_SHORT).show()

}
