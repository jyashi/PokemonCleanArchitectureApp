package com.example.pokemonCleanArchitectureApp.model

import com.squareup.moshi.Json

data class ApiDetailResponse(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "types")
    val types: List<Any>,
    @Json(name = "sprites")
    val sprites: Map<Any,Any>,
)


