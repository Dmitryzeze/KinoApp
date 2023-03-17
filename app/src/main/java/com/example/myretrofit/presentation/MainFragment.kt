package com.example.myretrofit.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.myretrofit.R
import com.example.myretrofit.data.repository.FilmRepositoryImpl
import kotlinx.coroutines.launch


class MainFragment : Fragment() {
    private lateinit var repository : FilmRepositoryImpl
    private lateinit var viewModel: FilmViewModel
    private lateinit var filmsListAdapter: MainFragmentRVAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            repository.loadData()
        }


    }
    private fun setupRecycleView(view: View){
        val rvFilmList = view.findViewById<RecyclerView>(R.id.rv_films_list)
        filmsListAdapter = MainFragmentRVAdapter()
        with(rvFilmList){
            adapter = filmsListAdapter
        }

    }

}