package cikal.dicoding.submission1.detail.tvshow

import androidx.lifecycle.ViewModel
import cikal.dicoding.submission1.data.TvShowEntity
import cikal.dicoding.submission1.helper.DataDummy

class DetailTvShowViewModel : ViewModel() {

    private lateinit var tvShowId: String

    fun setSelectedTvShow(tvShowID: String) {
        this.tvShowId = tvShowID
    }

    fun getTvShow(): TvShowEntity {
        lateinit var tvShow: TvShowEntity
        val tvShowsEntity = DataDummy.generateDummyTvShows()
        for (tvShowEntity in tvShowsEntity) {
            if (tvShowEntity.tvShowId == tvShowId) {
                tvShow = tvShowEntity
            }
        }
        return tvShow
    }
}