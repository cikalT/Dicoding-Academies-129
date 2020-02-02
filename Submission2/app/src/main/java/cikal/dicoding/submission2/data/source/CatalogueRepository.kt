package cikal.dicoding.submission2.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cikal.dicoding.submission2.data.source.local.entity.MovieEntity
import cikal.dicoding.submission2.data.source.remote.RemoteDataSource
import cikal.dicoding.submission2.data.source.remote.response.MovieResponse

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
}