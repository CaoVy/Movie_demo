package com.dcv.movie_demo.screen.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dcv.movie_demo.screen.favorite.FavoriteFragment
import com.dcv.movie_demo.screen.genres.GenresFragment
import com.dcv.movie_demo.screen.trending.TrendingFragment

class MenuAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    private val fragments = mutableListOf<Fragment>()

    override fun getItemCount() = fragments.size

    override fun createFragment(position: Int) = when (position) {
        0 -> GenresFragment.getInstance()
        1 -> TrendingFragment.getInstance()
        2 -> FavoriteFragment.getInstance()
        else -> GenresFragment.getInstance()
    }

    fun addFragment(fragments: MutableList<Fragment>) {
        this.fragments.addAll(fragments)
    }
}
