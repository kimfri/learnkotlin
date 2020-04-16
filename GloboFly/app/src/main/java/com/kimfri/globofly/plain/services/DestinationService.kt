package com.kimfri.globofly.plain.services

import retrofit2.Call
import retrofit2.http.*
import java.io.FileDescriptor

interface DestinationService {
    @GET("destination")
//    fun getDestinationList(): Call<List<Destination>>
//    if country parameter is null then ALL countries will be retreived
//    The query parameter will be ignored
//    localhost:9000/destination?country=India
//    fun getDestinationList(@Query("country") country: String?): Call<List<Destination>>

//    localhost:9000/destination?country=India&count=1
//    fun getDestinationList(
//        @Query("country") country: String?,
//        @Query("count") count: String?): Call<List<Destination>>

    fun getDestinationList(@QueryMap filter: HashMap<String, String>): Call<List<Destination>>

    @GET("destination/{id}")
    fun getDestination(@Path("id") id: Int): Call<Destination>

    //   Adding new data to service
    @POST("/destination")
    fun addDestnination(@Body newDestination: Destination): Call<Destination>

    @FormUrlEncoded
    @PUT("destination/{id}")
    fun updateDestination(
        @Path("id") id: Int,
        @Field("city") city: String,
        @Field("description") description: String,
        @Field("country") country: String
    ): Call<Destination>

    @PUT("destination/{id}")
    fun updateDestination(
        @Path("id") id: Int,
        @Body updateDestination: Destination
    ): Call<Destination>

    @DELETE("destination/{id}")
    fun deleteDestination(@Path("id") id: Int): Call<Unit>
}