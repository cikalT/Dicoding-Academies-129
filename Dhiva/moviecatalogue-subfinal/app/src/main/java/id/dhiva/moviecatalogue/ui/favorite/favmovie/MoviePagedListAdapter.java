package id.dhiva.moviecatalogue.ui.favorite.favmovie;

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
import id.dhiva.moviecatalogue.database.MovieEntity;
import id.dhiva.moviecatalogue.ui.movie.AdapterMovie;

    public class MoviePagedListAdapter extends PagedListAdapter<MovieEntity, MoviePagedListAdapter.MovieViewHolder> {
    private AdapterMovie.OnItemClickCallback onItemClickCallback;

    MoviePagedListAdapter() {
        super(DIFF_CALLBACK);
    }

    void setOnItemClickCallback(AdapterMovie.OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }


    private static DiffUtil.ItemCallback<MovieEntity> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<MovieEntity>() {
                @Override
                public boolean areItemsTheSame(MovieEntity oldMovie, MovieEntity newMovie) {
                    return oldMovie.getTitle().equals(newMovie.getTitle());
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(MovieEntity oldNote, @NonNull MovieEntity newNote) {
                    return oldNote.equals(newNote);
                }
            };


    @NonNull
    @Override
    public MoviePagedListAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MoviePagedListAdapter.MovieViewHolder holder, int position) {
        holder.bind(Objects.requireNonNull(getItem(position)));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(holder.getAdapterPosition());
            }
        });
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView poster;
        TextView title, date, desc, rating;
        MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            poster = itemView.findViewById(R.id.poster_movie);
            title = itemView.findViewById(R.id.title);
            date = itemView.findViewById(R.id.date);
            desc = itemView.findViewById(R.id.movie_desc);
            rating = itemView.findViewById(R.id.movie_rating);
        }

        void bind(MovieEntity dataFilm){
            Glide.with(poster.getContext()).load(dataFilm.getPoster()).into(poster);
            title.setText(dataFilm.getTitle());
            date.setText(dataFilm.getDate());
            desc.setText(dataFilm.getDesc());
            rating.setText(dataFilm.getRating());
        }
    }

}
