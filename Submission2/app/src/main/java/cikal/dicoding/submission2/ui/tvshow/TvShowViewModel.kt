package cikal.dicoding.submission2.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import cikal.dicoding.submission2.data.source.CatalogueRepository
import cikal.dicoding.submission2.data.source.local.entity.TvShowEntity

class TvShowViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {

    fun getTvShows(): LiveData<List<TvShowEntity>> = catalogueRepository.getAllTvShows()
}