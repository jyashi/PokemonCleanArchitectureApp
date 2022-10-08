package com.example.daggerhiltexample.data.domain.repository

import com.example.daggerhiltexample.data.network.ApiInterface

class RepositoryImpl(private val api: ApiInterface): RepositoryInterface {
    override suspend fun netWorkGetRequest() {
        TODO("Not yet implemented")
    }
}