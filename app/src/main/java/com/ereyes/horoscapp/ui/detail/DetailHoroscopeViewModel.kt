package com.ereyes.horoscapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ereyes.horoscapp.domain.model.HoroscopeModel
import com.ereyes.horoscapp.domain.usecase.GetPredictionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/****
 * Project: HoroscApp
 * From: com.ereyes.horoscapp.ui.detail
 * Created by Edgar Reyes Gonzalez on 9/9/2023 at 4:27 PM
 * All rights reserved 2023.
 ****/

@HiltViewModel
class DetailHoroscopeViewModel @Inject constructor(private val getPredictionUseCase: GetPredictionUseCase): ViewModel(){

    private var _state = MutableStateFlow<HoroscopeDetailState>(HoroscopeDetailState.Loading)
    val state: StateFlow<HoroscopeDetailState> = _state

    lateinit var horoscope: HoroscopeModel

    fun getPrediction(sign: HoroscopeModel){
        horoscope = sign
        viewModelScope.launch {
            _state.value = HoroscopeDetailState.Loading
            val result = withContext(Dispatchers.IO){getPredictionUseCase(sign.name)}
            if(result != null){
                _state.value = HoroscopeDetailState.Success(result, horoscope)
            }
            else {
                _state.value = HoroscopeDetailState.Error("Ha ocurrido un error, intentelo mas tarde")
            }
        }
    }
}