package com.example.daggerhiltexample

import com.example.daggerhiltexample.domain.model.ApiDetailResponse
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ApiResponseTest() {
    private lateinit var response: ApiDetailResponse

    @Before
    fun setUp(){
        response = ApiDetailResponse(
            id = 0, name = "name",types = listOf("fire","water"), sprites = mapOf("sprite" to "sprite")

        )
    }

    @Test
    fun `Check if response type is correct` () {
        assertEquals(response.id is Int,true)
        assertEquals(response.name is String,true)
        assertEquals(response.types is List<*>,true)
        assertEquals(true,true)
    }
}