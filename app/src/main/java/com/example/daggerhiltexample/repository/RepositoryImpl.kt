package com.example.daggerhiltexample.repository

import android.app.Application
import com.example.daggerhiltexample.data.network.ApiInterface
import com.example.daggerhiltexample.model.ApiDetailResponse
import retrofit2.Call
import retrofit2.Response

class RepositoryImpl(private val api: ApiInterface, private val appConext: Application):
    RepositoryInterface {
    override suspend fun netWorkGetRequest(id: String): Response<ApiDetailResponse> {
        return api.getResponseDetails(id)
    }
}