package com.kimfri.globofly.plain.services

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

object ServiceBuilder {

    private const val URL = "http://localhost:9000"
    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    val headerInterceptor= object: Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            var request = chain.request()
            request = request.newBuilder()
//                .addHeader("x-device-type", Build.DEVICE)
                .addHeader("Accept-Language", Locale.getDefault().language)
                .build()
            val response = chain.proceed(request)
            return response
        }
    }

    private val okHttp: OkHttpClient.Builder = OkHttpClient.Builder()
//        .writeTimeout(5, TimeUnit.SECONDS)
//        .readTimeout(5, TimeUnit.SECONDS)
//        .connectTimeout(15, TimeUnit.SECONDS) All operations including redirecting an so forth
        .addInterceptor(headerInterceptor)
        .addInterceptor(logger)

    private val builder = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp.build())

    private val retrofit = builder.build()

    fun<T> buildService(serviceType: Class<T>): T {
        return retrofit.create(serviceType)
    }
}