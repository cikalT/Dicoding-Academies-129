package id.dhiva.moviecatalogue.ui.favorite.favtv;


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
import id.dhiva.moviecatalogue.database.TvEntity;
import id.dhiva.moviecatalogue.ui.detail.DetailItemActivity;
import id.dhiva.moviecatalogue.ui.tv.AdapterTV;
import id.dhiva.moviecatalogue.viewmodel.ViewModelFactory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import static id.dhiva.moviecatalogue.ui.detail.DetailItemActivity.EXTRA_FROM;
import static id.dhiva.moviecatalogue.ui.detail.DetailItemActivity.EXTRA_POSITION;
import static id.dhiva.moviecatalogue.ui.detail.DetailItemActivity.VAL_TV;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavTvFragment extends Fragment {
    private FavTvViewModel favTvViewModel;
    private TvPagedListAdapter adapter;
    private RecyclerView rv;
    private List<TvEntity> tvEntity;

    public FavTvFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_fav_tv, container, false);
        if (getActivity()!=null){
            favTvViewModel = obtainViewModel(getActivity());
        }
        favTvViewModel.getAllFavMovie().observe(this, getAllFavTv);
        init(root);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new TvPagedListAdapter();
        adapter.notifyDataSetChanged();

        rv.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        rv.setAdapter(adapter);

        adapter.setOnItemClickCallback(new AdapterTV.OnItemClickCallback() {
            @Override
            public void onItemClicked(int position) {
                Intent intent = new Intent(getContext(), DetailItemActivity.class);
                intent.putExtra(EXTRA_POSITION, tvEntity.get(position).getPosition());
                intent.putExtra(EXTRA_FROM, VAL_TV);
                startActivity(intent);
            }
        });

    }

    private void init(View view){
        rv = view.findViewById(R.id.rv_tv);

    }

    private Observer<PagedList<TvEntity>> getAllFavTv = new Observer<PagedList<TvEntity>>() {
        @Override
        public void onChanged(PagedList<TvEntity> tvEntities) {
            tvEntity = tvEntities;
            adapter.submitList(tvEntities);
        }
    };

    @NonNull
    private static FavTvViewModel obtainViewModel(FragmentActivity activity){
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(FavTvViewModel.class);
    }
}
