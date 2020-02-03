package cikal.dicoding.submission2.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import cikal.dicoding.submission2.data.source.CatalogueRepository
import cikal.dicoding.submission2.data.source.local.entity.MovieEntity

class MovieViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {

    fun getMovies(): LiveData<List<MovieEntity>> = catalogueRepository.getAllMovies()
}