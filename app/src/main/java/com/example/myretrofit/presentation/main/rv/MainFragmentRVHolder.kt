package com.example.myretrofit.presentation.main.rv

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.myretrofit.R
import com.example.myretrofit.domain.FilmFromListInfo
import com.google.android.material.progressindicator.CircularProgressIndicator

class MainFragmentRVHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val checkBox: CheckBox = view.findViewById(R.id.icon)
    private val piLoadFilm: CircularProgressIndicator = view.findViewById(R.id.pi_film_load)
    private val ivIconFilm: ImageView = view.findViewById(R.id.iv_icon_film)


    fun bind(filmItem: FilmFromListInfo) {
        checkBox.isChecked = filmItem.favoriteFlag
        Glide.with(ivIconFilm)
            .load(filmItem.imageUrl)
            .fitCenter()
            .error(R.drawable.ic_error_load_film_foreground)
            .transition(DrawableTransitionOptions.withCrossFade())
            .override(1000)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    return true
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    ivIconFilm.isVisible = true
                    piLoadFilm.isVisible = false
                    return false
                }


            })
            .into(ivIconFilm)

    }
}