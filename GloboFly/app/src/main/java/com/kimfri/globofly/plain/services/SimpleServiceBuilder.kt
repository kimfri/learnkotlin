package com.kimfri.globofly.plain.services

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SSimpleServiceBuilder {

    private const val URL = "http://localhost:9000"

    private val builder = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())

    private val retrofit = builder.build()

    private fun <T> simpleBuildService(serviceType: Class<T>): T {
        return retrofit.create(serviceType)
    }

    fun getSome(): DestinationService {
        return simpleBuildService(DestinationService::class.java)
    }
}