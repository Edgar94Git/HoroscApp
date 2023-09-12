package com.ereyes.horoscapp.domain.usecase

import com.ereyes.horoscapp.domain.Repository
import com.ereyes.horoscapp.domain.model.PredictionModel
import javax.inject.Inject

/****
 * Project: HoroscApp
 * From: com.ereyes.horoscapp.domain.usecase
 * Created by Edgar Reyes Gonzalez on 9/10/2023 at 3:31 PM
 * All rights reserved 2023.
 ****/
class GetPredictionUseCase @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke(sign: String): PredictionModel? = repository.getPrediction(sign)

}