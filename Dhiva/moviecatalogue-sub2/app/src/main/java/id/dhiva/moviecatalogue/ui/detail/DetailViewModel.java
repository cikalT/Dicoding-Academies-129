package id.dhiva.moviecatalogue.ui.detail;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import id.dhiva.moviecatalogue.data.DataRepository;
import id.dhiva.moviecatalogue.model.ModelItem;

public class DetailViewModel extends ViewModel {
    private DataRepository dataRepository;
    private int id;
    private String from;
    MutableLiveData<ModelItem> itemDetail = new MutableLiveData<>();

    public DetailViewModel(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public void setId(int id) {
        this.id = id;
    }

    void setFrom(String from) {
        this.from = from;
    }

    MutableLiveData<ModelItem> getItemDetail(){
        itemDetail.postValue(dataRepository.getDetail(id, from));
        return itemDetail;
    }

}
