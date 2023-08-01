package com.example.myretrofit.presentation.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myretrofit.R
import com.example.myretrofit.appComponent
import com.example.myretrofit.databinding.FragmentMainBinding
import com.example.myretrofit.presentation.main.rv.MainFragmentRVAdapter
import com.example.myretrofit.presentation.main.rv.PaginationScrollListener
import kotlinx.coroutines.launch
import javax.inject.Inject


class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() = checkNotNull(_binding)

    private lateinit var viewModelFactory: ViewModelProvider.Factory


    @Inject
    fun injection(
        viewModelFactory: ViewModelProvider.Factory,
        ) {
        this.viewModelFactory = viewModelFactory
    }

    private val viewModel: FilmViewModel by viewModels { viewModelFactory }
    private val filmsListAdapter: MainFragmentRVAdapter by lazy {
        MainFragmentRVAdapter()
    }

    override fun onAttach(context: Context) {
        requireActivity().appComponent.inject(this)
        super.onAttach(context)
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
        view.findViewById<RecyclerView>(R.id.rv_films_list).init()
        viewModel.films.observe(viewLifecycleOwner) {
            filmsListAdapter.submitList(it)
        }
        setupClickListener()
    }

    private fun RecyclerView.init() {
        this.layoutManager = GridLayoutManager(this.context, 2)
        this.adapter = filmsListAdapter
        this.addOnScrollListener(object :
            PaginationScrollListener(this@init.layoutManager as GridLayoutManager) {
            override fun loadMoreItems() {
                lifecycleScope.launch {
                }
            }

        })

    }

    private fun setupClickListener() {
        filmsListAdapter.onShopItemClickListener = {
            val action = MainFragmentDirections.actionMainFragmentToFilmInfoFragment(it.id)
            findNavController().navigate(action)
        }
    }
}