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
    }

    private fun initUI() {
        initUIState()
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                detailHoroscopeViewModel.state.collect{
                    when(it){
                        is HoroscopeDetailState.Error -> loadingState()
                        HoroscopeDetailState.Loading -> errorState()
                        is HoroscopeDetailState.Success -> successState(it)
                    }
                }
            }
        }
    }

    private fun successState(state: HoroscopeDetailState.Success) {
        binding.pbDetail.isVisible = false
        binding.tvTitle.text = state.prediction.horoscope
        binding.tvBody.text = state.prediction.horoscope
    }

    private fun errorState() {
        binding.pbDetail.isVisible = false
    }

    private fun loadingState() {
        binding.pbDetail.isVisible = true
    }
}