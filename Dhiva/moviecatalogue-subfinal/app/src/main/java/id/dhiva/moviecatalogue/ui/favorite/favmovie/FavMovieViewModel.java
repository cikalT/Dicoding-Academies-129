package id.dhiva.moviecatalogue.ui.favorite.favmovie;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import id.dhiva.moviecatalogue.data.DataRepository;
import id.dhiva.moviecatalogue.database.MovieEntity;

public class FavMovieViewModel extends ViewModel {
    private DataRepository dataRepository;

    public FavMovieViewModel(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    LiveData<PagedList<MovieEntity>> getAllFavMovies(){
        return new LivePagedListBuilder<>(dataRepository.getAllFavMovies(), 10).build();
    }
}
