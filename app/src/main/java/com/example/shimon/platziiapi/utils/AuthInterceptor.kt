package com.example.shimon.platziiapi.utils

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(val prefManager: PrefManager) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
        request.addHeader("Authorization","Bearer ${prefManager.getPref(Keys.Access_Token)}" )

        return chain.proceed(request.build())


    }
}