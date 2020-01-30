package id.dhiva.moviecatalogue.ui.detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import id.dhiva.moviecatalogue.R;
import id.dhiva.moviecatalogue.model.ModelItem;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Objects;

public class DetailItemActivity extends AppCompatActivity {
    public static String EXTRA_DETAIL = "extra";
    private TextView title, date, genre, rating, desc;
    private ImageView bgPoster, poster;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_item);
        init();
        transparentStatusBar();
        DetailViewModel detailViewModel = ViewModelProviders.of(this).get(DetailViewModel.class);

        ModelItem item = getIntent().getParcelableExtra(EXTRA_DETAIL);
        detailViewModel.setDetail(item);
        detailViewModel.getItemDetail().observe(this, getItemDetail);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    private void init(){
        title = findViewById(R.id.title);
        date = findViewById(R.id.date);
        genre = findViewById(R.id.genre);
        rating = findViewById(R.id.rating);
        desc = findViewById(R.id.desc);
        bgPoster = findViewById(R.id.bg_poster);
        poster = findViewById(R.id.poster_movie);
    }

    private Observer<ModelItem>getItemDetail = new Observer<ModelItem>() {
        @Override
        public void onChanged(ModelItem modelItem) {
            if (modelItem!=null){
                title.setText(modelItem.getTitle());
                date.setText(modelItem.getDate());
                genre.setText(modelItem.getGenre());
                rating.setText(modelItem.getRating());
                desc.setText(modelItem.getDesc());
                Glide.with(poster.getContext()).load(modelItem.getPoster()).into(bgPoster);
                Glide.with(poster.getContext()).load(modelItem.getPoster()).into(poster);
            }
        }
    };

    private void transparentStatusBar(){
        Toolbar toolbar = findViewById(R.id.toolbar);

        toolbar.setBackgroundColor(Color.TRANSPARENT);

        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Window window = this.getWindow();

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }

    }
}
