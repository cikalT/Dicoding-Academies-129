package id.dhiva.moviecatalogue.ui.movie;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import java.util.ArrayList;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import id.dhiva.moviecatalogue.R;
import id.dhiva.moviecatalogue.model.ModelItem;

import static junit.framework.TestCase.assertEquals;

public class MovieViewModelTest {
    private MovieViewModel movieViewModel;

    @Before
    public void init(){
        movieViewModel = new MovieViewModel();
    }

    @Rule
    public TestRule rule = new InstantTaskExecutorRule();

    @Test
    public void setAllMovieList() {
        ArrayList<ModelItem> list = new ArrayList<>();
        ModelItem modelItem = new ModelItem();
        modelItem.setTitle("A Star");
        modelItem.setDate("25 Oktobr 2018");
        modelItem.setDesc("deskripsi");
        modelItem.setGenre("romance");
        modelItem.setRating("8");
        modelItem.setPoster(R.drawable.poster_a_star);
        list.add(modelItem);
        movieViewModel.setAllMovieList(list);
        assertEquals(list, movieViewModel.alllMovieList.getValue());
    }
}