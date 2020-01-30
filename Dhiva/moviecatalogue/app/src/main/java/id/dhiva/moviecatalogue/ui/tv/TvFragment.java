package id.dhiva.moviecatalogue.ui.tv;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import id.dhiva.moviecatalogue.R;
import id.dhiva.moviecatalogue.model.ModelItem;
import id.dhiva.moviecatalogue.ui.detail.DetailItemActivity;
import id.dhiva.moviecatalogue.viewmodel.ViewModelFactory;

import static id.dhiva.moviecatalogue.ui.detail.DetailItemActivity.EXTRA_FROM;
import static id.dhiva.moviecatalogue.ui.detail.DetailItemActivity.EXTRA_POSITION;
import static id.dhiva.moviecatalogue.ui.detail.DetailItemActivity.VAL_TV;

public class TvFragment extends Fragment {

    private TvViewModel tvViewModel;
    private AdapterTV adapter;
    private RecyclerView rvMovie;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        if (getActivity()!=null){
            tvViewModel = obtainViewModel(getActivity());
        }

        tvViewModel.getAllTvList().observe(this, getAllTvList);
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
        onItemClick();
    }

    private void init(View view){
        rvMovie = view.findViewById(R.id.rv_tv);
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
            public void onItemClicked(int position) {
                Intent intent = new Intent(getContext(), DetailItemActivity.class);
                intent.putExtra(EXTRA_POSITION, position);
                intent.putExtra(EXTRA_FROM, VAL_TV);
                startActivity(intent);
            }
        });
    }


    @NonNull
    private static TvViewModel obtainViewModel(FragmentActivity activity){
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(TvViewModel.class);
    }
}