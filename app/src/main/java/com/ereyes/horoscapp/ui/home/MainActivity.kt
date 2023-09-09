package com.ereyes.horoscapp.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ereyes.horoscapp.R
import com.ereyes.horoscapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}