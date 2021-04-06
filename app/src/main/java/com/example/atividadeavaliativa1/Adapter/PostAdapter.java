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

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private List<Post> listaPost;

    private int layout;
    private TextView tv;
    private LayoutInflater inflator;

    public class PostViewHolder extends RecyclerView.ViewHolder {
        public View viewPost;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            this.viewPost = itemView;
        }
    }
    public PostAdapter(List<Post> posts, int layout) {
        this.listaPost = posts;
        this.layout = layout;
    }

    public PostAdapter(Context context) {
        this.inflator = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(this.layout, parent, false);
        return new PostViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        switch(this.layout){
            case(R.layout.layout_post):

                Post post = (Post) this.listaPost.get(position);

                TextView tv = holder.viewPost.findViewById(R.id.textViewPostDetalheUserID);
                tv.setText("USER ID: " + post.getUserId()+"");
                tv = holder.viewPost.findViewById(R.id.textViewPostDetalheID);
                tv.setText("ID: " + post.getId()+"");
                tv = holder.viewPost.findViewById(R.id.textViewPostDetalheTitle);
                tv.setText("TITLE: " + post.getTitle());
                tv = holder.viewPost.findViewById(R.id.textViewPostDetalheBody);
                tv.setText("BODY: " + post.getBody());
        }
    }

    @Override
    public int getItemCount() {
        try {
            return this.listaPost.size();
        } catch (Exception ex){return 0;}
    }
}