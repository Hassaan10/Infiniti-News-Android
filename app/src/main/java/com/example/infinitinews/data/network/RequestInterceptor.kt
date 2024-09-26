package com.example.infinitinews.data.network

import okhttp3.Interceptor
import okhttp3.Response

class RequestHeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val modifiedRequest = originalRequest.newBuilder()
            .header("X-Api-Key", "")
            .build()
        return chain.proceed(modifiedRequest)
    }

}