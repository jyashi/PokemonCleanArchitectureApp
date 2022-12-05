package com.example.pokemonCleanArchitectureApp

import com.example.pokemonCleanArchitectureApp.model.ApiDetailResponse
import org.junit.Before
import org.junit.Test

class ViewModelTest {
    private var  resultList = mutableListOf<ApiDetailResponse>()
    val maxItems = 50

    @Before
    fun setup() {

        (1..maxItems).forEach {
            resultList.add(
                ApiDetailResponse(
                id = it,
                name = "Poekmon_$it",
                types = listOf(),
                    sprites = mapOf()
            )
            )
        }
    }
    @Test
    fun `test data size is correct`() {
        assert(resultList.size == maxItems)
    }

    @Test
    fun `ID is non zero`() {
    resultList.forEach {
        assert(it.id!=0)
    }
    }



}