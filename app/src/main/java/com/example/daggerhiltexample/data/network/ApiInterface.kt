package com.example.daggerhiltexample.data.network
import retrofit2.http.GET
interface ApiInterface {
    @GET("test")
    suspend fun networkGetRequest()
}