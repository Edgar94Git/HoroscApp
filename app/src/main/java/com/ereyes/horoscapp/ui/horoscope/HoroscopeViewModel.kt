package com.ereyes.horoscapp.ui.horoscope

import androidx.lifecycle.ViewModel
import com.ereyes.horoscapp.data.providers.HoroscopeProvider
import com.ereyes.horoscapp.domain.model.HoroscopeInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

/****
 * Project: HoroscApp
 * From: com.ereyes.horoscapp.ui.horoscope
 * Created by Edgar Reyes Gonzalez on 9/9/2023 at 12:58 PM
 * All rights reserved 2023.
 ****/
@HiltViewModel
class HoroscopeViewModel @Inject constructor(horoscopeProvider: HoroscopeProvider) : ViewModel() {

    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList())
    val horoscope: StateFlow<List<HoroscopeInfo>> = _horoscope

    init {
        _horoscope.value = horoscopeProvider.getHoroscopeList()
    }

}