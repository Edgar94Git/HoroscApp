package com.ereyes.horoscapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.ereyes.horoscapp.databinding.ActivityDetailHoroscopeBinding
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.navArgs
import com.ereyes.horoscapp.R
import com.ereyes.horoscapp.domain.model.HoroscopeModel.*
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailHoroscopeActivity : AppCompatActivity() {

    private var _binding: ActivityDetailHoroscopeBinding? = null
    private val binding get() = _binding!!
    private val detailHoroscopeViewModel by viewModels<DetailHoroscopeViewModel>()
    private val args: DetailHoroscopeActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailHoroscopeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        detailHoroscopeViewModel.getPrediction(args.type)
    }

    private fun initUI() {
        initUIState()
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                detailHoroscopeViewModel.state.collect{
                    when(it){
                        is HoroscopeDetailState.Error -> errorState()
                        HoroscopeDetailState.Loading -> loadingState()
                        is HoroscopeDetailState.Success -> successState(it)
                    }
                }
            }
        }
    }

    private fun successState(state: HoroscopeDetailState.Success) {
        binding.pbDetail.isVisible = false
        binding.tvTitle.text = state.prediction.sign
        binding.tvBody.text = state.prediction.horoscope

        val image = when (state.horoscopeModel) {
            Aries -> R.drawable.detail_aries
            Taurus -> R.drawable.detail_taurus
            Gemini -> R.drawable.detail_gemini
            Cancer -> R.drawable.detail_cancer
            Leo -> R.drawable.detail_leo
            Virgo -> R.drawable.detail_virgo
            Libra -> R.drawable.detail_libra
            Scorpio -> R.drawable.detail_scorpio
            Sagittarius -> R.drawable.detail_sagittarius
            Capricorn -> R.drawable.detail_capricorn
            Aquarius -> R.drawable.detail_aquarius
            Pisces -> R.drawable.detail_pisces
        }

        binding.ivHoroscope.setImageResource(image)
    }

    private fun errorState() {
        binding.pbDetail.isVisible = false
    }

    private fun loadingState() {
        binding.pbDetail.isVisible = true
    }
}