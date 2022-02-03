package com.example.astro_wale.data.remote.retrofit

import com.example.astro_wale.data.common.AstroPicData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AstroPicApi {

    @GET(ApiConstants.END_POINT_ASTRO_API)
    fun getPictureOfTheDay(
        @Query(ApiConstants.QUERY_API_KEY) apiKey: String = ApiConstants.API_KEY,
    ): Response<AstroPicData>
}