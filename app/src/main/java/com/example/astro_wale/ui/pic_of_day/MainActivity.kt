package com.example.astro_wale.ui.pic_of_day

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.astro_wale.R
import com.example.astro_wale.databinding.ActivityMainBinding
import com.example.astro_wale.ui.pic_of_day.viewmodel.AstroPicViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AstroBaseActivity() {

    private lateinit var viewModel: AstroPicViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this).get(AstroPicViewModel::class.java)
        binding.model = viewModel

        viewModel.fetchPicOfTheDay()
    }
}