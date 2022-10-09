package com.example.daggerhiltexample.data.network

import com.example.daggerhiltexample.model.ApiDetailResponse
import com.example.daggerhiltexample.model.ApiListResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("api/v2/pokemon/{id}/")
    suspend fun getResponseList(): Response<ApiListResponse>
    suspend fun getResponseDetails(): Response<ApiDetailResponse>
}