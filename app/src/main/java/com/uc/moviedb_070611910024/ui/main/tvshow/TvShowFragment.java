package com.uc.moviedb_070611910024.ui.main.tvshow;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.uc.moviedb_070611910024.R;
import com.uc.moviedb_070611910024.adapter.MovieAdapter;
import com.uc.moviedb_070611910024.adapter.TvShowAdapter;
import com.uc.moviedb_070611910024.model.Movie;
import com.uc.moviedb_070611910024.model.TvShow;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class TvShowFragment extends Fragment {

    @BindView(R.id.rv_tvshow)
    RecyclerView recyclerView;

    private  TvshowViewModel viewModel;
    private TvShowAdapter adapter;
    public TvShowFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        adapter = new TvShowAdapter(getContext());

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        viewModel = ViewModelProviders.of(getActivity()).get(TvshowViewModel.class);
        viewModel.getTvShowCollection().observe(requireActivity(), observerViewModel);


//        TvShow tvShow = new TvShow();
    }
    private final Observer<List<TvShow>> observerViewModel = tvShows -> {{
        if (tvShows != null){
            TvShow tvshows = tvShows.get(0);
//            Toast.makeText(getContext(), tvshows.getTitle(), Toast.LENGTH_SHORT).show();
                adapter.setListTvShow(tvShows);
                adapter.notifyDataSetChanged();
//                recyclerView.setAdapter(adapter);
    }

    }
};
}