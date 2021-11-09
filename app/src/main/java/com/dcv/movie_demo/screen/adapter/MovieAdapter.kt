package com.dcv.movie_demo.screen.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dcv.movie_demo.R
import com.dcv.movie_demo.data.model.MovieTrending
import com.dcv.movie_demo.utils.ext.loadImage
import kotlinx.android.synthetic.main.list_movie.view.*

class MovieAdapter() : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private var movieTrendings = mutableListOf<MovieTrending>()

    @SuppressLint("NotifyDataSetChanged")
    fun update(movieTrendings: MutableList<MovieTrending>) {
        this.movieTrendings.clear()
        this.movieTrendings = movieTrendings
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_movie, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(movieTrendings[position])
    }

    override fun getItemCount() = movieTrendings.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(movieTrendings: MovieTrending) {
            itemView.let {
                it.movieImage.loadImage(movieTrendings.backdropPath)
                it.titleTextView.text = movieTrendings.title
            }
        }
    }
}
