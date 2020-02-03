package cikal.dicoding.submission2.data.source.remote

import android.os.Handler
import cikal.dicoding.submission2.data.source.remote.response.MovieResponse
import cikal.dicoding.submission2.data.source.remote.response.TvShowResponse
import cikal.dicoding.submission2.utils.EspressoIdlingResource
import cikal.dicoding.submission2.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    private val handler = Handler()

    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper)
            }
    }

    fun getAllMovie(callback: LoadMoviesCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onAllMoviesReceived(jsonHelper.loadMovies())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getAllTvShow(callback: LoadTvShowsCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onAllTvShowsRecived(jsonHelper.loadTvShows())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    interface LoadMoviesCallback {
        fun onAllMoviesReceived(moviesResponses: List<MovieResponse>)
    }

    interface LoadTvShowsCallback {
        fun onAllTvShowsRecived(tvShowsResponse: List<TvShowResponse>)
    }
}