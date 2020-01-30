package id.dhiva.moviecatalogue.data;

import android.app.Application;
import android.content.res.TypedArray;

import java.util.ArrayList;

import id.dhiva.moviecatalogue.R;
import id.dhiva.moviecatalogue.model.ModelItem;

import static id.dhiva.moviecatalogue.ui.detail.DetailItemActivity.VAL_MOVIE;

public class DataHelper {
    private Application application;

    public DataHelper(Application application){
        this.application = application;
    }

    public ArrayList<ModelItem> allMovies(){

        String[] filmTitle = application.getResources().getStringArray(R.array.data_film_title);
        String[] filmRating = application.getResources().getStringArray(R.array.data_film_rating);
        TypedArray filmPoster = application.getResources().obtainTypedArray(R.array.data_film_poster);
        String[] filmGenre = application.getResources().getStringArray(R.array.data_film_genre);
        String[] filmDesc = application.getResources().getStringArray(R.array.data_film_description);
        String[] filmDate = application.getResources().getStringArray(R.array.data_film_release);

        ArrayList<ModelItem> list = new ArrayList<>();
        for (int i = 0; i < filmTitle.length; i++){
            ModelItem movie = new ModelItem();
            movie.setPoster(filmPoster.getResourceId(i, -1));
            movie.setTitle(filmTitle[i]);
            movie.setGenre(filmGenre[i]);
            movie.setDesc(filmDesc[i]);
            movie.setRating(filmRating[i]);
            movie.setDate(filmDate[i]);
            list.add(movie);
        }
        filmPoster.recycle();

        return list;
    }

    public ArrayList<ModelItem> allTvs(){
        String[] tvTitle = application.getResources().getStringArray(R.array.data_tv_show_title);
        String[] tvRating = application.getResources().getStringArray(R.array.data_tv_show_rating);
        TypedArray tvPoster = application.getResources().obtainTypedArray(R.array.data_tv_show_poster);
        String[] tvGenre = application.getResources().getStringArray(R.array.data_tv_show_genre);
        String[] tvDesc = application.getResources().getStringArray(R.array.data_tv_show_description);
        String[] tvDate = application.getResources().getStringArray(R.array.data_tv_show_release);

        ArrayList<ModelItem> list = new ArrayList<>();
        for (int i = 0; i < tvTitle.length; i++){
            ModelItem tv = new ModelItem();
            tv.setPoster(tvPoster.getResourceId(i, -1));
            tv.setTitle(tvTitle[i]);
            tv.setGenre(tvGenre[i]);
            tv.setDesc(tvDesc[i]);
            tv.setRating(tvRating[i]);
            tv.setDate(tvDate[i]);
            list.add(tv);
        }
        tvPoster.recycle();

        return list;
    }

    public ModelItem detail(int id, String from){
        ModelItem modelItem;
        if (from.equals(VAL_MOVIE)){
            modelItem = allMovies().get(id);
        }else {
            modelItem = allTvs().get(id);
        }
        return modelItem;
    }
}
