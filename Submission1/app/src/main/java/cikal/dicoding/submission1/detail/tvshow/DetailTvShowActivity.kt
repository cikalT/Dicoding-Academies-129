package cikal.dicoding.submission1.detail.tvshow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import cikal.dicoding.submission1.R
import cikal.dicoding.submission1.data.TvShowEntity
import kotlinx.android.synthetic.main.activity_detail_movie.*

class DetailTvShowActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TV_SHOW = "extra_tv_show"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tv_show)

        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailTvShowViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val tvShowId = extras.getString(EXTRA_TV_SHOW)
            if (tvShowId != null) {
                viewModel.setSelectedTvShow(tvShowId)
                populateTvShow(viewModel.getTvShow())
            }
        }
    }

    private fun populateTvShow(tvShow: TvShowEntity) {
        tv_title.text = tvShow.tvShowTitle
        tv_year.text = tvShow.tvShowYear
        tv_desc.text = tvShow.tvShowDesc
        iv_poster.setImageResource(tvShow.tvShowPoster)
    }
}
