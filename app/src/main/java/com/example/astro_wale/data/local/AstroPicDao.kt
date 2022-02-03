package com.example.astro_wale.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.astro_wale.data.common.AstroPicData

@Dao
interface AstroPicDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAstroPicData(astroPicData: AstroPicData)

    @Query("SELECT * FROM ASTRO_PICTURE_DATA WHERE id=:id")
    fun getAstroApiData(id: Int): AstroPicData
}