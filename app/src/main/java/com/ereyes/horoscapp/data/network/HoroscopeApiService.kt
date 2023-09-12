package com.ereyes.horoscapp.data.network

import com.ereyes.horoscapp.data.network.response.PredictionResponse
import retrofit2.http.GET
import retrofit2.http.Path
/****
 * Project: HoroscApp
 * From: com.ereyes.horoscapp.data.network
 * Created by Edgar Reyes Gonzalez on 9/11/2023 at 8:31 AM
 * All rights reserved 2023.
 ****/
interface HoroscopeApiService {

    @GET("/{sign}")
    suspend fun getHoroscope(@Path("sign") sign:String):PredictionResponse

}