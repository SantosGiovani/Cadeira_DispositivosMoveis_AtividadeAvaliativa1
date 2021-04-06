package com.example.atividadeavaliativa1.Model;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

public class Coment implements Parcelable {
    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;

    public Coment(int postId, int id, String name, String email, String body){
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    private Coment(Parcel parcel) {
        this.postId = parcel.readInt();
        this.id = parcel.readInt();
        this.name = parcel.readString();
        this.email = parcel.readString();
        this.body = parcel.readString();
    }

    public static final Parcelable.Creator<Coment> CREATOR = new Parcelable.Creator<Coment>() {
        @RequiresApi(api = Build.VERSION_CODES.Q)
        @Override
        public Coment createFromParcel(Parcel in) {
            return new Coment(in);
        }

        @Override
        public Coment[] newArray(int size) {
            return new Coment[size];
        }
    };

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.postId);
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeString(this.email);
        dest.writeString(this.body);
    }
}