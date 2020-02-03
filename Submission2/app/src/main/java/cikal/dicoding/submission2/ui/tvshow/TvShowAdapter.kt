package cikal.dicoding.submission2.ui.tvshow

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import cikal.dicoding.submission2.R
import cikal.dicoding.submission2.data.source.local.entity.TvShowEntity
import kotlinx.android.synthetic.main.item_content.view.*

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {

    private var listTvShow = ArrayList<TvShowEntity>()

    fun setTvShow(tvShows: List<TvShowEntity>?) {
        if (tvShows == null) return
        this.listTvShow.clear()
        this.listTvShow.addAll(tvShows)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TvShowViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_content, parent, false)
        return TvShowAdapter.TvShowViewHolder(view)
    }

    override fun getItemCount(): Int = listTvShow.size

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvShow = listTvShow[position]
        holder.bind(tvShow)
    }

    class TvShowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(tvShow: TvShowEntity) {
            with(itemView) {
                tv_title.text = tvShow.tvShowTitle
                tv_date.text = tvShow.tvShowYear
                tv_desc.text = tvShow.tvShowDesc
                val mDrawableName = tvShow.tvShowPoster
                iv_poster.setImageResource(resources.getIdentifier(mDrawableName, "drawable", context.packageName))

                itemView.setOnClickListener {
                    Toast.makeText(context, tvShow.tvShowTitle, Toast.LENGTH_SHORT).show()
//                    val intent = Intent(itemView.context, DetailMovieActivity::class.java)
//                    intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movie.movieId)
//                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}