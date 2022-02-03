package com.example.astro_wale.domain.repositories

import com.example.astro_wale.data.common.AstroPicData
import com.example.astro_wale.data.local.AstroPicDao
import com.example.astro_wale.data.remote.retrofit.AstroPicApi
import com.example.astro_wale.others.Resource
import javax.inject.Inject

class AppRepository @Inject constructor(
    private val astroPicDao: AstroPicDao,
    private val astroPicApi: AstroPicApi,
) : AstroPicRepository {

    override suspend fun insertAstroPicData(astroPicData: AstroPicData) {
        astroPicDao.insertAstroPicData(astroPicData)
    }

    override suspend fun getPicOfTheDay(): Resource<AstroPicData> {
        return try {
            val response = astroPicApi.getPictureOfTheDay()
            if (response.isSuccessful) {
                response.body()?.let {
                    Resource.success(it)
                } ?: Resource.error("data not received", null)
            } else {
                Resource.error("Something went wrong", null)
            }
        } catch (e: Exception) {
            Resource.error("Something went wrong exception : ${e.localizedMessage}", null)
        }
    }
}