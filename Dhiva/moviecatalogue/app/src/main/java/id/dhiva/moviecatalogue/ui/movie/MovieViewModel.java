package id.dhiva.moviecatalogue.ui.movie;

import java.util.ArrayList;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import id.dhiva.moviecatalogue.data.DataRepository;
import id.dhiva.moviecatalogue.model.ModelItem;

public class MovieViewModel extends ViewModel {
    private MutableLiveData<ArrayList<ModelItem>> allMovieList = new MutableLiveData<>();
    private DataRepository dataRepository;

    public MovieViewModel(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    MutableLiveData<ArrayList<ModelItem>> getAllMovieList(){
        allMovieList.postValue(dataRepository.getAllMovies());
        return allMovieList;
    }


}