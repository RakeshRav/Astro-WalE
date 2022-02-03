package com.example.astro_wale.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.astro_wale.data.common.AstroPicData

@Database(entities = [AstroPicData::class], version = 1)
abstract class AstroPicDatabase : RoomDatabase() {

    abstract fun getAstroPicDao(): AstroPicDao
}