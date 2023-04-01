package com.example.myretrofit.presentation.main.rv

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.myretrofit.R
import com.example.myretrofit.domain.FilmInfo

class MainFragmentRVAdapter :
    androidx.recyclerview.widget.ListAdapter<FilmInfo, MainFragmentRVHolder>(FilmInfoDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainFragmentRVHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_film_info,
            parent,
            false
        )
        return MainFragmentRVHolder(view)
    }


    override fun onBindViewHolder(holder: MainFragmentRVHolder, position: Int) {
        val filmItem = getItem(position)
        holder.tvNameFilm.text = filmItem.name
        Log.d("textView", "${holder.tvNameFilm.text}")
        with(holder.ivIconFilm) {
            Glide.with(this)
                .load(filmItem.imageUrl)
                .fitCenter()
                .into(FilmIconCustomTarget(this))
        }
    }
}