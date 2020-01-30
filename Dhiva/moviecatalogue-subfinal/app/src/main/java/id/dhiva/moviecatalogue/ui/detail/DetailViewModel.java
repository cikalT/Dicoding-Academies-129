package id.dhiva.moviecatalogue.ui.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import id.dhiva.moviecatalogue.data.DataRepository;
import id.dhiva.moviecatalogue.database.MovieEntity;
import id.dhiva.moviecatalogue.database.TvEntity;
import id.dhiva.moviecatalogue.model.ModelItem;

public class DetailViewModel extends ViewModel {
    private DataRepository dataRepository;
    private int id;
    private String from;
    private MutableLiveData<ModelItem> itemDetail = new MutableLiveData<>();

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

    void insertMovie(){
        dataRepository.insertMovie(id);
    }

    LiveData<MovieEntity> getFavMovie(){
        return dataRepository.getFavMovie(id);
    }

    void deleteMovie(){
        dataRepository.deleteMovie(id);
    }

    void insertTv(){
        dataRepository.insertTv(id);
    }

    LiveData<TvEntity> getFavTv(){
        return dataRepository.getFavTv(id);
    }

    void deleteTv(){
        dataRepository.deleteTv(id);
    }

}
