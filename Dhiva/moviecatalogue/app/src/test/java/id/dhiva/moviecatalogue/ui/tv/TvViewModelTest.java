package id.dhiva.moviecatalogue.ui.tv;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import java.util.ArrayList;
import java.util.Objects;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import id.dhiva.moviecatalogue.R;
import id.dhiva.moviecatalogue.data.DataRepository;
import id.dhiva.moviecatalogue.model.ModelItem;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TvViewModelTest {
    private DataRepository dataRepository = mock(DataRepository.class);
    private TvViewModel tvViewModel;

    @Before
    public void init(){
        tvViewModel = new TvViewModel(dataRepository);
    }

    @Rule
    public TestRule rule = new InstantTaskExecutorRule();

    @Test
    public void getTvs() {
        ArrayList<ModelItem> list = new ArrayList<>();
        ModelItem modelItem = new ModelItem();
        modelItem.setTitle("Naruto");
        modelItem.setDate("25 September 1999");
        modelItem.setDesc("deskripsi");
        modelItem.setGenre("Adventure");
        modelItem.setRating("7.9");
        modelItem.setPoster(R.drawable.poster_a_star);
        list.add(modelItem);

        when(dataRepository.getAllTv()).thenReturn(list);

        Observer<ArrayList<ModelItem>> observer = mock(Observer.class);
        tvViewModel.getAllTvList().observeForever(observer);
        verify(observer).onChanged(list);
    }
}