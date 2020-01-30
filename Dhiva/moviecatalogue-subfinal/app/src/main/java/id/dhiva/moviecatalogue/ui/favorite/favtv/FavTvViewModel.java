package id.dhiva.moviecatalogue.ui.favorite.favtv;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import id.dhiva.moviecatalogue.data.DataRepository;
import id.dhiva.moviecatalogue.database.TvEntity;

public class FavTvViewModel extends ViewModel {
    private DataRepository dataRepository;

    public FavTvViewModel(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    LiveData<PagedList<TvEntity>> getAllFavMovie(){
        return new LivePagedListBuilder<>(dataRepository.getAllFavTv(), 5).build();
    }
}
