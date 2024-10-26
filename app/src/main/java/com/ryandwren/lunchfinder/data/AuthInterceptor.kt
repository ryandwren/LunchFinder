package com.ryandwren.lunchfinder.data

import com.ryandwren.lunchfinder.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val urlAppended = chain.request().url().newBuilder()
        urlAppended.addQueryParameter("key", BuildConfig.googlePlacesAPIKey)
        return chain.proceed(chain.request().newBuilder().url(urlAppended.build()).build())
    }
}