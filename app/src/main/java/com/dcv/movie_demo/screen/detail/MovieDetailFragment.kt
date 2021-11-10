package com.dcv.movie_demo.screen.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.dcv.movie_demo.R
import com.dcv.movie_demo.data.model.MovieTrending
import com.dcv.movie_demo.utils.ext.loadImage
import kotlinx.android.synthetic.main.fragment_movie_detail.*
import kotlin.concurrent.fixedRateTimer

class MovieDetailFragment : Fragment() {

    private var movieTrending: MovieTrending? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        backButton.setOnClickListener {
            fragmentManager?.popBackStack()
        }

        movieTrending = arguments?.get(BUNDLE_MOVIE) as MovieTrending
        movieTrending?.let {
            movieImage.loadImage(it.backdropPath)
            nameMovieText.text = it.title
            voteAverageText.text = it.voteAverage.toString()
            dateText.text = it.releaseDate
            votePopularityText.text = it.popularity.toString()
            overviewTitleText.text = it.overview
        }
    }

    companion object {

        private const val BUNDLE_MOVIE = "BUNDLE_MOVIE"

        fun getInstance(movieTrending: MovieTrending) = MovieDetailFragment().apply {
            arguments = bundleOf(BUNDLE_MOVIE to movieTrending)
        }
    }
}
