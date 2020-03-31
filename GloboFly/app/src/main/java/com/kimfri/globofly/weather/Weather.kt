package com.kimfri.globofly.weather


import com.kimfri.globofly.weather.response.*
import com.kimfri.globofly.weather.services.WeatherApiService
import com.kimfri.globofly.weather.services.WeatherServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun main() {
//    getWeather("Gothenburg")
    getWeather("Stockholm")
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
                displayData(response.body())
            }
        }
    })
}
private fun displayData(currentWeatherResponse: CurrentWeatherResponse?) {
    currentWeatherResponse?.let {
        displayDataToCommmandLine(it.request)
        displayDataToCommmandLine(it.location)
        displayDataToCommmandLine(it.currentWeatherEntry)
    }
}
private fun displayDataToCommmandLine(currentObj: WeatherData?) {
    currentObj?.let {
        when(it) {
            is Request -> printData("Request", it.toString(), printer)
            is Location -> printData("Location", it.toString(), printer)
            is CurrentWeatherEntry -> printData("CWE", it.toString(), printer)
            else -> println("Error")
        }
    }
}

private fun printData(header: String, message: String, action: (String, String) -> Unit) {
    action(header, message)
}

private val printer: (String, String) -> Unit =
    { header, message -> println("$header: $message") }