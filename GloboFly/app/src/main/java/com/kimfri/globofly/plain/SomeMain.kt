package com.kimfri.globofly.plain

import com.kimfri.globofly.plain.services.Destination
import com.kimfri.globofly.plain.services.DestinationService
import com.kimfri.globofly.plain.services.MessageService
import com.kimfri.globofly.plain.services.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun main() {
    loadDestinations()
//    loadSpecificDestination(2)
//    loadMessage()
//    uploadNewDestination()
//    updateNewDestination()
//    deleteNewDestination()
}

fun deleteNewDestination() {
    val destinationService = ServiceBuilder.buildService(DestinationService::class.java)
    val requestCall = destinationService.deleteDestination(6)
    requestCall.enqueue(object: Callback<Unit>{
        override fun onFailure(call: Call<Unit>, t: Throwable) { println("Fail") }

        override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
            if(response.isSuccessful) {
                println("Success: ${response.code()}")
            } else {
                println("NO success: ${response.code()}")
            }
        }
    })
}

fun updateNewDestination() {
    val newDestination = Destination(
        city = "Gothenburg",
        country = "Sweden",
        description = "The heart of Scandinavia"
    )
    val destinationService = ServiceBuilder.buildService(DestinationService::class.java)
//    val requestCall = destinationService.updateDestination(
//        6,
//        "Stockholm",
//        "Capitol",
//        "Sweden" )
    val requestCall = destinationService.updateDestination(6, newDestination)
    requestCall.enqueue(object: Callback<Destination> {
        override fun onFailure(call: Call<Destination>, t: Throwable) { println("Fail") }

        override fun onResponse(call: Call<Destination>, response: Response<Destination>) {
            if(response.isSuccessful) {
                val updatedDestination = response.body()
                updatedDestination?.let {
                    println("Destination: ${updatedDestination.city} " +
                            "were created with id: ${updatedDestination.id}")
                }
            }
        }
    })
}

fun uploadNewDestination() {
    val newDestination = Destination(
        city = "Gothenburg",
        country = "Sweden",
        description = "The heart of Scandinavia"
    )

    val destinationService = ServiceBuilder.buildService(DestinationService::class.java)
    val requestCall = destinationService.addDestnination(newDestination)
    requestCall.enqueue(object: Callback<Destination> {
        override fun onFailure(call: Call<Destination>, t: Throwable) { println("Fail") }

        override fun onResponse(call: Call<Destination>, response: Response<Destination>) {
            if (response.isSuccessful) {
                val destination = response.body()
                destination?.let {
                    println("Destination: ${destination.city} were created with id: ${destination.id}")
                }
            }
        }

    })
}

fun loadMessage() {
    val messageService = ServiceBuilder.buildService(MessageService::class.java)
    val requestCall = messageService.getMessages("http://localhost:8000/messages")

    requestCall.enqueue(object: Callback<String> {
        override fun onFailure(call: Call<String>, t: Throwable) {
            println("Fail")
        }

        override fun onResponse(call: Call<String>, response: Response<String>) {
            if (response.isSuccessful) {
                val message = response.body()
                message?.let {
                    println(it)
                }
            }
        }

    })
}

/*
* Path paramters i.e. localhost:9000/destination/2
* */
fun loadSpecificDestination(id: Int) {
    val destinationService = ServiceBuilder.buildService((DestinationService::class.java))
    val requestCall = destinationService.getDestination(id)

//    This is a "lambda call"
    requestCall.enqueue(object: Callback<Destination> {
        override fun onFailure(call: Call<Destination>, t: Throwable) { println("Fail") }

        override fun onResponse(call: Call<Destination>, response: Response<Destination>) {
            if (response.isSuccessful) {
                val destination = response.body()
                destination?.let {
                    println("id: ${destination.id}")
                    println("city: ${destination.city}")
                    println("description: ${destination.description}")
                    println("country: ${destination.country}")
                }
             } else { println("Destination is empty") }
        }
    })
}

/**
 * Retrieve data from webserverd
 *
 * */
fun loadDestinations() {
   val destinationService=
       ServiceBuilder.buildService(DestinationService::class.java)
//    val requestCall = destinationService.getDestinationList()
//    val requestCall = destinationService.getDestinationList("India", "2")

    val filter = HashMap<String, String>()
//    filter["country"] = "India"
//    filter.put("count", "1")
    val requestCall = destinationService.getDestinationList(filter)

    requestCall.enqueue(object: Callback<List<Destination>>{
        override fun onResponse(
            call: Call<List<Destination>>,
            response: Response<List<Destination>>
        ) {
            println("response.code. ${response.code()}")
            if(response.isSuccessful) {
                val destinationList = response.body()!!
                destinationList.forEach {
                    println("Country: ${it.country}")
                    println("City: ${it.city}")
                }
            }
        }

        override fun onFailure(call: Call<List<Destination>>, t: Throwable) {
            println("Fail")
            t.printStackTrace()
        }
    })
}