package com.example.myretrofit.presentation

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.myretrofit.data.repository.FilmRepositoryImpl

import com.example.myretrofit.databinding.ActivityMainBinding
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val repository = FilmRepositoryImpl(application)
        lifecycleScope.launch {
            repository.loadData()
        }
    }
}