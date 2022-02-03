package com.example.astro_wale.di.module

import android.content.Context
import androidx.room.Room
import com.example.astro_wale.data.local.AstroPicDao
import com.example.astro_wale.data.local.AstroPicDatabase
import com.example.astro_wale.data.local.DBConstants
import com.example.astro_wale.data.remote.retrofit.ApiConstants
import com.example.astro_wale.data.remote.retrofit.AstroPicApi
import com.example.astro_wale.domain.repositories.AppRepository
import com.example.astro_wale.domain.repositories.AstroPicRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideAstroPicApi(): AstroPicApi {
        return Retrofit.Builder()
            .baseUrl(ApiConstants.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(AstroPicApi::class.java)
    }

    @Provides
    @Singleton
    fun provideAstroDatabase(
        @ApplicationContext context: Context,
    ): AstroPicDatabase {
        return Room.databaseBuilder(
            context,
            AstroPicDatabase::class.java,
            DBConstants.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideAstroPicDao(
        astroPicDatabase: AstroPicDatabase,
    ): AstroPicDao {
        return astroPicDatabase.getAstroPicDao()
    }

    @Provides
    @Singleton
    fun providesAstroAppRepository(
        dao: AstroPicDao,
        astroPicApi: AstroPicApi,
    ): AstroPicRepository {
        return AppRepository(dao, astroPicApi)
    }
}