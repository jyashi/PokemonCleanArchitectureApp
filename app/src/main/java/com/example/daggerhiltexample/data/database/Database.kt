package com.example.daggerhiltexample.data.database

import android.content.Context
import androidx.room.RoomDatabase
import androidx.room.Database
import androidx.room.Room
import com.example.daggerhiltexample.data.database.daoObject
import com.example.daggerhiltexample.domain.model.PokemonDataObject

@Database(
    entities = [PokemonDataObject::class],
    version = 1
)
abstract class database : RoomDatabase() {
    abstract val dao: daoObject

    companion object {
        const val DATABASE_NAME = "pokemon.db"

    }
}