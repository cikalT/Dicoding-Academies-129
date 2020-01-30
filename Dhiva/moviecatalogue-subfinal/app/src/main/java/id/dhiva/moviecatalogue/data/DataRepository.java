package id.dhiva.moviecatalogue.data;

import java.util.ArrayList;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import id.dhiva.moviecatalogue.database.MovieEntity;
import id.dhiva.moviecatalogue.database.TvEntity;
import id.dhiva.moviecatalogue.model.ModelItem;

public class DataRepository {
    private static DataRepository INSTANCE;
    private DataHelper dataHelper;

    private DataRepository(DataHelper dataHelper){
        this.dataHelper = dataHelper;
    }

    public static DataRepository getInstance(DataHelper dataHelper){
        if (INSTANCE==null){
            INSTANCE = new DataRepository(dataHelper);
        }
        return INSTANCE;
    }

    public ArrayList<ModelItem> getAllMovies(){
        return dataHelper.allMovies();
    }

    public ArrayList<ModelItem> getAllTv(){
        return dataHelper.allTvs();
    }

    public ModelItem getDetail(int id, String from){
        return dataHelper.detail(id, from);
    }

    public void insertMovie(int id){
        dataHelper.insertFavMovie(id);
    }

    public DataSource.Factory<Integer, MovieEntity> getAllFavMovies(){
        return dataHelper.getAllFavMovie();
    }

    public LiveData<MovieEntity> getFavMovie(int id){
        return dataHelper.getFavMovie(id);
    }

    public void deleteMovie(int id){
        dataHelper.deleteMovie(id);
    }

    public DataSource.Factory<Integer, TvEntity> getAllFavTv(){
        return dataHelper.getAllFavTv();
    }

    public void insertTv(int id){
        dataHelper.insertFavTv(id);
    }

    public LiveData<TvEntity> getFavTv(int id){
        return dataHelper.getFavTv(id);
    }

    public void deleteTv(int id){
        dataHelper.deleteTv(id);
    }

}
