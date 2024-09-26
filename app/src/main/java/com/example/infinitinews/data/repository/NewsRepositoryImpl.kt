package com.example.infinitinews.data.repository

import com.example.infinitinews.data.network.ApiResponse
import com.example.infinitinews.data.network.NetworkService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.Locale
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(private val apiService:NetworkService): NewsRepository {
    override suspend fun getHeadLines(): Flow<ApiResponse> {
        return flow {
            emit(ApiResponse.Loading)
            try {
                val result = apiService.getHeadLinesNews(Locale.getDefault().country)
                emit(ApiResponse.Success(result.articles))
            }
            catch (e: Exception) {
                emit(ApiResponse.Error(e))
            }
        }
    }

    override suspend fun getAllNews(): Flow<ApiResponse> {
        return flow {
            emit(ApiResponse.Loading)
            try {
                val result = apiService.getAllNews()
                emit(ApiResponse.Success(result.articles))
            }
            catch (e: Exception) {
                emit(ApiResponse.Error(e))
            }
        }
    }
}