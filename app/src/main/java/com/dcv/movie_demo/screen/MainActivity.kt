package com.dcv.movie_demo.screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.dcv.movie_demo.R
import com.dcv.movie_demo.screen.adapter.MenuAdapter
import com.dcv.movie_demo.screen.favorite.FavoriteFragment
import com.dcv.movie_demo.screen.genres.GenresFragment
import com.dcv.movie_demo.screen.trending.TrendingFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val fragment = mutableListOf(
        GenresFragment.getInstance(),
        TrendingFragment.getInstance(),
        FavoriteFragment.getInstance()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MenuAdapter(this).apply {
            addFragment(fragment)
            viewPager.adapter = this
        }

        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.itemGenres -> viewPager.currentItem = 0
                R.id.itemTrending -> viewPager.currentItem = 1
                R.id.itemFavorite -> viewPager.currentItem = 2
            }
            false
        }

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                bottomNav.menu.getItem(position).isChecked = true
            }
        })
    }
}
