package cikal.dicoding.submission1.detail.movie

import cikal.dicoding.submission1.helper.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class DetailMovieViewModelTest {

    private lateinit var viewModel: DetailMovieViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val movieId = dummyMovie.movieId

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel()
        viewModel.setSelectedMovie(movieId)
    }

    @Test
    fun getMovie() {
        viewModel.setSelectedMovie(dummyMovie.movieId)
        val movieEntity = viewModel.getMovie()
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.movieId, movieEntity.movieId)
        assertEquals(dummyMovie.movieTitle, movieEntity.movieTitle)
        assertEquals(dummyMovie.moviePoster, movieEntity.moviePoster)
        assertEquals(dummyMovie.movieYear, movieEntity.movieYear)
        assertEquals(dummyMovie.movieDesc, movieEntity.movieDesc)
    }
}