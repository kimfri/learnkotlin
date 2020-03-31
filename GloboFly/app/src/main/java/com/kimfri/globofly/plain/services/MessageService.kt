package com.kimfri.globofly.plain.services


import retrofit2.http.Url
import retrofit2.Call
import retrofit2.http.GET

interface MessageService {
    @GET
    fun getMessages(@Url otherUrl: String): Call<String>
}