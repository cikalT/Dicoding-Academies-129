package cikal.dicoding.submission2.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cikal.dicoding.submission2.data.source.local.entity.MovieEntity
import cikal.dicoding.submission2.data.source.local.entity.TvShowEntity
import cikal.dicoding.submission2.data.source.remote.RemoteDataSource
import cikal.dicoding.submission2.data.source.remote.response.MovieResponse
import cikal.dicoding.submission2.data.source.remote.response.TvShowResponse
import java.util.*

class FakeCatalogueRepository(private val remoteDataSource: RemoteDataSource) : CatalogueDataSource{

    override fun getAllMovies(): LiveData<List<MovieEntity>> {
        val movieResults = MutableLiveData<List<MovieEntity>>()
        remoteDataSource.getAllMovie(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMoviesReceived(moviesResponses: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (i in moviesResponses.indices) {
                    val response = moviesResponses[i]
                    val movie = MovieEntity(response.movieId,
                        response.movieTitle,
                        response.moviePoster,
                        response.movieYear,
                        response.movieDesc)
                    movieList.add(movie)
                }
                movieResults.postValue(movieList)
            }
        })
        return movieResults
    }

    override fun getAllTvShows(): LiveData<List<TvShowEntity>> {
        val tvShowResults = MutableLiveData<List<TvShowEntity>>()
        remoteDataSource.getAllTvShow(object : RemoteDataSource.LoadTvShowsCallback {
            override fun onAllTvShowsReceived(tvShowsResponse: List<TvShowResponse>) {
                val tvShowList = ArrayList<TvShowEntity>()
                for (i in tvShowsResponse.indices) {
                    val response = tvShowsResponse[i]
                    val tvShow = TvShowEntity(response.tvShowId,
                        response.tvShowTitle,
                        response.tvShowPoster,
                        response.tvShowYear,
                        response.tvShowDesc)
                    tvShowList.add(tvShow)
                }
                tvShowResults.postValue(tvShowList)
            }
        })
        return tvShowResults
    }

    override fun getDetailMovie(contentId: String): LiveData<MovieEntity> {
        val movieResults = MutableLiveData<MovieEntity>()
        remoteDataSource.getAllMovie(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMoviesReceived(moviesResponses: List<MovieResponse>) {
                for (i in moviesResponses.indices) {
                    val response = moviesResponses[i]
                    if (response.movieId == contentId) {
                        val movie = MovieEntity(response.movieId,
                            response.movieTitle,
                            response.moviePoster,
                            response.movieYear,
                            response.movieDesc)
                        movieResults.postValue(movie)
                    }
                }
            }
        })
        return movieResults
    }

    override fun getDetailTvShow(contentId: String): LiveData<TvShowEntity> {
        val tvShowResults = MutableLiveData<TvShowEntity>()
        remoteDataSource.getAllTvShow(object : RemoteDataSource.LoadTvShowsCallback {
            override fun onAllTvShowsReceived(tvShowsResponse: List<TvShowResponse>) {
                for (i in tvShowsResponse.indices) {
                    val response = tvShowsResponse[i]
                    if (response.tvShowId == contentId) {
                        val tvShow = TvShowEntity(response.tvShowId,
                            response.tvShowTitle,
                            response.tvShowPoster,
                            response.tvShowYear,
                            response.tvShowDesc)
                        tvShowResults.postValue(tvShow)
                    }
                }
            }
        })
        return tvShowResults
    }

}