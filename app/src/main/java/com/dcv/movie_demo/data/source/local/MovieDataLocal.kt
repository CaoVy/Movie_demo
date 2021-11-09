package com.dcv.movie_demo.data.source.local

import com.dcv.movie_demo.data.source.remote.MovieDataSource

class MovieDataLocal : MovieDataSource.Local {

    companion object {
        private var instance: MovieDataLocal? = null

        fun getInstance() = synchronized(this) {
            instance ?: MovieDataLocal().also { instance = it }
        }
    }
}
