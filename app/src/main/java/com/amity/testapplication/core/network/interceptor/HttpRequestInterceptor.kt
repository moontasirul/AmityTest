package com.amity.testapplication.core.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import timber.log.Timber

/**
 * This [HttpRequestInterceptor] intercept all request and print the request URL using [Timber]
 */
class HttpRequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val request = originalRequest.newBuilder().url(originalRequest.url).build()
        Timber.d("request_url", request.toString())
        return chain.proceed(request)
    }
}