package com.example.daggerhiltexample.test_repository

import com.example.daggerhiltexample.data.repository.RepositoryImpl
import com.example.daggerhiltexample.domain.model.ApiDetailResponse
import com.example.daggerhiltexample.domain.repository.RepositoryInterface
import retrofit2.Response

class FakeRepository : RepositoryInterface {
    override suspend fun networkListGetRequest(): List<Response<ApiDetailResponse>> {
        var myList = mutableListOf<Response<ApiDetailResponse>>()
        (1..50).forEach {
            myList.add(netWorkGetRequest(id = it.toString()))
        }

        return myList
    }


    override suspend fun netWorkGetRequest(id: String): Response<ApiDetailResponse> {


        return Response.success(
            ApiDetailResponse(
                id = id.toInt(), name = "name", types = emptyList(), sprites = mapOf()
            )
        )


    }

}