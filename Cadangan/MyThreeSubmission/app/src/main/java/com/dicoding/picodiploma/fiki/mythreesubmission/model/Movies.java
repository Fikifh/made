package com.dicoding.picodiploma.fiki.mythreesubmission.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Movies implements Parcelable {
    public Movies() {
    }

    public Movies(String imageMovie, String titleMovie, String description, String tahun) {
        this.imageMovie = imageMovie;
        this.titleMovie = titleMovie;
        this.description = description;
        this.tahun = tahun;
    }

    private String imageMovie;
    private String titleMovie;
    private String description;
    private String tahun;

    public String getImageMovie() {
        return imageMovie;
    }

    public void setImageMovie(String imageMovie) {
        this.imageMovie = imageMovie;
    }

    public String getTitleMovie() {
        return titleMovie;
    }

    public void setTitleMovie(String titleMovie) {
        this.titleMovie = titleMovie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public static Creator<Movies> getCREATOR() {
        return CREATOR;
    }

    protected Movies(Parcel in) {
    }

    public static final Creator<Movies> CREATOR = new Creator<Movies>() {
        @Override
        public Movies createFromParcel(Parcel in) {
            return new Movies(in);
        }

        @Override
        public Movies[] newArray(int size) {
            return new Movies[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
