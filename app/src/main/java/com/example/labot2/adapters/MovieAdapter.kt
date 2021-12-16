package com.example.labot2.adapters
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.labot2.R
import com.example.labot2.models.Movies

class MovieAdapter(var allMovies: MutableList<Movies>, private val clickListener: (Movies) -> Unit): RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val movieId: TextView
        val movieTitle: TextView
        val movieDirector: TextView

        init {
                movieId = view.findViewById(R.id.movieId)
                movieTitle = view.findViewById(R.id.movieTitle)
                movieDirector = view.findViewById(R.id.movieDirector)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie,parent,false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentMovie = allMovies[position]
        holder.movieId.text = currentMovie.id.toString()
        holder.movieTitle.text = currentMovie.title
        holder.movieDirector.text = currentMovie.director

        holder.itemView.setOnClickListener {
                        clickListener(allMovies[position])
        }
    }

    override fun getItemCount(): Int {
        return allMovies.size
    }

    fun updateData(data: MutableList<Movies>){
        this.allMovies = data
        this.notifyDataSetChanged()

    }
}