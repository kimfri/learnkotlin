package com.kimfri.globofly.weather.services

import com.kimfri.globofly.weather.response.CurrentWeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("current")
    fun getCurrentWeather(
        @Query("query") location: String,
        @Query("units") units: String = "m"
    ): Call<CurrentWeatherResponse>

    @GET("current")
    fun getSomething(): Call<CurrentWeatherResponse>
}