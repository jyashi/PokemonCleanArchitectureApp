package com.example.pokemonCleanArchitectureApp.data.network.repository

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PokemonDataObject(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val type: String,
    val sprite: String,
)


