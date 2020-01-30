package id.dhiva.moviecatalogue.ui.favorite.favtv;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import id.dhiva.moviecatalogue.R;
import id.dhiva.moviecatalogue.database.TvEntity;
import id.dhiva.moviecatalogue.ui.tv.AdapterTV;

public class TvPagedListAdapter extends PagedListAdapter<TvEntity, TvPagedListAdapter.TvViewHolder> {
    private AdapterTV.OnItemClickCallback onItemClickCallback;
    
    TvPagedListAdapter() {
        super(DIFF_CALLBACK);
    }

    void setOnItemClickCallback(AdapterTV.OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }

    private static DiffUtil.ItemCallback<TvEntity> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<TvEntity>() {
                @Override
                public boolean areItemsTheSame(TvEntity oldTv, TvEntity newTv) {
                    return oldTv.getTitle().equals(newTv.getTitle());
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(TvEntity oldNote, @NonNull TvEntity newNote) {
                    return oldNote.equals(newNote);
                }
            };

    @NonNull
    @Override
    public TvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv, parent, false);
        return new TvViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TvViewHolder holder, int position) {
        holder.bind(Objects.requireNonNull(getItem(position)));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(holder.getAdapterPosition());
            }
        });
    }

    class TvViewHolder extends RecyclerView.ViewHolder {
        ImageView poster;
        TextView title, date, desc, rating;

        TvViewHolder(@NonNull View itemView) {
            super(itemView);

            poster = itemView.findViewById(R.id.poster_movie);
            title = itemView.findViewById(R.id.title);
            date = itemView.findViewById(R.id.date);
            desc = itemView.findViewById(R.id.movie_desc);
            rating = itemView.findViewById(R.id.movie_rating);
        }
        void bind(TvEntity dataFilm){
            Glide.with(poster.getContext()).load(dataFilm.getPoster()).into(poster);
            title.setText(dataFilm.getTitle());
            date.setText(dataFilm.getDate());
            desc.setText(dataFilm.getDesc());
            rating.setText(dataFilm.getRating());
        }
    }
}
