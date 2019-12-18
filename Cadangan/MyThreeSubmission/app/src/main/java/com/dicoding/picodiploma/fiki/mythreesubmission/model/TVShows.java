package com.dicoding.picodiploma.fiki.mythreesubmission.model;

import android.os.Parcel;
import android.os.Parcelable;

public class TVShows implements Parcelable {
    private String imageTVShow;
    private String titleTVShow;
    private String descriptionTVShow;
    private String tahunTVShow;

    public TVShows() {
    }

    public TVShows(String imageTVShow, String titleTVShow, String descriptionTVShow, String tahunTVShow) {
        this.imageTVShow = imageTVShow;
        this.titleTVShow = titleTVShow;
        this.descriptionTVShow = descriptionTVShow;
        this.tahunTVShow = tahunTVShow;
    }

    public String getImageTVShow() {
        return imageTVShow;
    }

    public void setImageTVShow(String imageTVShow) {
        this.imageTVShow = imageTVShow;
    }

    public String getTitleTVShow() {
        return titleTVShow;
    }

    public void setTitleTVShow(String titleTVShow) {
        this.titleTVShow = titleTVShow;
    }

    public String getDescriptionTVShow() {
        return descriptionTVShow;
    }

    public void setDescriptionTVShow(String descriptionTVShow) {
        this.descriptionTVShow = descriptionTVShow;
    }

    public String getTahunTVShow() {
        return tahunTVShow;
    }

    public void setTahunTVShow(String tahunTVShow) {
        this.tahunTVShow = tahunTVShow;
    }

    public static Creator<TVShows> getCREATOR() {
        return CREATOR;
    }

    protected TVShows(Parcel in) {
    }

    public static final Creator<TVShows> CREATOR = new Creator<TVShows>() {
        @Override
        public TVShows createFromParcel(Parcel in) {
            return new TVShows(in);
        }

        @Override
        public TVShows[] newArray(int size) {
            return new TVShows[size];
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
