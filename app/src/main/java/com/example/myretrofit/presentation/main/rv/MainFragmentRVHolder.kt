package com.example.myretrofit.presentation.main.rv

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.myretrofit.R
import com.example.myretrofit.domain.FilmFromListInfo

class MainFragmentRVHolder(val view: View) : RecyclerView.ViewHolder(view) {
    private val ivIconFilm: ImageView = view.findViewById(R.id.iv_icon_film)


    fun bind(filmItem: FilmFromListInfo) {

        Glide.with(ivIconFilm)
            .load(filmItem.imageUrl)
            .fitCenter()
            .placeholder(R.drawable.ic_film_icon)
            .error(R.drawable.ic_error_load_film_foreground)
            .transition(DrawableTransitionOptions.withCrossFade())
            .override(1000)
            .into(ivIconFilm)

    }
}