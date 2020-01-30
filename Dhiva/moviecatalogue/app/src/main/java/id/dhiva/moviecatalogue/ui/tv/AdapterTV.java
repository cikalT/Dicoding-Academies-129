package id.dhiva.moviecatalogue.ui.tv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import id.dhiva.moviecatalogue.R;
import id.dhiva.moviecatalogue.model.ModelItem;

public class AdapterTV extends RecyclerView.Adapter<AdapterTV.ViewHolder>{
    private ArrayList<ModelItem> dataFilm = new ArrayList<>();
    private OnItemClickCallback onItemClickCallback;

    public void setData(ArrayList<ModelItem> items) {
        dataFilm.clear();
        dataFilm.addAll(items);
        notifyDataSetChanged();
    }

    void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public AdapterTV.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterTV.ViewHolder holder, int position) {
       holder.bind(dataFilm.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataFilm.size();
    }

    public interface OnItemClickCallback{
        void onItemClicked(int position);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView poster;
        TextView title, date, desc, rating;
        ViewHolder(View itemView) {
            super(itemView);

            poster = itemView.findViewById(R.id.poster_movie);
            title = itemView.findViewById(R.id.title);
            date = itemView.findViewById(R.id.date);
            desc = itemView.findViewById(R.id.movie_desc);
            rating = itemView.findViewById(R.id.movie_rating);
        }

        void bind(ModelItem dataFilm){
            Glide.with(poster.getContext()).load(dataFilm.getPoster()).into(poster);
            title.setText(dataFilm.getTitle());
            date.setText(dataFilm.getDate());
            desc.setText(dataFilm.getDesc());
            rating.setText(dataFilm.getRating());
        }
    }
}
