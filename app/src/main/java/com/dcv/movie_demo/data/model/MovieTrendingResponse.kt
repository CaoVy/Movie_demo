package com.dcv.movie_demo.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MovieTrendingResponse<T> {
    @SerializedName("results")
    @Expose
    var result: MutableList<MovieTrending>? = null
}
