package cikal.dicoding.submission1.home.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import cikal.dicoding.submission1.R
import cikal.dicoding.submission1.data.TvShowEntity
import cikal.dicoding.submission1.detail.tvshow.DetailTvShowActivity
import kotlinx.android.synthetic.main.item_content.view.*
import java.util.*

class TvShowAdapter: RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>()  {

    private var listTvShows = ArrayList<TvShowEntity>()

    fun setTvShows(tvShows: List<TvShowEntity>?) {
        if (tvShows == null) return
        this.listTvShows.clear()
        this.listTvShows.addAll(tvShows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_content, parent, false)
        return TvShowViewHolder(view)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvShow = listTvShows[position]
        holder.bind(tvShow)
    }

    override fun getItemCount(): Int = listTvShows.size

    class TvShowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(tvShow: TvShowEntity) {
            with(itemView) {
                tv_title.text = tvShow.tvShowTitle
                tv_date.text = tvShow.tvShowYear
                tv_desc.text = tvShow.tvShowDesc
                iv_poster.setImageResource(tvShow.tvShowPoster)

                itemView.setOnClickListener {
                    Toast.makeText(context, tvShow.tvShowTitle, Toast.LENGTH_SHORT).show()
                    val intent = Intent(itemView.context, DetailTvShowActivity::class.java)
                    intent.putExtra(DetailTvShowActivity.EXTRA_TV_SHOW, tvShow.tvShowId)
                    itemView.context.startActivity(intent)
                }
            }
        }

    }

}