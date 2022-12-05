package com.example.pokemonCleanArchitectureApp.data.network.network

import com.example.pokemonCleanArchitectureApp.model.ApiDetailResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("{id}")
    suspend fun getResponseDetails(
        @Path("id") id: String
    ): Response<ApiDetailResponse>
}