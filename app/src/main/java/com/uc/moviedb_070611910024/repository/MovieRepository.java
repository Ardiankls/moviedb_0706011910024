package com.uc.moviedb_070611910024.repository;

import android.nfc.Tag;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.uc.moviedb_070611910024.model.Cast;
import com.uc.moviedb_070611910024.model.CastResponse;
import com.uc.moviedb_070611910024.model.Genre;
import com.uc.moviedb_070611910024.model.GenreResponse;
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
    public MutableLiveData<List<Genre>> getGenres(int id) {
        MutableLiveData<List<Genre>> listGenres = new MutableLiveData<>();

        service.getGenres(Constants.Type.MOVIES, id).enqueue(new Callback<GenreResponse>() {
            @Override
            public void onResponse(Call<GenreResponse> call, Response<GenreResponse> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()) {
                    if (response.body() != null) {
//                        Log.d(TAG, "onResponse: " + response.body().getGenre().size());
                        listGenres.postValue(response.body().getGenre());
                    }
                }
            }

            @Override
            public void onFailure(Call<GenreResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });

        return listGenres;
    }
    public MutableLiveData<List<Cast>> getCasts(int id) {
        MutableLiveData<List<Cast>> listCasts = new MutableLiveData<>();

        service.getCasts(Constants.Type.MOVIES, id).enqueue(new Callback<CastResponse>() {
            @Override
            public void onResponse(Call<CastResponse> call, Response<CastResponse> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.d(TAG, "onResponse: " + response.body().getCast().size());
                        listCasts.postValue(response.body().getCast());
                    }
                }
            }

            @Override
            public void onFailure(Call<CastResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });

        return listCasts;
    }

}
