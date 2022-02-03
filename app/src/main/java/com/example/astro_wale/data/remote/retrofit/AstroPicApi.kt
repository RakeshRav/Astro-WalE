package com.example.astro_wale.data.remote.retrofit

import com.example.astro_wale.data.remote.responses.AstroApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AstroPictureApi {

    @GET(ApiConstants.END_POINT_ASTRO_API)
    fun getPictureOfTheDay(
        @Query(ApiConstants.QUERY_API_KEY) apiKey: String,
    ): Response<AstroApiResponse>
}