package com.dcv.movie_demo.data.source.remote

import com.dcv.movie_demo.data.source.remote.api.ApiServices
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class MovieDataRemote : MovieDataSource.Remote {

    private val client: OkHttpClient.Builder = OkHttpClient().newBuilder().apply {
        writeTimeout(10000, TimeUnit.MILLISECONDS)
        connectTimeout(10000, TimeUnit.MILLISECONDS)
        retryOnConnectionFailure(true)
        build()
    }
    private var gson: Gson = GsonBuilder().setLenient().create()
    private val apiServices = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(client.build())
        .build()
        .create(ApiServices::class.java)

    override fun getMovies() = apiServices.getMovieTrending()

    companion object {
        private var instance: MovieDataRemote? = null

        fun getInstance() = synchronized(this) {
            instance ?: MovieDataRemote().also { instance = it }
        }
    }
}
