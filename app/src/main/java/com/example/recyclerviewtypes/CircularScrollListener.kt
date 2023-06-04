package com.example.recyclerviewtypes

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CircularScrollListener<T>(private val items :List<T>): RecyclerView.OnScrollListener() {

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        val layoutManager = recyclerView.layoutManager as LinearLayoutManager
        val firstItemVisible: Int = layoutManager.findFirstVisibleItemPosition()
        if (firstItemVisible != 1 && (firstItemVisible % items.size == 1)) {
            layoutManager.scrollToPosition(1)
        } else if (firstItemVisible != 1 && firstItemVisible > items.size && (firstItemVisible % items.size > 1)) {
            layoutManager.scrollToPosition(firstItemVisible % items.size)
        } else if (firstItemVisible == 0) {
            layoutManager.scrollToPositionWithOffset(items.size, -recyclerView.computeHorizontalScrollOffset())
        }
    }
}