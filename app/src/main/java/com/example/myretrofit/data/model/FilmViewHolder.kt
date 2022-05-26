package com.example.myretrofit.data.model

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myretrofit.R
import com.example.myretrofit.databinding.ItemFilmBinding

class FilmViewHolder(
    private val binding: ItemFilmBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(film: Film): Unit = with(binding) {
        filmNameTextView.text = film.nameRu
        if (film.posterUrl.isNotBlank()) {
           Glide.with(photoFilmImageView.context)
                .load(film.posterUrl)
                .circleCrop()
                .placeholder(R.drawable.ic_film)
                .error(R.drawable.ic_film)
                .into(photoFilmImageView)
        } else {
            photoFilmImageView.setImageResource(R.drawable.ic_film)

        }


    }
}
