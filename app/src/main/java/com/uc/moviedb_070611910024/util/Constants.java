package com.uc.moviedb_070611910024.util;

import androidx.annotation.StringDef;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

public class Constants {
    public static final String BASE_URL = "https://api.themoviedb.org/3/";
    public static final String BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500";
    public static final String API_KEY ="2ddd99bf6d429fb798ca2cd6057c3ff2";
    @Retention(SOURCE)
    @StringDef
    public @interface Type {
        String MOVIES = "movie";
        String TV_SHOWS = "tv";
    }
}
