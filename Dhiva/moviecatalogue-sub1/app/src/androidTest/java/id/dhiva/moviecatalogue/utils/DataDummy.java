package id.dhiva.moviecatalogue.utils;

import id.dhiva.moviecatalogue.R;
import id.dhiva.moviecatalogue.model.ModelItem;

public class DataDummy {
    public ModelItem data(){
        ModelItem modelItem = new ModelItem();
        modelItem.setTitle("A Star");
        modelItem.setDate("25 Oktobe 2018");
        modelItem.setDesc("deskripsi");
        modelItem.setGenre("romance");
        modelItem.setRating("8");
        modelItem.setPoster(R.drawable.poster_a_star);
        return modelItem;
    }
}
