package cikal.dicoding.submission2.data.source

import androidx.lifecycle.LiveData
import cikal.dicoding.submission2.data.source.local.entity.MovieEntity

interface CatalogueDataSource {

    fun getAllMovies(): LiveData<List<MovieEntity>>

}