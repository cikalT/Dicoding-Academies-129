package cikal.dicoding.submission2.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvShowResponse (
    var tvShowId: String,
    var tvShowTitle: String,
    var tvShowPoster: String,
    var tvShowYear: String,
    var tvShowDesc: String
) : Parcelable