package cikal.dicoding.submission1.detail.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import cikal.dicoding.submission1.data.MovieEntity
import cikal.dicoding.submission1.R
import kotlinx.android.synthetic.main.activity_detail_movie.*
import kotlinx.android.synthetic.main.item_content.view.*

class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailMovieViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)
            if (movieId != null) {
                viewModel.setSelectedMovie(movieId)
                populateMovie(viewModel.getMovie())
            }
        }
    }

    private fun populateMovie(movie: MovieEntity) {
        tv_title.text = movie.movieTitle
        tv_year.text = movie.movieYear
        tv_desc.text = movie.movieDesc
        val mDrawableName = movie.moviePoster
        iv_poster.setImageResource(resources.getIdentifier(mDrawableName, "drawable", this.packageName))
    }
}
