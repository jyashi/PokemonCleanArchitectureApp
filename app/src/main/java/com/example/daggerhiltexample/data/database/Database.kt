package com.example.daggerhiltexample.data.repository

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
        @Volatile
        private var INSTANCE: database? = null

        fun getDatabase(context: Context): database {
            if (INSTANCE == null) {
                synchronized(this) {
                   INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        database::class.java,
                        "pokemon.db"
                    ).build()

                }

            }
            return INSTANCE!!

        }
    }
}