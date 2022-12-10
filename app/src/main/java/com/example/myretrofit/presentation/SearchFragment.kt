package com.example.myretrofit.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.myretrofit.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSearchBinding.inflate(
            inflater, container, false
        )
        val buttonLike = binding.buttonLike
        val poster = binding.poster
        val buttonNext = binding.buttonNext


        var count : Int = 300
        buttonNext.setOnClickListener {



        }
        buttonLike.setOnClickListener { }
        // Inflate the layout for this fragment
        return binding.root
    }


}