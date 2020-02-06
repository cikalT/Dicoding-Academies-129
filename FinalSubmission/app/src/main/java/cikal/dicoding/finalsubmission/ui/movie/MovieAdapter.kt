package cikal.dicoding.finalsubmission.ui.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cikal.dicoding.finalsubmission.R
import cikal.dicoding.finalsubmission.data.source.local.entity.MovieEntity
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
//                    val intent = Intent(itemView.context, DetailCatalogueActivity::class.java)
//                    intent.putExtra(DetailCatalogueActivity.EXTRA_CONTENT, movie.movieId)
//                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}