package id.dhiva.moviecatalogue.ui.tv;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import id.dhiva.moviecatalogue.R;
import id.dhiva.moviecatalogue.model.ModelItem;
import id.dhiva.moviecatalogue.ui.detail.DetailItemActivity;

import static id.dhiva.moviecatalogue.ui.detail.DetailItemActivity.EXTRA_DETAIL;

public class TvFragment extends Fragment {

    private TvViewModel tvViewModel;
    private AdapterTV adapter;
    private RecyclerView rvMovie;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        tvViewModel =
                ViewModelProviders.of(this).get(TvViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tv, container, false);
        init(root);

        adapter = new AdapterTV();
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
        rvMovie = view.findViewById(R.id.rv_tv);
    }

    private void prepare(){
        String[] tvTitle = getResources().getStringArray(R.array.data_tv_show_title);
        String[] tvRating = getResources().getStringArray(R.array.data_tv_show_rating);
        TypedArray tvPoster = getResources().obtainTypedArray(R.array.data_tv_show_poster);
        String[] tvGenre = getResources().getStringArray(R.array.data_tv_show_genre);
        String[] tvDesc = getResources().getStringArray(R.array.data_tv_show_description);
        String[] tvDate = getResources().getStringArray(R.array.data_tv_show_release);

        ArrayList<ModelItem> list = new ArrayList<>();
        for (int i = 0; i < tvTitle.length; i++){
            ModelItem tv = new ModelItem();
            tv.setPoster(tvPoster.getResourceId(i, -1));
            tv.setTitle(tvTitle[i]);
            tv.setGenre(tvGenre[i]);
            tv.setDesc(tvDesc[i]);
            tv.setRating(tvRating[i]);
            tv.setDate(tvDate[i]);
            list.add(tv);
        }
        tvPoster.recycle();

        tvViewModel.setAllTvList(list);
        tvViewModel.getAllTvList().observe(this, getAllTvList);
    }

    private Observer<ArrayList<ModelItem>>getAllTvList = new Observer<ArrayList<ModelItem>>() {
        @Override
        public void onChanged(ArrayList<ModelItem> modelItems) {
            if (modelItems!=null){
                adapter.setData(modelItems);
            }
        }
    };


    private void onItemClick() {
        adapter.setOnItemClickCallback(new AdapterTV.OnItemClickCallback() {
            @Override
            public void onItemClicked(ModelItem data) {
                Intent intent = new Intent(getContext(), DetailItemActivity.class);
                intent.putExtra(EXTRA_DETAIL,data);
                startActivity(intent);
            }
        });
    }
}