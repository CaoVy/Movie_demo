package com.dcv.movie_demo.data.source.remote.api

import com.dcv.movie_demo.data.model.MovieTrending
import com.dcv.movie_demo.data.model.MovieTrendingResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServices {
    @GET("trending/movie/day?api_key=adb3a8a319ead0858619c320791e47a0")
   suspend fun getMovieTrending(): Response<MovieTrendingResponse<MutableList<MovieTrending>>>
}
