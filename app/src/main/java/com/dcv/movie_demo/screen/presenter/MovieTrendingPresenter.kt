package com.dcv.movie_demo.screen.presenter

import com.dcv.movie_demo.data.model.MovieTrending
import com.dcv.movie_demo.data.model.MovieTrendingResponse
import com.dcv.movie_demo.data.source.remote.MovieDataRepository
import com.dcv.movie_demo.screen.contact.MovieContact
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieTrendingPresenter constructor(private val repository: MovieDataRepository) :
    MovieContact.Presenter {

    private var view: MovieContact.View? = null

    override fun onStart() {
        getTrendingMovie()
    }

    override fun onStop() {
        view = null
    }

    override fun setView(view: MovieContact.View) {
        this.view = view
    }

    override fun getTrendingMovie() {
        repository.getMovie().apply {
            enqueue(object : Callback<MovieTrendingResponse<MutableList<MovieTrending>>> {
                override fun onResponse(
                    call: Call<MovieTrendingResponse<MutableList<MovieTrending>>>,
                    response: Response<MovieTrendingResponse<MutableList<MovieTrending>>>
                ) {
                    response.body()?.result?.let {
                        view?.getMovieTrending(it)
                    }
                }

                override fun onFailure(
                    call: Call<MovieTrendingResponse<MutableList<MovieTrending>>>,
                    t: Throwable
                ) {
                    view?.onError(t)
                }
            })
        }
    }
}
