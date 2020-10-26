package com.uc.moviedb_070611910024.network;

import com.uc.moviedb_070611910024.model.CastResponse;
import com.uc.moviedb_070611910024.model.GenreResponse;
import com.uc.moviedb_070611910024.model.MovieResponse;
import com.uc.moviedb_070611910024.model.TvShowResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiEndPoints {
    @GET("discover/movie")// get Movies Collection
    Call<MovieResponse> getMovies(@Query("api_key")String apikey);
    @GET("discover/tv")  //https://developers.themoviedb.org/3/discover/tv-discover
    Call<TvShowResponse> getTvShow(@Query("api_key")String apiKey);
    @GET("{type}/{id}") // get details and genres of specific movie / tv
    Call<GenreResponse> getGenres(@Path("type") String type, @Path("id") int id, @Query("api_key") String apiKey);
    @GET("{type}/{id}/credits") // get casts of specific movie / tv shows
    Call<CastResponse> getCasts(@Path("type") String type, @Path("id") int id, @Query("api_key") String apiKey);

//    @GET("movie/{movie_id}")
//    Call<MovieResponse>getDetailMovie(@Path("movie_id") int movieId, @Query("api_key") String apiKey);


}
