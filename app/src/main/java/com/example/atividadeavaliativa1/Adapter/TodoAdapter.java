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

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {
    private List<Todo> listaTodos;

    private int layout;
    private TextView tv;
    private LayoutInflater inflator;

    public class TodoViewHolder extends RecyclerView.ViewHolder {
        public View viewTodo;
        public TodoViewHolder(@NonNull View itemView) {
            super(itemView);
            this.viewTodo = itemView;
        }
    }
    public TodoAdapter(List<Todo> todos, int layout) {
        this.listaTodos = todos;
        this.layout = layout;
    }

    public TodoAdapter(Context context) {
        this.inflator = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(this.layout, parent, false);
        return new TodoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        switch(this.layout){
            case (R.layout.layout_todo):
                Todo todo = (Todo) this.listaTodos.get(position);

                tv = holder.viewTodo.findViewById(R.id.textViewTodoDetalheUserID);
                tv.setText(todo.getUserId()+"");

                tv = holder.viewTodo.findViewById(R.id.textViewTodoDetalheID);
                tv.setText(todo.getId()+"");

                tv = holder.viewTodo.findViewById(R.id.textViewTodoDetalheTitle);
                tv.setText(todo.getTitle());

                CheckBox cb = holder.viewTodo.findViewById(R.id.CheckBoxTodoDetalheCompleted);
                cb.setChecked(todo.isCompleted());
                break;
        }
    }

    @Override
    public int getItemCount() {
        try {
            return this.listaTodos.size();
        } catch (Exception ex){return 0;}
    }
}