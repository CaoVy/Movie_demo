package com.dcv.movie_demo.screen.trending

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.dcv.movie_demo.R
import com.dcv.movie_demo.data.model.MovieTrending
import com.dcv.movie_demo.data.source.local.MovieDataLocal
import com.dcv.movie_demo.data.source.remote.MovieDataRemote
import com.dcv.movie_demo.data.source.remote.MovieDataRepository
import com.dcv.movie_demo.screen.adapter.MovieAdapter
import com.dcv.movie_demo.screen.contact.MovieContact
import com.dcv.movie_demo.screen.presenter.MovieTrendingPresenter
import kotlinx.android.synthetic.main.fragment_trending.*

class TrendingFragment : Fragment(), MovieContact.View {

    private var movieAdapter: MovieAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_trending, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieAdapter = MovieAdapter()
        trendingRecyclerView.adapter = movieAdapter
        initData()
    }

    override fun getMovieTrending(movieTrending: MutableList<MovieTrending>) {
        movieAdapter?.update(movieTrending)
    }

    override fun onError(throwable: Throwable) {
        Toast.makeText(this.context, throwable.message, Toast.LENGTH_SHORT).show()
    }

    private fun initData() {
        MovieTrendingPresenter(
            MovieDataRepository.getInstance(
                MovieDataRemote.getInstance(),
                MovieDataLocal.getInstance()
            )
        ).run {
            setView(this@TrendingFragment)
            onStart()
        }
    }

    companion object {

        fun getInstance() = TrendingFragment().apply {
            arguments = bundleOf()
        }
    }
}
