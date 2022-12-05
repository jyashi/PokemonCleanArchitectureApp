package com.example.pokemonCleanArchitectureApp.repository

import com.example.pokemonCleanArchitectureApp.model.ApiDetailResponse
import retrofit2.Response

interface RepositoryInterface {
    suspend fun netWorkGetRequest(id: String): Response<ApiDetailResponse>

}