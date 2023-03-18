package com.example.myretrofit.presentation


import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition

class FilmIconCustomTarget (
    private val view: View
) : CustomTarget<Drawable>() {
    override fun onResourceReady(
        resource: Drawable,
        transition: Transition<in Drawable>?
    ) {
        view.background = resource
    }

    override fun onLoadCleared(placeholder: Drawable?) {
        TODO("Not yet implemented")
    }
}
