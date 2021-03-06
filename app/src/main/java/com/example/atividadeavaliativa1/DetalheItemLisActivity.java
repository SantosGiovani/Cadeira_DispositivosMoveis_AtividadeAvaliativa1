package com.example.atividadeavaliativa1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.atividadeavaliativa1.Model.Album;
import com.example.atividadeavaliativa1.Model.Coment;
import com.example.atividadeavaliativa1.Model.Photo;
import com.example.atividadeavaliativa1.Model.Post;
import com.example.atividadeavaliativa1.Model.Todo;

import java.io.InputStream;

public class DetalheItemLisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_item_lis);

        Intent intent = getIntent();

        Parcelable objeto = intent.getParcelableExtra("obj");
        
        if (objeto instanceof Todo) {
            CarregaItemTodo((Todo) objeto);
        }else if(objeto instanceof Post) {
            CarregaItemPost((Post) objeto);
        }else if(objeto instanceof Coment) {
            CarregaItemComent((Coment) objeto);
        }else if(objeto instanceof Album) {
            CarregaItemAlbum((Album) objeto);
        }else if(objeto instanceof Photo) {
            CarregaItemPhoto((Photo) objeto);
        }else{
            throw new IllegalStateException("Não foi possível exibir o item.");
        }
    }

    public void CarregaItemTodo(Todo todo){
        setContentView(R.layout.layout_todo);

        TextView tv = findViewById(R.id.textViewTodoDetalheUserID);
        tv.setText("USER ID: " + todo.getUserId()+"");
        tv = findViewById(R.id.textViewTodoDetalheID);
        tv.setText("ID: " + todo.getId()+"");
        tv = findViewById(R.id.textViewTodoDetalheTitle);
        tv.setText("TITLE: " + todo.getTitle());
        CheckBox cb = findViewById(R.id.CheckBoxTodoDetalheCompleted);
        cb.setChecked(todo.isCompleted());
    }

    public void CarregaItemPost(Post post){
        setContentView(R.layout.layout_post);

        TextView tv = findViewById(R.id.textViewPostDetalheUserID);
        tv.setText("USER ID: " + post.getUserId()+"");
        tv = findViewById(R.id.textViewPostDetalheID);
        tv.setText("ID: " + post.getId()+"");
        tv = findViewById(R.id.textViewPostDetalheTitle);
        tv.setText("TITLE: " + post.getTitle());
        tv = findViewById(R.id.textViewPostDetalheBody);
        tv.setText("BODY: " + post.getBody());
    }

    public void CarregaItemComent(Coment coment){
        setContentView(R.layout.layout_coment);

        TextView tv = findViewById(R.id.textViewComentDetalhePostID);
        tv.setText("POST ID: " + coment.getPostId()+"");
        tv = findViewById(R.id.textViewComentDetalheID);
        tv.setText("ID: " + coment.getId()+"");
        tv = findViewById(R.id.textViewComentDetalheTitle);
        tv.setText("TITLE: " + coment.getName());
        tv = findViewById(R.id.textViewComentDetalheBody);
        tv.setText("BODY: " + coment.getBody());
    }

    public void CarregaItemAlbum(Album album){
        setContentView(R.layout.layout_album);

        TextView tv = findViewById(R.id.textViewAlbumDetalheUserID);
        tv.setText("USER ID: " + album.getUserId()+"");
        tv = findViewById(R.id.textViewAlbumDetalheID);
        tv.setText("ID: " + album.getId()+"");
        tv = findViewById(R.id.textViewAlbumDetalheTitle);
        tv.setText("TITLE: " + album.getTitle());

    }

    public void CarregaItemPhoto(Photo photo){
        setContentView(R.layout.layout_photo);

        TextView tv = findViewById(R.id.textViewPhotoAlbumId);
        tv.setText(photo.getalbumId() + "");
        tv = findViewById(R.id.textViewPhotoId);
        tv.setText(photo.getId() + "");
        tv = findViewById(R.id.textViewPhotoTitle);
        tv.setText(photo.gettitle());

        String url = photo.getthumbnailUrl();
        //new DownloadImageTask((ImageView) findViewById(R.id.imageViewPhoto)).execute(url);

/*
        ImageView image = findViewById(R.id.imageViewPhoto);

        InputStream inputStream = new java.net.URL(url).openStream();
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
        image.setImageBitmap(bitmap);*/

        //Glide.with(this).load(url).into(image);
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}