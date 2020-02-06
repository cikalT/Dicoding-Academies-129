package cikal.dicoding.finalsubmission.data.source

import androidx.lifecycle.LiveData
import cikal.dicoding.finalsubmission.data.source.local.entity.MovieEntity
import cikal.dicoding.finalsubmission.data.source.local.entity.TvShowEntity

interface CatalogueDataSource {

    fun getAllMovies(): LiveData<List<MovieEntity>>

    fun getAllTvShows(): LiveData<List<TvShowEntity>>

    fun getDetailMovie(contentId: String): LiveData<MovieEntity>

    fun getDetailTvShow(contentId: String): LiveData<TvShowEntity>
}