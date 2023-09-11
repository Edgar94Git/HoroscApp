package com.ereyes.horoscapp.ui.detail

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

/****
 * Project: HoroscApp
 * From: com.ereyes.horoscapp.ui.detail
 * Created by Edgar Reyes Gonzalez on 9/9/2023 at 4:27 PM
 * All rights reserved 2023.
 ****/

@HiltViewModel
class DetailHoroscopeViewModel @Inject constructor(): ViewModel(){

    private var _state = MutableStateFlow<HoroscopeDetailState>(HoroscopeDetailState.Loading)
    val state: StateFlow<HoroscopeDetailState> = _state
}