package com.example.flowstudying.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flowstudying.R
import com.example.flowstudying.viewmodel.NewArticleViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val newsListAdapter = ListViewAdapter()
    private lateinit var viewModel: NewArticleViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(NewArticleViewModel::class.java)
        news_recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = newsListAdapter
        }
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.articles.observe(this, Observer { article ->
            newsListAdapter.onAddNewsItem(article)
            news_recyclerView.smoothScrollToPosition(0)
        })
    }
}