package com.dicoding.picodiploma.fiki.submissiondua.model;

import android.os.Parcel;
import android.os.Parcelable;

public class TvShow implements Parcelable {
    private int imageTv;
    private String titleTv;
    private String description;
    private String yearTv;

    public TvShow() {
    }

    public TvShow(int imageTv, String titleTv, String description, String yearTv) {
        this.imageTv = imageTv;
        this.titleTv = titleTv;
        this.description = description;
        this.yearTv = yearTv;
    }


    protected TvShow(Parcel in) {
        imageTv = in.readInt();
        titleTv = in.readString();
        description = in.readString();
        yearTv = in.readString();
    }

    public static final Creator<TvShow> CREATOR = new Creator<TvShow>() {
        @Override
        public TvShow createFromParcel(Parcel in) {
            return new TvShow(in);
        }

        @Override
        public TvShow[] newArray(int size) {
            return new TvShow[size];
        }
    };

    public int getImageTv() {
        return imageTv;
    }

    public void setImageTv(int imageTv) {
        this.imageTv = imageTv;
    }

    public String getTitleTv() {
        return titleTv;
    }

    public void setTitleTv(String titleTv) {
        this.titleTv = titleTv;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYearTv() {
        return yearTv;
    }

    public void setYearTv(String yearTv) {
        this.yearTv = yearTv;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imageTv);
        dest.writeString(titleTv);
        dest.writeString(description);
        dest.writeString(yearTv);
    }
}