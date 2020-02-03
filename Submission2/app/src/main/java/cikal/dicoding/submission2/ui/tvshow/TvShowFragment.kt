package cikal.dicoding.submission2.ui.tvshow


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import cikal.dicoding.submission2.R
import cikal.dicoding.submission2.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_tv_show.*

class TvShowFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]

            val tvShowAdapter = TvShowAdapter()
            progress_bar_tv_show.visibility = View.VISIBLE
            viewModel.getTvShows().observe(this, Observer { tvShows ->
                progress_bar_tv_show.visibility = View.GONE
                tvShowAdapter.setTvShow(tvShows)
                tvShowAdapter.notifyDataSetChanged()
            })

            with(rv_tv_show) {
                layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowAdapter
            }
        }
    }
}
