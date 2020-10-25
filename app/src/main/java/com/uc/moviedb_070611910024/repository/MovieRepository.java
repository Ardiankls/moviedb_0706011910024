package com.uc.moviedb_070611910024.repository;

import android.nfc.Tag;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.uc.moviedb_070611910024.model.Movie;
import com.uc.moviedb_070611910024.model.MovieResponse;
import com.uc.moviedb_070611910024.network.ApiEndPoints;
import com.uc.moviedb_070611910024.network.RetrofitService;
import com.uc.moviedb_070611910024.util.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {
    private static MovieRepository movieRepository;
    private RetrofitService service;
//    private ApiEndPoints apiEndPoints;
    private static final String TAG = "MovieRepository";

    private MovieRepository() {
        service = RetrofitService.getInstance();
    }

    public static MovieRepository getInstance(){
        if (movieRepository == null) {
            movieRepository = new MovieRepository();
        }
        return movieRepository;
    }
    public MutableLiveData<List<Movie>> getMovieCollection() {
        MutableLiveData <List<Movie>> listMovie = new MutableLiveData<>();

        service.getMovies().enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()){
                    if (response.body() != null){
                        listMovie.postValue((response.body().getResults()));
                    }
                }

            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.d(TAG, "OnFailure" + t.getMessage());
            }
        });


        return listMovie;
    }
}
