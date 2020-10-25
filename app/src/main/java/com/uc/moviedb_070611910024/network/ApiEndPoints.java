package com.uc.moviedb_070611910024.network;

import com.uc.moviedb_070611910024.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiEndPoints {
    @GET("discover/movie")// get Movies Collection
    Call<MovieResponse> getMovies(@Query("api_key")String apikey);

//    @GET("movie/{movie_id}")
//    Call<MovieResponse>getDetailMovie(@Path("movie_id") int movieId, @Query("api_key") String apiKey);


}
