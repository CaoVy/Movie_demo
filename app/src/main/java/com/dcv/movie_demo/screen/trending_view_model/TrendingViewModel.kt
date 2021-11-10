package com.dcv.movie_demo.screen.trending_view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dcv.movie_demo.data.model.MovieTrending
import com.dcv.movie_demo.data.source.local.MovieDataLocal
import com.dcv.movie_demo.data.source.remote.MovieDataRemote
import com.dcv.movie_demo.data.source.remote.MovieDataRepository
import kotlinx.coroutines.*


class TrendingViewModel() : ViewModel() {

    private val repository =
        MovieDataRepository.getInstance(MovieDataRemote.getInstance(), MovieDataLocal.getInstance())
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError(message = "${throwable.localizedMessage}")
    }
    var job: Job? = null
    val movieTrending = MutableLiveData<MutableList<MovieTrending>>()
    val error = MutableLiveData<String>()

    private fun onError(message: String) {
        error.value = message
    }

    fun fetchAndShowMovies() {
        fetchMovie()
    }


    private fun fetchMovie() = MovieTrending().apply {
        job = GlobalScope.launch(Dispatchers.IO + exceptionHandler) {
            val response = repository.getMovie()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    movieTrending.value = response.body()?.result
                } else {
                    onError(response.message())
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}
