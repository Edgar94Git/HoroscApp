package com.ereyes.horoscapp.ui.detail

import com.ereyes.horoscapp.domain.model.HoroscopeModel
import com.ereyes.horoscapp.domain.model.PredictionModel

/****
 * Project: HoroscApp
 * From: com.ereyes.horoscapp.ui.detail
 * Created by Edgar Reyes Gonzalez on 9/10/2023 at 1:39 PM
 * All rights reserved 2023.
 ****/
sealed class HoroscopeDetailState {
    data object Loading: HoroscopeDetailState()
    data class Error(val error:String): HoroscopeDetailState()
    data class Success(val prediction: PredictionModel, val horoscopeModel: HoroscopeModel): HoroscopeDetailState()
}