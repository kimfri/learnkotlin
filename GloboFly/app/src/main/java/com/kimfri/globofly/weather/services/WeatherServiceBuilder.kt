package com.kimfri.globofly.weather.services

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val URL = "http://api.weatherstack.com"
private const val API_KEY = "98bf87a53873b86889c10c0b31d47ebc"
private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

object WeatherServiceBuilder {

    private val urlInterceptor= Interceptor { chain ->
        val url = chain
            .request()
            .url()
            .newBuilder()
            .addEncodedQueryParameter("access_key", API_KEY)
            .build()
        val request = chain.request()
            .newBuilder()
            .url(url)
            .build()
        return@Interceptor chain.proceed(request)
    }

    private val okHttp: OkHttpClient.Builder = OkHttpClient.Builder()
        .addInterceptor(urlInterceptor)
        .addInterceptor(logger)

    private val builder = Retrofit.Builder()
        .client(okHttp.build())
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())

    private val retrofit = builder.build()

    fun<T> buildService(serviceType: Class<T>): T {
        return retrofit.create(serviceType)
    }
}