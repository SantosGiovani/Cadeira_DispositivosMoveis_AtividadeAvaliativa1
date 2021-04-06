package com.example.atividadeavaliativa1.Model;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

public class Photo implements Parcelable {
    private int albumId;
    private int id;
    private String title;
    private String url;
    private String thumbnailUrl;

    public Photo(int albumId, int id, String title, String url, String thumbnailUrl){
        this.albumId = albumId;
        this.id = id;
        this.title = title;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    private Photo(Parcel parcel) {
        this.albumId = parcel.readInt();
        this.id = parcel.readInt();
        this.title = parcel.readString();
        this.url = parcel.readString();
        this.thumbnailUrl = parcel.readString();
    }

    public static final Parcelable.Creator<Photo> CREATOR = new Parcelable.Creator<Photo>() {
        @RequiresApi(api = Build.VERSION_CODES.Q)
        @Override
        public Photo createFromParcel(Parcel in) {
            return new Photo(in);
        }

        @Override
        public Photo[] newArray(int size) {
            return new Photo[size];
        }
    };

    public int getalbumId() {
        return albumId;
    }

    public void setalbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String gettitle() {
        return title;
    }

    public void settitle(String title) {
        this.title = title;
    }

    public String geturl() {
        return url;
    }

    public void seturl(String url) {
        this.url = url;
    }

    public String getthumbnailUrl() {
        return thumbnailUrl;
    }

    public void setthumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.albumId);
        dest.writeInt(this.id);
        dest.writeString(this.title);
        dest.writeString(this.url);
        dest.writeString(this.thumbnailUrl);
    }
}