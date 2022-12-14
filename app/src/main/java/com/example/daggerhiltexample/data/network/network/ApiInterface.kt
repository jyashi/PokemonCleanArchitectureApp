package com.example.daggerhiltexample.data.network.network

import com.example.daggerhiltexample.model.ApiDetailResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("{id}")
    suspend fun getResponseDetails(
        @Path("id") id: String
    ): Response<ApiDetailResponse>
}