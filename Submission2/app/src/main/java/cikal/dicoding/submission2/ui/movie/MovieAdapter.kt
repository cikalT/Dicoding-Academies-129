package cikal.dicoding.submission2.ui.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import cikal.dicoding.submission2.R
import cikal.dicoding.submission2.data.source.local.entity.MovieEntity
import kotlinx.android.synthetic.main.item_content.view.*

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var listMovies = ArrayList<MovieEntity>()

    fun setMovie(movies: List<MovieEntity>?) {
        if (movies == null) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_content, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int = listMovies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = listMovies[position]
        holder.bind(movie)
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: MovieEntity) {
            with(itemView) {
                tv_title.text = movie.movieTitle
                tv_date.text = movie.movieYear
                tv_desc.text = movie.movieDesc
                val mDrawableName = movie.moviePoster
                iv_poster.setImageResource(resources.getIdentifier(mDrawableName, "drawable", context.packageName))

                itemView.setOnClickListener {
                    Toast.makeText(context, movie.movieTitle, Toast.LENGTH_SHORT).show()
//                    val intent = Intent(itemView.context, DetailMovieActivity::class.java)
//                    intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movie.movieId)
//                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}