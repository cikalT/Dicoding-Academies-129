package id.dhiva.moviecatalogue.ui.tv;

import java.util.ArrayList;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import id.dhiva.moviecatalogue.data.DataRepository;
import id.dhiva.moviecatalogue.model.ModelItem;

public class TvViewModel extends ViewModel {
    private DataRepository dataRepository;
    MutableLiveData<ArrayList<ModelItem>> allTvList = new MutableLiveData<>();

    public TvViewModel(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    MutableLiveData<ArrayList<ModelItem>> getAllTvList(){
        allTvList.postValue(dataRepository.getAllTv());
        return allTvList;
    }

}