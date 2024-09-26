package com.example.infinitinews.data.network

import com.example.infinitinews.data.model.Article

sealed class ApiResponse {
    data object Loading: ApiResponse()
    data class Success(val data: List<Article>?) : ApiResponse()
    data class Error(val error: Exception) : ApiResponse()
}