package com.example.astro_wale.domain.repositories

import com.example.astro_wale.data.common.AstroPicData
import com.example.astro_wale.others.Resource

interface AstroPicRepository {

    suspend fun insertAstroPicData(astroPicData: AstroPicData)

    suspend fun getPicOfTheDay(): Resource<AstroPicData>
}