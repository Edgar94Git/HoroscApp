package com.ereyes.horoscapp.data.providers

import com.ereyes.horoscapp.domain.model.HoroscopeInfo
import com.ereyes.horoscapp.domain.model.HoroscopeInfo.*
import javax.inject.Inject

/****
 * Project: HoroscApp
 * From: com.ereyes.horoscapp.data.providers
 * Created by Edgar Reyes Gonzalez on 9/9/2023 at 2:53 PM
 * All rights reserved 2023.
 ****/
class HoroscopeProvider @Inject constructor() {
    fun getHoroscopeList(): List<HoroscopeInfo>{
        return listOf(
            Aries,
            Taurus,
            Gemini,
            Cancer,
            Leo,
            Virgo,
            Libra,
            Scorpio,
            Sagittarius,
            Capricorn,
            Aquarius,
            Pisces
        )
    }
}