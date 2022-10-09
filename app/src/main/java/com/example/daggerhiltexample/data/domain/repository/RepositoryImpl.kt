package com.example.daggerhiltexample.data.domain.repository

import android.app.Application
import com.example.daggerhiltexample.data.network.ApiInterface

class RepositoryImpl(private val api: ApiInterface, private val appConext: Application): RepositoryInterface {
    override suspend fun netWorkGetRequest() {
        TODO("Not yet implemented")
    }
}