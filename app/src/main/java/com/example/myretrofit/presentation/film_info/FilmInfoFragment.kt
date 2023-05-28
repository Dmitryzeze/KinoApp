package com.example.myretrofit.presentation.film_info

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.myretrofit.R
import com.example.myretrofit.appComponent
import com.example.myretrofit.presentation.main.FilmViewModel
import javax.inject.Inject


class FilmInfoFragment : Fragment() {

    private lateinit var viewModelFactory: ViewModelProvider.Factory


    @Inject
    fun injection(
        viewModelFactory: ViewModelProvider.Factory,


        ) {
        this.viewModelFactory = viewModelFactory
    }

    private val viewModel: FilmViewModel by viewModels { viewModelFactory }
    override fun onAttach(context: Context) {
        requireActivity().appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_film_info, container, false)
    }


}