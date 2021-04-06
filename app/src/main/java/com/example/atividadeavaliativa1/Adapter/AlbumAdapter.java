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

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {
    private List<Album> listaAlbum;

    private int layout;
    private TextView tv;
    private LayoutInflater inflator;

    public class AlbumViewHolder extends RecyclerView.ViewHolder {
        public View viewAlbum;
        public AlbumViewHolder(@NonNull View itemView) {
            super(itemView);
            this.viewAlbum = itemView;
        }
    }
    public AlbumAdapter(List<Album> albums, int layout) {
        this.listaAlbum = albums;
        this.layout = layout;
    }

    public AlbumAdapter(Context context) {
        this.inflator = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(this.layout, parent, false);
        return new AlbumViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        switch(this.layout){
            case(R.layout.layout_album):

                Album album = (Album) this.listaAlbum.get(position);
                tv = holder.viewAlbum.findViewById(R.id.textViewAlbumDetalheUserID);
                tv.setText("USER ID: " + album.getUserId()+"");
                tv = holder.viewAlbum.findViewById(R.id.textViewAlbumDetalheID);
                tv.setText("ID: " + album.getId()+"");
                tv = holder.viewAlbum.findViewById(R.id.textViewAlbumDetalheTitle);
                tv.setText("TITLE: " + album.getTitle());
        }
    }

    @Override
    public int getItemCount() {
        try {
            return this.listaAlbum.size();
        } catch (Exception ex){return 0;}
    }
}