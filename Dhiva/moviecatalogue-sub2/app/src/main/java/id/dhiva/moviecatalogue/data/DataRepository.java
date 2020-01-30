package id.dhiva.moviecatalogue.data;

import java.util.ArrayList;

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
}
