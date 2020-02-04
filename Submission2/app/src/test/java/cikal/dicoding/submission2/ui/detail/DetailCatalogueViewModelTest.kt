package cikal.dicoding.submission2.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import cikal.dicoding.submission2.data.source.CatalogueRepository
import cikal.dicoding.submission2.data.source.local.entity.MovieEntity
import cikal.dicoding.submission2.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailCatalogueViewModelTest {
    private lateinit var viewModel: DetailCatalogueViewModel

    private val dummyMovie = DataDummy.generateDummyMovies()[0]

    private val movieId = dummyMovie.movieId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var movieObserver: Observer<MovieEntity>

    @Before
    fun setUp() {
        viewModel = DetailCatalogueViewModel(catalogueRepository)
        viewModel.setSelectedContent(movieId)
    }

    @Test
    fun getMovie() {
        val movie = MutableLiveData<MovieEntity>()
        movie.value = dummyMovie

        Mockito.`when`(catalogueRepository.getDetailMovie(movieId)).thenReturn(movie)
        val movieEntity = viewModel.getDetailMovie().value as MovieEntity
        Mockito.verify(catalogueRepository).getDetailMovie(movieId)
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.movieId, movieEntity.movieId)
        assertEquals(dummyMovie.movieTitle, movieEntity.movieTitle)
        assertEquals(dummyMovie.movieDesc, movieEntity.movieDesc)
        assertEquals(dummyMovie.movieYear, movieEntity.movieYear)
        assertEquals(dummyMovie.moviePoster, movieEntity.moviePoster)

        viewModel.getDetailMovie().observeForever(movieObserver)
        Mockito.verify(movieObserver).onChanged(dummyMovie)
    }
}