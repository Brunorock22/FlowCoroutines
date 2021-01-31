package com.example.flowstudying.data

import com.example.flowstudying.data.model.NewsArticle
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ArticlesRepository {
    private const val BASE_URL = "https://raw.githubusercontent.com/DevTides/NewsApi/master/"
    private const val NEWS_DELAY = 2000L

    private fun initRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private val newsApi: ArticlesApi = initRetrofit().create(ArticlesApi::class.java)

    fun getNewsArticles(): kotlinx.coroutines.flow.Flow<NewsArticle> {
        return flow {
            var newsSource = newsApi.getNews()
            newsSource.forEach {
                emit(it)
                delay(NEWS_DELAY)
            }
        }
    }


}