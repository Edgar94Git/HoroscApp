package com.ereyes.horoscapp.data.network.response

import com.ereyes.horoscapp.domain.model.PredictionModel
import com.google.gson.annotations.SerializedName

/****
 * Project: HoroscApp
 * From: com.ereyes.horoscapp.data.network.response
 * Created by Edgar Reyes Gonzalez on 9/10/2023 at 2:28 PM
 * All rights reserved 2023.
 ****/

data class PredictionResponse(
    @SerializedName("date") val date: String,
    @SerializedName("horoscope") val horoscope: String,
    @SerializedName("sign") val sign: String
)

fun PredictionResponse.toDomain(): PredictionModel{
    return  PredictionModel(
        horoscope = horoscope,
        sign = sign
    )
}