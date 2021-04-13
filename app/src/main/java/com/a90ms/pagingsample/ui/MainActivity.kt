package com.a90ms.pagingsample.ui

import android.os.Bundle
import androidx.activity.viewModels
import com.a90ms.pagingsample.R
import com.a90ms.pagingsample.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupData()
    }

    private fun setupData() {
        binding.run {
            viewModel = mainViewModel
        }


        mainViewModel.fetchSearchImage("1234")
    }
}