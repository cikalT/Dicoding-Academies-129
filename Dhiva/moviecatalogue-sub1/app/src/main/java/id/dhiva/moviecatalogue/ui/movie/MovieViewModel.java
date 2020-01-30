package id.dhiva.moviecatalogue.ui.movie;

import java.util.ArrayList;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import id.dhiva.moviecatalogue.model.ModelItem;

public class MovieViewModel extends ViewModel {
    MutableLiveData<ArrayList<ModelItem>> alllMovieList = new MutableLiveData<>();

    void setAllMovieList(ArrayList<ModelItem> item){
        alllMovieList.postValue(item);
    }

    MutableLiveData<ArrayList<ModelItem>> getAllMovieList(){
        return alllMovieList;
    }


}