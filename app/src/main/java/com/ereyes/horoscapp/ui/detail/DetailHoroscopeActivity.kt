package com.ereyes.horoscapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.ereyes.horoscapp.databinding.ActivityDetailHoroscopeBinding
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.navArgs
import com.google.android.material.snackbar.Snackbar

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
        Snackbar.make(binding.root, args.type.toString(), Snackbar.LENGTH_LONG).show()
    }
}