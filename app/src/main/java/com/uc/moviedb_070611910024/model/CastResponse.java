package com.uc.moviedb_070611910024.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CastResponse {
    @SerializedName("cast")
    private List<Cast> cast;

    public  List<Cast> getCast() {return cast;}
    public void setCast(List<Cast> cast) {
        this.cast = cast;
    }
}
