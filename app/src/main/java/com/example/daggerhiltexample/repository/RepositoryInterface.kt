package com.example.daggerhiltexample.repository

import com.example.daggerhiltexample.model.ApiDetailResponse
import retrofit2.Call
import retrofit2.Response

interface RepositoryInterface {
    suspend fun netWorkGetRequest(id: String): Response<ApiDetailResponse>

}