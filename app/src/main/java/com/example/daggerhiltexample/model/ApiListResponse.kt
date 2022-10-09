package com.example.daggerhiltexample.model

import com.squareup.moshi.Json

data class ApiListResponse (
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "types")
    val types: List<String>,

)

