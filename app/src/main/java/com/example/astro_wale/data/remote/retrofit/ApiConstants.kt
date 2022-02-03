package com.example.astro_wale.data.remote.retrofit

import com.example.astro_wale.BuildConfig

object ApiConstants {
    const val API_BASE_URL = "https://api.nasa.gov"
    const val API_KEY = BuildConfig.API_KEY

    //region api end points
    const val END_POINT_ASTRO_API = "/planetary/apod"

    //endregion


    //region api query params
    const val QUERY_API_KEY = "api_key"

}