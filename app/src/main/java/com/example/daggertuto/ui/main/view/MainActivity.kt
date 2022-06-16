package com.example.daggertuto.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.daggertuto.R
import com.example.daggertuto.ui.main.adapter.MainAdapter
import com.example.daggertuto.ui.main.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupUI()
        setupObserver()
    }

    private fun setupObserver() {
        TODO("Not yet implemented")
    }

    private fun setupUI() {

    }
}