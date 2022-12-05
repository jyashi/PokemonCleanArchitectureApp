package com.example.pokemonCleanArchitectureApp.repository

import android.app.Application
import com.example.pokemonCleanArchitectureApp.data.network.network.ApiInterface
import com.example.pokemonCleanArchitectureApp.model.ApiDetailResponse
import retrofit2.Response

class RepositoryImpl(private val api: ApiInterface, private val appConext: Application):
    RepositoryInterface {
    override suspend fun netWorkGetRequest(id: String): Response<ApiDetailResponse> {
        return api.getResponseDetails(id)
    }
}