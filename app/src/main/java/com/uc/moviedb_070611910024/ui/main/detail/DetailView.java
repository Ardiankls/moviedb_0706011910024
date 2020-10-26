package com.uc.moviedb_070611910024.ui.main.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.uc.moviedb_070611910024.model.Cast;
import com.uc.moviedb_070611910024.model.Genre;
import com.uc.moviedb_070611910024.repository.MovieRepository;
import com.uc.moviedb_070611910024.repository.TvShowRepository;

import java.util.List;

public class DetailView extends ViewModel {
    private MovieRepository mvrepo;
    private TvShowRepository tvShowrepo;
    public DetailView() {
        mvrepo = MovieRepository.getInstance();
        tvShowrepo = TvShowRepository.getInstance();
    }
    public LiveData<List<Genre>> getMovieGenre(int id) {
        return mvrepo.getGenres(id);
    }

    public LiveData<List<Genre>> getTvShowGenre(int id) {
        return tvShowrepo.getGenres(id);
    }

    public LiveData<List<Cast>> getShowCast(int id) {
        return tvShowrepo.getCasts(id);
    }

    public LiveData<List<Cast>> getMovieCast(int id) {
        return mvrepo.getCasts(id);
    }
}
