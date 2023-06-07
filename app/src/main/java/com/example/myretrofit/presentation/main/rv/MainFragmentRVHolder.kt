package com.example.myretrofit.presentation.main.rv

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myretrofit.R
import com.example.myretrofit.domain.FilmFromListInfo

class MainFragmentRVHolder(val view: View) : RecyclerView.ViewHolder(view) {
    private val ivIconFilm: ImageView = view.findViewById(R.id.iv_icon_film)
    private val tvNameFilm: TextView = view.findViewById(R.id.tv_name_film)

    fun bind(filmItem: FilmFromListInfo) {
        tvNameFilm.text = filmItem.name
        Glide.with(ivIconFilm)
            .load(filmItem.imageUrl)
            .fitCenter()
            .into(FilmIconCustomTarget(ivIconFilm))

    }
}