package cikal.dicoding.submission2.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import cikal.dicoding.submission2.data.source.CatalogueRepository
import cikal.dicoding.submission2.data.source.local.entity.MovieEntity
import cikal.dicoding.submission2.data.source.local.entity.TvShowEntity

class DetailCatalogueViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {

    lateinit var contentId: String

    fun setSelectedContent(contentId: String) {
        this.contentId = contentId
    }

    fun getDetailMovie(): LiveData<MovieEntity> = catalogueRepository.getDetailMovie(contentId)

    fun getDetailTvShow(): LiveData<TvShowEntity> = catalogueRepository.getDetailTvShow(contentId)
}