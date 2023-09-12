package com.ereyes.horoscapp.data.network

import com.ereyes.horoscapp.data.RepositoryImpl
import com.ereyes.horoscapp.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/****
 * Project: HoroscApp
 * From: com.ereyes.horoscapp.data.network
 * Created by Edgar Reyes Gonzalez on 9/11/2023 at 8:29 AM
 * All rights reserved 2023.
 ****/

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://newastro.vercel.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideHoroscopeApiService(retrofit: Retrofit): HoroscopeApiService{
        return retrofit.create(HoroscopeApiService::class.java)
    }

    @Provides
    fun provideRepository(apiService: HoroscopeApiService): Repository{
        return RepositoryImpl(apiService)
    }
}