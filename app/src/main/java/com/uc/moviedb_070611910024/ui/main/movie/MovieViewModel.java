package com.uc.moviedb_070611910024.ui.main.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.uc.moviedb_070611910024.model.Movie;
import com.uc.moviedb_070611910024.repository.MovieRepository;

import java.util.List;

public class MovieViewModel extends ViewModel {

    private MovieRepository repository;

    public MovieViewModel() {
        repository = MovieRepository.getInstance();

    }
    public LiveData<List<Movie>> getMovieCollection(){
        return repository.getMovieCollection();
    }
}
