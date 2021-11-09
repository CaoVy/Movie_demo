package com.dcv.movie_demo.data.source.remote

import com.dcv.movie_demo.data.model.MovieTrending
import com.dcv.movie_demo.data.model.MovieTrendingResponse
import retrofit2.Call

interface MovieDataSource {

    interface Local

    interface Remote {
        fun getMovies(): Call<MovieTrendingResponse<MutableList<MovieTrending>>>
    }
}
