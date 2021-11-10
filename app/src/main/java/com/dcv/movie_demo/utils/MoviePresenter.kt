package com.dcv.movie_demo.utils

interface MoviePresenter<T> {
    fun onStart()
    fun onStop()
    fun setView(view: T)
}
