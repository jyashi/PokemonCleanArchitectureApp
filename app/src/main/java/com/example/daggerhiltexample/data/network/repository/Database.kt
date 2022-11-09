package com.example.daggerhiltexample.data.network.repository

import android.content.Context
import androidx.room.RoomDatabase
import androidx.room.Database
import androidx.room.Room
import dagger.hilt.android.qualifiers.ApplicationContext

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