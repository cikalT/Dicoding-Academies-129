package id.dhiva.moviecatalogue.ui.tv;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import java.util.ArrayList;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import id.dhiva.moviecatalogue.R;
import id.dhiva.moviecatalogue.model.ModelItem;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class TvViewModelTest {
    TvViewModel tvViewModel;

    @Before
    public void init(){
        tvViewModel = new TvViewModel();
    }

    @Rule
    public TestRule rule = new InstantTaskExecutorRule();

    @Test
    public void setAllTvList() {
        ArrayList<ModelItem> list = new ArrayList<>();
        ModelItem modelItem = new ModelItem();
        modelItem.setTitle("Naruto");
        modelItem.setDate("25 September 1999");
        modelItem.setDesc("deskripsi");
        modelItem.setGenre("Adventure");
        modelItem.setRating("7.9");
        modelItem.setPoster(R.drawable.poster_a_star);
        list.add(modelItem);
        tvViewModel.setAllTvList(list);
        assertEquals(list, tvViewModel.allTvList.getValue());
    }
}