package id.dhiva.moviecatalogue.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import id.dhiva.moviecatalogue.data.DataRepository;
import id.dhiva.moviecatalogue.data.di.Injection;
import id.dhiva.moviecatalogue.ui.detail.DetailViewModel;
import id.dhiva.moviecatalogue.ui.favorite.favmovie.FavMovieViewModel;
import id.dhiva.moviecatalogue.ui.favorite.favtv.FavTvViewModel;
import id.dhiva.moviecatalogue.ui.movie.MovieViewModel;
import id.dhiva.moviecatalogue.ui.tv.TvViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private static volatile ViewModelFactory INSTANCE;
    private final DataRepository dataRepository;

    private ViewModelFactory(DataRepository dataRepository){
        this.dataRepository = dataRepository;
    }

    public static ViewModelFactory getInstance(Application application) {
        if (INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ViewModelFactory(Injection.provideRepository(application));
                }
            }
        }
        return INSTANCE;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if (modelClass.isAssignableFrom(MovieViewModel.class)) {
            //noinspection unchecked
            return (T) new MovieViewModel(dataRepository);
        } else if (modelClass.isAssignableFrom(DetailViewModel.class)) {
            //noinspection unchecked
            return (T) new DetailViewModel(dataRepository);
        } else if (modelClass.isAssignableFrom(TvViewModel.class)) {
            //noinspection unchecked
            return (T) new TvViewModel(dataRepository);
        } else if(modelClass.isAssignableFrom(FavMovieViewModel.class)){
            //noinspection unchecked
            return (T) new FavMovieViewModel(dataRepository);
        } else if(modelClass.isAssignableFrom(FavTvViewModel.class)){
            //noinspection unchecked
            return (T) new FavTvViewModel(dataRepository);
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
