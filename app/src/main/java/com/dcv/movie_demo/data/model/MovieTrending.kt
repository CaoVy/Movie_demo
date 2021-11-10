package com.dcv.movie_demo.data.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieTrending(
    @Expose
    @SerializedName("backdrop_path")
    val backdropPath: String ="",
    @Expose
    @SerializedName("title")
    val title: String = "",
    @Expose
    @SerializedName("release_date")
    val releaseDate: String = "",
    @Expose
    @SerializedName("popularity")
    val popularity: Number = 100,
    @Expose
    @SerializedName("vote_average")
    val voteAverage: Double = 0.0,
    @Expose
    @SerializedName("overview")
    val overview: String = ""
): Parcelable
