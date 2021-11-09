package com.dcv.movie_demo.data.source.remote

import com.dcv.movie_demo.data.model.MovieTrending
import com.dcv.movie_demo.data.model.MovieTrendingResponse
import retrofit2.Call

class MovieDataRepository constructor(
    private val remote: MovieDataSource.Remote,
    private val local: MovieDataSource.Local
) {
    fun getMovie(): Call<MovieTrendingResponse<MutableList<MovieTrending>>> {
        return remote.getMovies()
    }

    companion object {
        private var instance: MovieDataRepository? = null

        fun getInstance(
            remote: MovieDataSource.Remote,
            local: MovieDataSource.Local
        ) = synchronized(this) {
            instance ?: MovieDataRepository(remote, local).also { instance = it }
        }
    }
}
