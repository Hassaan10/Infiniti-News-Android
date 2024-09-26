package com.example.infinitinews.data.network

import com.example.infinitinews.data.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {

    @GET("everything?q=keyword")
    suspend fun getAllNews(): NewsResponse

    @GET("top-headlines")
    suspend fun getHeadLinesNews(@Query("country") locale:String): NewsResponse
}