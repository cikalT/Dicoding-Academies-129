package cikal.dicoding.submission2.utils

import android.content.Context
import cikal.dicoding.submission2.data.source.remote.response.MovieResponse
import cikal.dicoding.submission2.data.source.remote.response.TvShowResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovies(): List<MovieResponse> {
        val listMovie = ArrayList<MovieResponse>()

        try {
            val responseObject = JSONObject(parsingFileToString("MovieResponse.json").toString())
            val listArray = responseObject.getJSONArray("movie")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)

                val movieId = movie.getString("movieId")
                val movieTitle = movie.getString("movieTitle")
                val moviePoster = movie.getString("moviePoster")
                val movieYear = movie.getString("movieYear")
                val movieDesc = movie.getString("movieDesc")

                val movieResponse = MovieResponse(movieId, movieTitle, moviePoster, movieYear, movieDesc)
                listMovie.add(movieResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return listMovie
    }

    fun loadTvShows(): List<TvShowResponse> {
        val listTvShow = ArrayList<TvShowResponse>()

        try {
            val responseObject = JSONObject(parsingFileToString("TvShowResponse.json").toString())
            val listArray = responseObject.getJSONArray("tvShow")
            for (i in 0 until listArray.length()) {
                val tvShow = listArray.getJSONObject(i)

                val tvShowId = tvShow.getString("tvShowId")
                val tvShowTitle = tvShow.getString("tvShowTitle")
                val tvShowPoster = tvShow.getString("tvShowPoster")
                val tvShowYear = tvShow.getString("tvShowYear")
                val tvShowDesc = tvShow.getString("tvShowDesc")

                val tvShowResponse = TvShowResponse(tvShowId, tvShowTitle, tvShowPoster, tvShowYear, tvShowDesc)
                listTvShow.add(tvShowResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return listTvShow
    }
}