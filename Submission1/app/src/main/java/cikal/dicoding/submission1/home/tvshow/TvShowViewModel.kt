package cikal.dicoding.submission1.home.tvshow

import androidx.lifecycle.ViewModel
import cikal.dicoding.submission1.helper.DataDummy
import cikal.dicoding.submission1.data.TvShowEntity

class TvShowViewModel: ViewModel() {

    fun getTvShows(): List<TvShowEntity> = DataDummy.generateDummyTvShows()
}