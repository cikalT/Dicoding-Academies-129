package id.dhiva.moviecatalogue.ui.detail;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import id.dhiva.moviecatalogue.model.ModelItem;

public class DetailViewModel extends ViewModel {
    MutableLiveData<ModelItem> itemDetail = new MutableLiveData<>();

    void setDetail(ModelItem item){
        itemDetail.postValue(item);
    }

    MutableLiveData<ModelItem> getItemDetail(){
        return itemDetail;
    }
}
