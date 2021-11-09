package com.dcv.movie_demo.screen.contact

import com.dcv.movie_demo.data.model.MovieTrending
import com.dcv.movie_demo.utils.MoviePresenter

class MovieContact {

    interface View{
        fun getMovieTrending(movieTrending: MutableList<MovieTrending>)
        fun onError(throwable: Throwable)
    }

    interface Presenter: MoviePresenter<View>{
        fun getTrendingMovie()
    }
}
