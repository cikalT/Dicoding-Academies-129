package cikal.dicoding.finalsubmission.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import cikal.dicoding.finalsubmission.data.source.CatalogueRepository
import cikal.dicoding.finalsubmission.data.source.local.entity.TvShowEntity

class TvShowViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {

    fun getTvShows(): LiveData<List<TvShowEntity>> = catalogueRepository.getAllTvShows()
}