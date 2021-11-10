package com.dcv.movie_demo.data.source.remote

import com.dcv.movie_demo.data.model.MovieTrending
import com.dcv.movie_demo.data.model.MovieTrendingResponse
import retrofit2.Call
import retrofit2.Response

interface MovieDataSource {

    interface Local

    interface Remote {
       suspend fun getMovies(): Response<MovieTrendingResponse<MutableList<MovieTrending>>>
    }
}
