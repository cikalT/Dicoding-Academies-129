package cikal.dicoding.submission1.detail.movie

import androidx.lifecycle.ViewModel
import cikal.dicoding.submission1.helper.DataDummy
import cikal.dicoding.submission1.data.MovieEntity

class DetailMovieViewModel : ViewModel() {

    private lateinit var tvShowId: String

    fun setSelectedMovie(movieID: String) {
        this.tvShowId = movieID
    }

    fun getMovie(): MovieEntity {
        lateinit var movie: MovieEntity
        val moviesEntity = DataDummy.generateDummyMovies()
        for (movieEntity in moviesEntity) {
            if (movieEntity.movieId == tvShowId) {
                movie = movieEntity
            }
        }
        return movie
    }
}