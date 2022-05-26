package com.example.myretrofit.data

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myretrofit.R
import com.example.myretrofit.data.model.Film
import com.example.myretrofit.data.model.FilmViewHolder
import com.example.myretrofit.databinding.ItemFilmBinding

class FilmAdapter : RecyclerView.Adapter<FilmViewHolder>() {
    private val listOfFilms: MutableList<Film> = mutableListOf()
    fun setUpFilms(films: List<Film>) {
        //val diffUtil = ContactsDiffUtilCallback(listOfFilms, films)
        listOfFilms.clear()
        listOfFilms.addAll(films)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        val binding = ItemFilmBinding.inflate(inflate, parent, false)
        return FilmViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.bind(listOfFilms[position])
    }

    override fun getItemCount(): Int = listOfFilms.size

}