package id.dhiva.moviecatalogue.ui.detail;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import id.dhiva.moviecatalogue.R;
import id.dhiva.moviecatalogue.model.ModelItem;

import static org.junit.Assert.*;

public class DetailViewModelTest {
    private DetailViewModel detailViewModel;

    @Before
    public void init(){
        detailViewModel = new DetailViewModel();
    }

    @Rule
    public TestRule rule = new InstantTaskExecutorRule();

    @Test
    public void setDetail() {
        ModelItem modelItem = new ModelItem();
        modelItem.setTitle("A Star");
        modelItem.setDate("25 Oktobr 2018");
        modelItem.setDesc("deskripsi");
        modelItem.setGenre("romance");
        modelItem.setRating("8");
        modelItem.setPoster(R.drawable.poster_a_star);
        detailViewModel.setDetail(modelItem);
        assertEquals(modelItem, detailViewModel.itemDetail.getValue());
    }

}