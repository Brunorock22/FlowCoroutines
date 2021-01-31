package com.example.flowstudying.data

import com.example.flowstudying.data.model.NewsArticle
import retrofit2.http.GET

interface ArticlesApi {
    @GET("news.json")
    suspend fun getNews(): List<NewsArticle>
}