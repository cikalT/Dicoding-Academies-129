package cikal.dicoding.submission2.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import cikal.dicoding.submission2.R
import cikal.dicoding.submission2.data.source.local.entity.MovieEntity
import cikal.dicoding.submission2.data.source.local.entity.TvShowEntity
import cikal.dicoding.submission2.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_detail_catalogue.*

class DetailCatalogueActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_CONTENT = "extra_content"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_catalogue)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailCatalogueViewModel::class.java]

        val extras = intent.extras

        if (extras != null) {
            val contentId = extras.getString(EXTRA_CONTENT)
            if (contentId != null) {
                viewModel.setSelectedContent(contentId)

                when (contentId.substring(0, 2)) {
                    "mv" -> {
                        progress_bar_detail.visibility = View.VISIBLE
                        viewModel.getDetailMovie().observe(this, Observer { movie ->
                            progress_bar_detail.visibility = View.GONE
                            populateMovie(movie)
                        })
                    }
                    "tv" -> {
                        progress_bar_detail.visibility = View.VISIBLE
                        viewModel.getDetailTvShow().observe(this, Observer { tvShow ->
                            progress_bar_detail.visibility = View.GONE
                            populateTvShow(tvShow)
                        })
                    }
                }
            }
        }
    }

    private fun populateMovie(movie: MovieEntity?) {
        tv_title.text = movie?.movieTitle
        tv_year.text = movie?.movieYear
        tv_desc.text = movie?.movieDesc
        val mDrawableName = movie?.moviePoster
        iv_poster.setImageResource(resources.getIdentifier(mDrawableName, "drawable", packageName))
    }

    private fun populateTvShow(tvShow: TvShowEntity?) {
        tv_title.text = tvShow?.tvShowTitle
        tv_year.text = tvShow?.tvShowYear
        tv_desc.text = tvShow?.tvShowDesc
        val mDrawableName = tvShow?.tvShowPoster
        iv_poster.setImageResource(resources.getIdentifier(mDrawableName, "drawable", packageName))
    }
}
