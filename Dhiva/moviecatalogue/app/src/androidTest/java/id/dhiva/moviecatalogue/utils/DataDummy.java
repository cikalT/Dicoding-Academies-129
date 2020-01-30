package id.dhiva.moviecatalogue.utils;

import id.dhiva.moviecatalogue.R;
import id.dhiva.moviecatalogue.model.ModelItem;

public class DataDummy {
    public ModelItem data(){
        ModelItem modelItem = new ModelItem();
        modelItem.setTitle("A Star is Born");
        modelItem.setDate("October 3, 2018");
        modelItem.setDesc("Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.");
        modelItem.setGenre("Drama, Romance, Music");
        modelItem.setRating("75");
        modelItem.setPoster(R.drawable.poster_a_star);

        return modelItem;
    }
}
