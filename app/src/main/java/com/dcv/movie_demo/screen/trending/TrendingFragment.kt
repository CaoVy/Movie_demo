package com.dcv.movie_demo.screen.trending

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dcv.movie_demo.R
import com.dcv.movie_demo.screen.adapter.MovieAdapter
import com.dcv.movie_demo.screen.detail.MovieDetailFragment
import com.dcv.movie_demo.screen.trending_view_model.TrendingViewModel
import com.dcv.movie_demo.utils.ext.addFragment
import kotlinx.android.synthetic.main.fragment_trending.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TrendingFragment : Fragment() {

    private var movieAdapter: MovieAdapter? = null
    private lateinit var trendingViewModel: TrendingViewModel

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
        movieAdapter?.onClickItemMovie = {
            addFragment(R.id.trendingFragment, MovieDetailFragment.getInstance(it))
        }
        trendingViewModel = ViewModelProvider(this).get(TrendingViewModel::class.java)
        trendingViewModel.fetchAndShowMovies()

        trendingViewModel.movieTrending.observe(viewLifecycleOwner, {
            movieAdapter?.update(it)
        })

        trendingViewModel.error.observe(viewLifecycleOwner, {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        })
    }

    companion object {

        fun getInstance() = TrendingFragment().apply {
            arguments = bundleOf()
        }
    }
}
