package com.example.flowstudying.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import com.example.flowstudying.data.ArticlesRepository

class NewArticleViewModel(application: Application) : AndroidViewModel(application) {
    var articles = ArticlesRepository.getNewsArticles().asLiveData()
}