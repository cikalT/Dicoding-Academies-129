package cikal.dicoding.finalsubmission.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponse (
    var movieId: String,
    var movieTitle: String,
    var moviePoster: String,
    var movieYear: String,
    var movieDesc: String
) : Parcelable