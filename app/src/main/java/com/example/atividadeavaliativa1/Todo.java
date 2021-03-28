package com.example.atividadeavaliativa1;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

public class Todo implements Parcelable {
    private int userId;
    private int id;
    private String title;
    private boolean completed;

    public Todo(int userId, int id, String title, boolean completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    private Todo(Parcel parcel) {
        this.userId = parcel.readInt();
        this.id = parcel.readInt();
        this.title = parcel.readString();
        this.completed = parcel.readBoolean();
    }

    public static final Parcelable.Creator<Todo> CREATOR = new Parcelable.Creator<Todo>() {
        @RequiresApi(api = Build.VERSION_CODES.Q)
        @Override
        public Todo createFromParcel(Parcel in) {
            return new Todo(in);
        }

        @Override
        public Todo[] newArray(int size) {
            return new Todo[size];
        }
    };

    public int getUserId() {
        return userId;
    }

    public void setUser (int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.userId);
        dest.writeInt(this.id);
        dest.writeString(this.title);
        dest.writeBoolean(this.completed);
    }


}
