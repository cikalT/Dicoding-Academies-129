package id.dhiva.moviecatalogue.data.di;

import android.app.Application;

import id.dhiva.moviecatalogue.data.DataHelper;
import id.dhiva.moviecatalogue.data.DataRepository;

public class Injection {
    public static DataRepository provideRepository(Application application){
        return DataRepository.getInstance(new DataHelper(application));
    }
}
