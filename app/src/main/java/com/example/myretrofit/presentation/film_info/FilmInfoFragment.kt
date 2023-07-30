package com.example.myretrofit.presentation.film_info

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.myretrofit.appComponent
import com.example.myretrofit.databinding.FragmentFilmInfoBinding
import com.example.myretrofit.presentation.main.rv.FilmIconCustomTarget
import javax.inject.Inject


class FilmInfoFragment : Fragment() {
    private var _binding: FragmentFilmInfoBinding? = null
    private val binding: FragmentFilmInfoBinding
        get() = checkNotNull(_binding)
    private lateinit var viewModelFactory: ViewModelProvider.Factory


    @Inject
    fun injection(
        viewModelFactory: ViewModelProvider.Factory,


        ) {
        this.viewModelFactory = viewModelFactory
    }

    private val viewModel: FilmInfoViewModel by viewModels { viewModelFactory }
    override fun onAttach(context: Context) {
        requireActivity().appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFilmInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFilmInfoToScreen()
    }


    private fun setFilmInfoToScreen() {
        val args: FilmInfoFragmentArgs by navArgs()
        Log.d("log",args.IdFilmInfo.toString())
        viewModel.getFilmInfo(args.IdFilmInfo).observe(
            viewLifecycleOwner
        ) {


        }
    }
}