package com.example.myretrofit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myretrofit.data.*
import com.example.myretrofit.databinding.FragmentFavoriteBinding


class FavoriteFragment : Fragment() {

    private lateinit var adapter: FilmAdapter
    private val viewModel : FilmViewModel by viewModels{
        val retrofit = FilmRetrofit().getRetrofit()
        val filmsRepository = FilmRepository(retrofit.create(FilmService::class.java))
        MyViewModelFactory(filmsRepository)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val binding = FragmentFavoriteBinding.inflate(
            inflater, container, false
        )

        adapter = FilmAdapter()
        val layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter
        viewModel.films.observe(viewLifecycleOwner){
            listOfFilms -> adapter.setUpFilms(listOfFilms)
        }
        viewModel.startListening(300)
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }





}