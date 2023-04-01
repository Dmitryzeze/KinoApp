package com.example.myretrofit.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myretrofit.data.repository.FilmRepositoryImpl
import com.example.myretrofit.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}