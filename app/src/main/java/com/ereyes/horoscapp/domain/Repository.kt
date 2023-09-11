package com.ereyes.horoscapp.domain

import com.ereyes.horoscapp.domain.model.PredictionModel

/****
 * Project: HoroscApp
 * From: com.ereyes.horoscapp.domain
 * Created by Edgar Reyes Gonzalez on 9/10/2023 at 2:36 PM
 * All rights reserved 2023.
 ****/
interface Repository {

    suspend fun getPrediction(sign: String): PredictionModel?

}