package id.dhiva.moviecatalogue.ui.detail;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;
import id.dhiva.moviecatalogue.R;
import id.dhiva.moviecatalogue.data.DataRepository;
import id.dhiva.moviecatalogue.model.ModelItem;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DetailViewModelTest {
    private DataRepository dataRepository = mock(DataRepository.class);
    private DetailViewModel detailViewModel;

    @Before
    public void init(){
        detailViewModel = new DetailViewModel(dataRepository);
    }

    @Rule
    public TestRule rule = new InstantTaskExecutorRule();

    @Test
    public void getDetail() {
        int id = 0;
        String from = "movie";
        ModelItem modelItem = new ModelItem();
        modelItem.setTitle("A Star");
        modelItem.setDate("25 Oktobr 2018");
        modelItem.setDesc("deskripsi");
        modelItem.setGenre("romance");
        modelItem.setRating("8");
        modelItem.setPoster(R.drawable.poster_a_star);

        detailViewModel.setId(id);
        detailViewModel.setFrom(from);
        when(dataRepository.getDetail(id, from)).thenReturn(modelItem);

        Observer<ModelItem> observer = mock(Observer.class);
        detailViewModel.getItemDetail().observeForever(observer);
        verify(observer).onChanged(modelItem);
    }

}