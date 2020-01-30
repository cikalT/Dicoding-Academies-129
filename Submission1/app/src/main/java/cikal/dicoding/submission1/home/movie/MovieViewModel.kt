package cikal.dicoding.submission1.home.movie

import androidx.lifecycle.ViewModel
import cikal.dicoding.submission1.helper.DataDummy
import cikal.dicoding.submission1.data.MovieEntity

class MovieViewModel: ViewModel() {

    fun getMovies(): List<MovieEntity> = DataDummy.generateDummyMovies()
}