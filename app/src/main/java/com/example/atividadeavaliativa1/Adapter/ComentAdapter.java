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

public class ComentAdapter extends RecyclerView.Adapter<ComentAdapter.ComentViewHolder> {
    private List<Coment> listaComent;

    private int layout;
    private TextView tv;
    private LayoutInflater inflator;

    public class ComentViewHolder extends RecyclerView.ViewHolder {
        public View viewComent;
        public ComentViewHolder(@NonNull View itemView) {
            super(itemView);
            this.viewComent = itemView;
        }
    }
    public ComentAdapter(List<Coment> coments, int layout) {
        this.listaComent = coments;
        this.layout = layout;
    }

    public ComentAdapter(Context context) {
        this.inflator = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ComentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(this.layout, parent, false);
        return new ComentViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ComentViewHolder holder, int position) {
        switch(this.layout){
            case (R.layout.layout_coment):
                Coment coment = (Coment) this.listaComent.get(position);

                TextView tv = holder.viewComent.findViewById(R.id.textViewComentDetalhePostID);
                tv.setText("POST ID: " + coment.getPostId()+"");
                tv = holder.viewComent.findViewById(R.id.textViewComentDetalheID);
                tv.setText("ID: " + coment.getId()+"");
                tv = holder.viewComent.findViewById(R.id.textViewComentDetalheTitle);
                tv.setText("TITLE: " + coment.getName());
                tv = holder.viewComent.findViewById(R.id.textViewComentDetalheBody);
                tv.setText("BODY: " + coment.getBody());

                break;
        }
    }

    @Override
    public int getItemCount() {
        try {
            return this.listaComent.size();
        } catch (Exception ex){return 0;}
    }
}