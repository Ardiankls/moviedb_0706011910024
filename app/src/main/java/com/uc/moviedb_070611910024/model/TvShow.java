package com.uc.moviedb_070611910024.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class TvShow implements Parcelable {
    @SerializedName("id")
    private  String id_tvshow;

    @SerializedName("popularity")
    private String popularity;

    @SerializedName("poster_path")
    private String poster;

    @SerializedName("backdrop_path")
    private String cover;

    @SerializedName("name")
    private String title;

    @SerializedName("overview")
    private String description;

    @SerializedName("first_air_date")
    private String releaseDate;

    @SerializedName("vote_average")
    private String vote;

    public TvShow() {

    }

    public TvShow(String id_tvshow, String popularity, String poster, String cover, String title, String description, String releaseDate, String vote) {
        this.id_tvshow = id_tvshow;
        this.popularity = popularity;
        this.poster = poster;
        this.cover = cover;
        this.title = title;
        this.description = description;
        this.releaseDate = releaseDate;
        this.vote = vote;
    }

    public String getId_tvshow() {
        return id_tvshow;
    }

    public void setId_tvshow(String id_tvshow) {
        this.id_tvshow = id_tvshow;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id_tvshow);
        dest.writeString(this.popularity);
        dest.writeString(this.poster);
        dest.writeString(this.cover);
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeString(this.releaseDate);
        dest.writeString(this.vote);
    }

    protected TvShow(Parcel in) {
        this.id_tvshow = in.readString();
        this.popularity = in.readString();
        this.poster = in.readString();
        this.cover = in.readString();
        this.title = in.readString();
        this.description = in.readString();
        this.releaseDate = in.readString();
        this.vote = in.readString();
    }

    public static final Parcelable.Creator<TvShow> CREATOR = new Parcelable.Creator<TvShow>() {
        @Override
        public TvShow createFromParcel(Parcel source) {
            return new TvShow(source);
        }

        @Override
        public TvShow[] newArray(int size) {
            return new TvShow[size];
        }
    };
}
