package com.kimfri.globofly.weather

import com.kimfri.globofly.weather.response.CurrentWeatherResponse
import com.kimfri.globofly.weather.services.WeatherApiService
import com.kimfri.globofly.weather.services.WeatherServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun main() {
    getWeather("Gothenburg")
}

fun getWeather(city: String) {
    val weatherApiService//This is the interface!!
            = WeatherServiceBuilder.buildService(WeatherApiService::class.java)
    val requestCall = weatherApiService.getCurrentWeather(location = city)

    requestCall.enqueue(object : Callback<CurrentWeatherResponse> {
        override fun onFailure(call: Call<CurrentWeatherResponse>, t: Throwable) {
            println("Fail")
        }

        override fun onResponse(
            call: Call<CurrentWeatherResponse>,
            response: Response<CurrentWeatherResponse>
        ) {
            if (response.isSuccessful) {
                printResponse(response.body())
            }
        }
    })
}

private fun printResponse(currentWeatherResponse: CurrentWeatherResponse?) {
    currentWeatherResponse?.let {
        it.request?.let { request -> printData("Request", request.toString(), printer) }
        it.location?.let { location -> printData("Location", location.toString(), printer) }
        it.currentWeatherEntry?.let { currentWeatherEntry ->
            printData("CurrentWeatherResponse", currentWeatherEntry.toString(), printer)
        }
    }
}

private fun printData(header: String, message: String, action: (String, String) -> Unit) {
    action(header, message)
}

private val printer: (String, String) -> Unit =
    { header, message -> println("$header: $message") }