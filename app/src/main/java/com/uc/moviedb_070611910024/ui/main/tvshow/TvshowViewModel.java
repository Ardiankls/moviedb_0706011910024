package com.uc.moviedb_070611910024.ui.main.tvshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.uc.moviedb_070611910024.R;
import com.uc.moviedb_070611910024.model.Movie;
import com.uc.moviedb_070611910024.model.TvShow;
import com.uc.moviedb_070611910024.repository.TvShowRepository;

import java.util.List;

import butterknife.BindView;

public class TvshowViewModel extends ViewModel {
private TvShowRepository repository;
public TvshowViewModel(){
    repository = TvShowRepository.getInstance();
}
public LiveData<List<TvShow>>getTvShowCollection(){
    return repository.getTvCollection();
}
//public LiveData<List<TvShow>>
//    private TvShowAdpter adapter;
}
