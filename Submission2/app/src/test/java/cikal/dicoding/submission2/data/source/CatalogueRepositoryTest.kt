package cikal.dicoding.submission2.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import cikal.dicoding.submission2.data.source.remote.RemoteDataSource
import cikal.dicoding.submission2.utils.DataDummy
import cikal.dicoding.submission2.utils.LiveDataTestUtils
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class CatalogueRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val catalogueRepository = FakeCatalogueRepository(remote)

    private val movieResponses = DataDummy.generateDummyRemoteMovies()
    private val movieId = movieResponses[0].movieId

    private val tvShowResponses = DataDummy.generateDummyRemoveTvShows()
    private val tvShowId = tvShowResponses[0].tvShowId

    @Test
    fun getAllMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onAllMoviesReceived(movieResponses)
            null
        }.`when`(remote).getAllMovie(any())
        val movieEntities = LiveDataTestUtils.getValue(catalogueRepository.getAllMovies())
        verify(remote).getAllMovie(any())
        Assert.assertNotNull(movieEntities)
        Assert.assertEquals(movieResponses.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getAllTvShows() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvShowsCallback)
                .onAllTvShowsReceived(tvShowResponses)
            null
        }.`when`(remote).getAllTvShow(any())
        val tvShowEntities = LiveDataTestUtils.getValue(catalogueRepository.getAllTvShows())
        verify(remote).getAllTvShow(any())
        Assert.assertNotNull(tvShowEntities)
        Assert.assertEquals(tvShowResponses.size.toLong(), tvShowResponses.size.toLong())
    }

    @Test
    fun getDetailMovie() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onAllMoviesReceived(movieResponses)
            null
        }.`when`(remote).getAllMovie(any())
        val movieEntities = LiveDataTestUtils.getValue(catalogueRepository.getDetailMovie(movieId))
        verify(remote).getAllMovie(any())
        Assert.assertNotNull(movieEntities)
        Assert.assertNotNull(movieEntities.movieTitle)
        Assert.assertEquals(movieResponses[0].movieTitle, movieEntities.movieTitle)
    }

    @Test
    fun getDetailTvShow() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvShowsCallback)
                .onAllTvShowsReceived(tvShowResponses)
            null
        }.`when`(remote).getAllTvShow(any())
        val tvShowEntities = LiveDataTestUtils.getValue(catalogueRepository.getDetailTvShow(tvShowId))
        verify(remote).getAllTvShow(any())
        Assert.assertNotNull(tvShowEntities)
        Assert.assertNotNull(tvShowEntities.tvShowTitle)
        Assert.assertEquals(tvShowResponses[0].tvShowTitle, tvShowEntities.tvShowTitle)
    }
}