package id.dhiva.moviecatalogue.ui.movie;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import java.util.ArrayList;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;
import id.dhiva.moviecatalogue.R;
import id.dhiva.moviecatalogue.data.DataRepository;
import id.dhiva.moviecatalogue.model.ModelItem;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MovieViewModelTest {
    private MovieViewModel movieViewModel;
    private DataRepository dataRepository = mock(DataRepository.class);

    @Before
    public void setUp(){
        movieViewModel = new MovieViewModel(dataRepository);
    }

    @Rule
    public TestRule rule = new InstantTaskExecutorRule();

    @Test
    public void getMovies() {
        ArrayList<ModelItem> list = new ArrayList<>();
        ModelItem modelItem = new ModelItem();
        modelItem.setTitle("A Star");
        modelItem.setDate("25 Oktobr 2018");
        modelItem.setDesc("deskripsi");
        modelItem.setGenre("romance");
        modelItem.setRating("8");
        modelItem.setPoster(R.drawable.poster_a_star);
        list.add(modelItem);

        when(dataRepository.getAllMovies()).thenReturn(list);

        Observer<ArrayList<ModelItem>> observer = mock(Observer.class);
        movieViewModel.getAllMovieList().observeForever(observer);
        verify(observer).onChanged(list);
    }
}