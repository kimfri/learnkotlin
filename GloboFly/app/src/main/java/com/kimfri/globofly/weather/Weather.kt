package com.kimfri.globofly.weather

import com.kimfri.globofly.weather.response.CurrentWeatherResponse
import com.kimfri.globofly.weather.services.WeatherApiService
import com.kimfri.globofly.weather.services.WeatherServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun main() {
    getWeather("Gothenburg")
    getSomeWeather()
}

fun getWeather(city: String) {
    val weatherApiService
            = WeatherServiceBuilder.buildService(WeatherApiService::class.java)
    val requestCall = weatherApiService.getCurrentWeather(city)

    requestCall.enqueue(object: Callback<CurrentWeatherResponse>{
        override fun onFailure(call: Call<CurrentWeatherResponse>, t: Throwable) { println("Fail")}
        override fun onResponse(
            call: Call<CurrentWeatherResponse>,
            response: Response<CurrentWeatherResponse>
        ) {
            if(response.isSuccessful) {
                val currentWeatherResponse = response.body()
                currentWeatherResponse?.let {
                    val location = it.location
                    println("Location: ${location.toString()}")

                    val currentWeatherEntry = it.currentWeatherEntry
                    currentWeatherEntry?.let {
                        println("CurrentWeatherEntry found:")
                        println(currentWeatherEntry.toString())
                    }
                }
            }
        }

    })
}

fun getSomeWeather() {
//    weatherApiService is the interface
    val weatherApiService
            = WeatherServiceBuilder.buildService(WeatherApiService::class.java)
    val requestCall = weatherApiService.getSomething()

    requestCall.enqueue(object: Callback<CurrentWeatherResponse>{
        override fun onFailure(call: Call<CurrentWeatherResponse>, t: Throwable) { println("Fail")}
        override fun onResponse(
            call: Call<CurrentWeatherResponse>,
            response: Response<CurrentWeatherResponse>
        ) {
            if(response.isSuccessful) {

            }
        }
    })
}