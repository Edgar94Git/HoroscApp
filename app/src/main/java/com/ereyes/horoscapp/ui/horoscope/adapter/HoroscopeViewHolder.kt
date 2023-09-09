package com.ereyes.horoscapp.ui.horoscope.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.ereyes.horoscapp.databinding.ItemHoroscopeBinding
import com.ereyes.horoscapp.domain.model.HoroscopeInfo

/****
 * Project: HoroscApp
 * From: com.ereyes.horoscapp.ui.horoscope.adapter
 * Created by Edgar Reyes Gonzalez on 9/9/2023 at 2:10 PM
 * All rights reserved 2023.
 ****/
class HoroscopeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding: ItemHoroscopeBinding = ItemHoroscopeBinding.bind(view)

    fun render(horoscopeInfo: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit) {
        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvTitle.text = binding.tvTitle.context.getString(horoscopeInfo.name)
        binding.parent.setOnClickListener {
            startRotationAnimation(
                binding.ivHoroscope,
                onFinishAnimation = {
                    onItemSelected(horoscopeInfo)
                }
            )
        }
    }

    private fun startRotationAnimation(view: View, onFinishAnimation: () -> Unit) {
        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withEndAction { onFinishAnimation() }
            start()
        }
    }
}