package cikal.dicoding.finalsubmission.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import cikal.dicoding.finalsubmission.data.source.CatalogueRepository
import cikal.dicoding.finalsubmission.data.source.local.entity.MovieEntity

class MovieViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {

    fun getMovies(): LiveData<List<MovieEntity>> = catalogueRepository.getAllMovies()
}