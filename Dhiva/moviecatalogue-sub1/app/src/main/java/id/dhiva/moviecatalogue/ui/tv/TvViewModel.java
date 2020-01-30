package id.dhiva.moviecatalogue.ui.tv;

import java.util.ArrayList;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import id.dhiva.moviecatalogue.model.ModelItem;

public class TvViewModel extends ViewModel {
    MutableLiveData<ArrayList<ModelItem>> allTvList = new MutableLiveData<>();

    void setAllTvList(ArrayList<ModelItem> item){
        allTvList.postValue(item);
    }

    MutableLiveData<ArrayList<ModelItem>> getAllTvList(){
        return allTvList;
    }

}