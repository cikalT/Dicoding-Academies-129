package cikal.dicoding.submission2.data.source.remote

import android.os.Handler
import cikal.dicoding.submission2.data.source.remote.response.MovieResponse
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
        handler.postDelayed({ callback.onAllMoviesReceived(jsonHelper.loadMovies()) }, SERVICE_LATENCY_IN_MILLIS)
    }

    interface LoadMoviesCallback {
        fun onAllMoviesReceived(moviesResponses: List<MovieResponse>)
    }
}