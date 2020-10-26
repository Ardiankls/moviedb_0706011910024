package com.uc.moviedb_070611910024.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.uc.moviedb_070611910024.R;
import com.uc.moviedb_070611910024.model.Movie;
import com.uc.moviedb_070611910024.ui.main.movie.MovieFragmentDirections;
import com.uc.moviedb_070611910024.util.Constants;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.CardViewViewHolder> {
    private final Context context;
    private List<Movie> listMovie;
    private List<Movie> getListMovie() {
        return listMovie;
    }
    public void setListMovie(List<Movie> listMovie) {

        this.listMovie = listMovie;
    }
    public MovieAdapter(Context context) {
        this.listMovie = new ArrayList<Movie>();
        this.context = context;
    }

    @NonNull
    @Override
    public MovieAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        return new MovieAdapter.CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieAdapter.CardViewViewHolder holder, int position) {
        Movie movie = getListMovie().get(position);
        Glide.with(context)
                .load(Constants.BASE_IMAGE_URL + movie.getCover())
                .into(holder.img);
        holder.lbl_title.setText(movie.getTitle());
        holder.lbl_date.setText(movie.getReleaseDate());
        holder.lbl_vote.setText(movie.getVote());
        holder.itemView.setOnClickListener(view -> {
            MovieFragmentDirections.ActionMovieToDetail action = MovieFragmentDirections.actionMovieToDetail(movie, null);
            Navigation.findNavController(view).navigate(action);
        });
        Log.d("Movie",""+movie.getPoster());
    }

    @Override
    public int getItemCount() {
        return getListMovie().size();
    }
    class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView lbl_title, lbl_date, lbl_vote;

        CardViewViewHolder(View itemView) {
            super(itemView);
            lbl_title = itemView.findViewById(R.id.lbl_title);
            lbl_date = itemView.findViewById(R.id.lbl_date);
            lbl_vote = itemView.findViewById(R.id.txt_vote);
            img = itemView.findViewById(R.id.img_detail_poster);
        }
    }
}
