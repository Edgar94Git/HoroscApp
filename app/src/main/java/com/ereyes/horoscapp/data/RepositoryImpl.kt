package com.ereyes.horoscapp.data
import com.ereyes.horoscapp.data.network.HoroscopeApiService
import com.ereyes.horoscapp.data.network.response.toDomain
import com.ereyes.horoscapp.domain.Repository
import com.ereyes.horoscapp.domain.model.PredictionModel
import javax.inject.Inject

/****
 * Project: HoroscApp
 * From: com.ereyes.horoscapp.data
 * Created by Edgar Reyes Gonzalez on 9/10/2023 at 2:37 PM
 * All rights reserved 2023.
 ****/
class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService): Repository {
    override suspend fun getPrediction(sign: String): PredictionModel? {
        runCatching{ apiService.getHoroscope(sign) }
            .onSuccess { predictionResponse -> return predictionResponse.toDomain()  }
            .onSuccess { return null }
        return null
    }
}