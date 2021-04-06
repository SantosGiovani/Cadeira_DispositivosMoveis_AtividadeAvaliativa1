package com.example.atividadeavaliativa1.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.atividadeavaliativa1.Model.Album;
import com.example.atividadeavaliativa1.Model.Coment;
import com.example.atividadeavaliativa1.Model.Photo;
import com.example.atividadeavaliativa1.Model.Post;
import com.example.atividadeavaliativa1.Model.Todo;
import com.example.atividadeavaliativa1.R;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder> {
    private List<Photo> listaPhoto;

    private int layout;
    private TextView tv;
    private LayoutInflater inflator;

    public class PhotoViewHolder extends RecyclerView.ViewHolder {
        public View viewPhoto;
        public PhotoViewHolder(@NonNull View itemView) {
            super(itemView);
            this.viewPhoto = itemView;
        }
    }
    public PhotoAdapter(List<Photo> photo, int layout) {
        this.listaPhoto = photo;
        this.layout = layout;
    }

    public PhotoAdapter(Context context) {
        this.inflator = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(this.layout, parent, false);
        return new PhotoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        switch(this.layout){
            case(R.layout.layout_photo):

                Photo photo = (Photo) this.listaPhoto.get(position);

                TextView tv = holder.viewPhoto.findViewById(R.id.textViewPhotoAlbumId);
                tv.setText(photo.getalbumId() + "");
                tv = holder.viewPhoto.findViewById(R.id.textViewPhotoId);
                tv.setText(photo.getId() + "");
                tv = holder.viewPhoto.findViewById(R.id.textViewPhotoTitle);
                tv.setText(photo.gettitle());
        }
    }

    @Override
    public int getItemCount() {
        try {
            return this.listaPhoto.size();
        } catch (Exception ex){return 0;}
    }
}