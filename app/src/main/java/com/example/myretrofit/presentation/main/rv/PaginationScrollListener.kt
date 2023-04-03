package com.example.myretrofit.presentation.main.rv

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class PaginationScrollListener(private val layoutManager: GridLayoutManager) :
    RecyclerView.OnScrollListener() {
    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        val visibleItemCount: Int = layoutManager.childCount
        val totalItemCount: Int = layoutManager.itemCount
        val firstVisibleItem = layoutManager.findFirstVisibleItemPosition()
            if (visibleItemCount + firstVisibleItem >= totalItemCount && firstVisibleItem >= 0) {
                loadMoreItems()
            }

        }

    abstract fun loadMoreItems()

}