package cikal.dicoding.submission1.detail.tvshow

import cikal.dicoding.submission1.helper.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class DetailTvShowViewModelTest {

    private lateinit var viewModel: DetailTvShowViewModel
    private val dummyTvShow = DataDummy.generateDummyTvShows()[0]
    private val tvShowId = dummyTvShow.tvShowId

    @Before
    fun setUp() {
        viewModel = DetailTvShowViewModel()
        viewModel.setSelectedTvShow(tvShowId)
    }

    @Test
    fun getTvShow() {
        viewModel.setSelectedTvShow(dummyTvShow.tvShowId)
        val tvShowEntity = viewModel.getTvShow()
        assertNotNull(tvShowEntity)
        assertEquals(dummyTvShow.tvShowId, tvShowEntity.tvShowId)
        assertEquals(dummyTvShow.tvShowTitle, tvShowEntity.tvShowTitle)
        assertEquals(dummyTvShow.tvShowPoster, tvShowEntity.tvShowPoster)
        assertEquals(dummyTvShow.tvShowYear, tvShowEntity.tvShowYear)
        assertEquals(dummyTvShow.tvShowDesc, tvShowEntity.tvShowDesc)
    }
}