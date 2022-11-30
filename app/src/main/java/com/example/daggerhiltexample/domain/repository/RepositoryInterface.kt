package com.example.daggerhiltexample.domain.repository

import com.example.daggerhiltexample.domain.model.ApiDetailResponse
import retrofit2.Response

interface RepositoryInterface {
    suspend fun netWorkGetRequest(id: String): Response<ApiDetailResponse>
    suspend fun networkListGetRequest() : List<Response<ApiDetailResponse>>
}