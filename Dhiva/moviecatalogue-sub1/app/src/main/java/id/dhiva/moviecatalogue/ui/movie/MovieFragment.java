package id.dhiva.moviecatalogue.ui.movie;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import id.dhiva.moviecatalogue.R;
import id.dhiva.moviecatalogue.model.ModelItem;
import id.dhiva.moviecatalogue.ui.detail.DetailItemActivity;

import static id.dhiva.moviecatalogue.ui.detail.DetailItemActivity.EXTRA_DETAIL;

public class MovieFragment extends Fragment {

    private MovieViewModel movieViewModel;
    private AdapterMovie adapter;
    private RecyclerView rvMovie;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        View root = inflater.inflate(R.layout.fragment_movie, container, false);
        init(root);

        adapter = new AdapterMovie();
        adapter.notifyDataSetChanged();

        rvMovie.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        rvMovie.setAdapter(adapter);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        prepare();
        onItemClick();
    }

    private void init(View view){
        rvMovie = view.findViewById(R.id.rv_movie);
    }

    private void prepare(){
        String[] filmTitle = getResources().getStringArray(R.array.data_film_title);
        String[] filmRating = getResources().getStringArray(R.array.data_film_rating);
        TypedArray filmPoster = getResources().obtainTypedArray(R.array.data_film_poster);
        String[] filmGenre = getResources().getStringArray(R.array.data_film_genre);
        String[] filmDesc = getResources().getStringArray(R.array.data_film_description);
        String[] filmDate = getResources().getStringArray(R.array.data_film_release);

        ArrayList<ModelItem> list = new ArrayList<>();
        for (int i = 0; i < filmTitle.length; i++){
            ModelItem movie = new ModelItem();
            movie.setPoster(filmPoster.getResourceId(i, -1));
            movie.setTitle(filmTitle[i]);
            movie.setGenre(filmGenre[i]);
            movie.setDesc(filmDesc[i]);
            movie.setRating(filmRating[i]);
            movie.setDate(filmDate[i]);
            list.add(movie);
        }
        filmPoster.recycle();

        movieViewModel.setAllMovieList(list);
        movieViewModel.getAllMovieList().observe(this, getALlMovieList);
    }

    private Observer<ArrayList<ModelItem>>getALlMovieList = new Observer<ArrayList<ModelItem>>() {
        @Override
        public void onChanged(ArrayList<ModelItem> modelItems) {
            if (modelItems!=null){
                adapter.setData(modelItems);
            }
        }
    };

    private void onItemClick() {
        adapter.setOnItemClickCallback(new AdapterMovie.OnItemClickCallback() {
            @Override
            public void onItemClicked(ModelItem data) {
                Intent intent = new Intent(getContext(), DetailItemActivity.class);
                intent.putExtra(EXTRA_DETAIL, data);
                startActivity(intent);
            }
        });
    }
}