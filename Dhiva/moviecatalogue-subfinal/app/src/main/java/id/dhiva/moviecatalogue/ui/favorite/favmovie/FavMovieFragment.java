package id.dhiva.moviecatalogue.ui.favorite.favmovie;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import id.dhiva.moviecatalogue.R;
import id.dhiva.moviecatalogue.database.MovieEntity;
import id.dhiva.moviecatalogue.ui.detail.DetailItemActivity;
import id.dhiva.moviecatalogue.ui.movie.AdapterMovie;
import id.dhiva.moviecatalogue.viewmodel.ViewModelFactory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import static id.dhiva.moviecatalogue.ui.detail.DetailItemActivity.EXTRA_FROM;
import static id.dhiva.moviecatalogue.ui.detail.DetailItemActivity.EXTRA_POSITION;
import static id.dhiva.moviecatalogue.ui.detail.DetailItemActivity.VAL_MOVIE;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavMovieFragment extends Fragment {
    private FavMovieViewModel favMovieViewModel;
    private RecyclerView rv;
    private MoviePagedListAdapter adapter;
    private List<MovieEntity> movieEntity;

    public FavMovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_fav_movie, container, false);
        if (getActivity()!=null){
            favMovieViewModel = obtainViewModel(getActivity());
        }
        favMovieViewModel.getAllFavMovies().observe(this, getAllFavMovies);
        init(root);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new MoviePagedListAdapter();
        adapter.notifyDataSetChanged();
        adapter.setOnItemClickCallback(new AdapterMovie.OnItemClickCallback() {
            @Override
            public void onItemClicked(int position) {
                Intent intent = new Intent(getContext(), DetailItemActivity.class);
                intent.putExtra(EXTRA_POSITION, movieEntity.get(position).getPosition());
                intent.putExtra(EXTRA_FROM, VAL_MOVIE);
                startActivity(intent);
            }
        });
        rv.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        rv.setAdapter(adapter);
    }

    private void init(View view){
        rv = view.findViewById(R.id.rv_movie);
    }

    private Observer<PagedList<MovieEntity>> getAllFavMovies = new Observer<PagedList<MovieEntity>>() {
        @Override
        public void onChanged(PagedList<MovieEntity> movieEntities) {
            movieEntity = movieEntities;
            adapter.submitList(movieEntities);
        }
    };

    @NonNull
    private static FavMovieViewModel obtainViewModel(FragmentActivity activity){
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(FavMovieViewModel.class);
    }

}
