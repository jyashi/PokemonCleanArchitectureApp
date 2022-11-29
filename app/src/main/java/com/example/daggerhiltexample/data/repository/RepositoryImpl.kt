package com.example.daggerhiltexample.data.repository

import android.app.Application
import com.example.daggerhiltexample.data.network.ApiInterface
import com.example.daggerhiltexample.domain.model.ApiDetailResponse
import com.example.daggerhiltexample.domain.repository.RepositoryInterface
import retrofit2.Response

class RepositoryImpl(private val api: ApiInterface, private val appConext: Application):
    RepositoryInterface {
    override suspend fun netWorkGetRequest(id: String): Response<ApiDetailResponse> {
        return api.getResponseDetails(id)
    }
}