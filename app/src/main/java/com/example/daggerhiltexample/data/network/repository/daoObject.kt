package com.example.daggerhiltexample.data.network.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.daggerhiltexample.model.ApiDetailResponse

@Dao
interface daoObject {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(cacheData: PokemonDataObject)

    @Query("SELECT * FROM PokemonDataObject")
    suspend fun getListData(): List<PokemonDataObject>

}