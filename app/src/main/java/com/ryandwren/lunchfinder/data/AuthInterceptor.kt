package com.ryandwren.lunchfinder.data

import com.ryandwren.lunchfinder.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
        requestBuilder.addHeader("key", BuildConfig.googlePlacesAPIKey)
        return chain.proceed(requestBuilder.build())
    }
}