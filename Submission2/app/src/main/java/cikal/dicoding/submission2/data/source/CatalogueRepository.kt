package cikal.dicoding.submission2.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cikal.dicoding.submission2.data.source.local.entity.MovieEntity
import cikal.dicoding.submission2.data.source.local.entity.TvShowEntity
import cikal.dicoding.submission2.data.source.remote.RemoteDataSource
import cikal.dicoding.submission2.data.source.remote.response.MovieResponse
import cikal.dicoding.submission2.data.source.remote.response.TvShowResponse

class CatalogueRepository private constructor(private val remoteDataSource: RemoteDataSource) : CatalogueDataSource {

    companion object {
        @Volatile
        private var instance: CatalogueRepository? = null

        fun getInstance(remoteData: RemoteDataSource): CatalogueRepository =
            instance ?: synchronized(this) {
                instance ?: CatalogueRepository(remoteData)
            }
    }


    override fun getAllMovies(): LiveData<List<MovieEntity>> {
        val movieResult = MutableLiveData<List<MovieEntity>>()
        remoteDataSource.getAllMovie(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMoviesReceived(moviesResponses: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in moviesResponses) {
                    val movie = MovieEntity(response.movieId,
                        response.movieTitle,
                        response.moviePoster,
                        response.movieYear,
                        response.movieDesc)
                    movieList.add(movie)
                }
                movieResult.postValue(movieList)
            }
        })
        return movieResult
    }

    override fun getAllTvShows(): LiveData<List<TvShowEntity>> {
        val tvShowResult = MutableLiveData<List<TvShowEntity>>()
        remoteDataSource.getAllTvShow(object : RemoteDataSource.LoadTvShowsCallback {
            override fun onAllTvShowsReceived(tvShowsResponse: List<TvShowResponse>) {
                val tvShowList = ArrayList<TvShowEntity>()
                for (response in tvShowsResponse) {
                    val tvShow = TvShowEntity(response.tvShowId,
                        response.tvShowTitle,
                        response.tvShowPoster,
                        response.tvShowYear,
                        response.tvShowDesc)
                    tvShowList.add(tvShow)
                }
                tvShowResult.postValue(tvShowList)
            }
        })
        return tvShowResult
    }

    override fun getDetailMovie(contentId: String): LiveData<MovieEntity> {
        val movieResult = MutableLiveData<MovieEntity>()
        remoteDataSource.getAllMovie(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMoviesReceived(moviesResponses: List<MovieResponse>) {
                lateinit var movie: MovieEntity
                for (response in moviesResponses) {
                    if (response.movieId == contentId) {
                        movie = MovieEntity(response.movieId,
                            response.movieTitle,
                            response.moviePoster,
                            response.movieYear,
                            response.movieDesc)
                    }
                }
                movieResult.postValue(movie)
            }
        })
        return movieResult
    }

    override fun getDetailTvShow(contentId: String): LiveData<TvShowEntity> {
        val tvShowResult = MutableLiveData<TvShowEntity>()
        remoteDataSource.getAllTvShow(object : RemoteDataSource.LoadTvShowsCallback {
            override fun onAllTvShowsReceived(tvShowsResponse: List<TvShowResponse>) {
                lateinit var tvShow: TvShowEntity
                for (response in tvShowsResponse) {
                    if (response.tvShowId == contentId) {
                        tvShow = TvShowEntity(response.tvShowId,
                            response.tvShowTitle,
                            response.tvShowPoster,
                            response.tvShowYear,
                            response.tvShowDesc)
                    }
                }
                tvShowResult.postValue(tvShow)
            }
        })
        return tvShowResult
    }

}