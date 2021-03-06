package com.example.atividadeavaliativa1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.atividadeavaliativa1.Adapter.AlbumAdapter;
import com.example.atividadeavaliativa1.Adapter.ComentAdapter;
import com.example.atividadeavaliativa1.Adapter.PhotoAdapter;
import com.example.atividadeavaliativa1.Adapter.PostAdapter;
import com.example.atividadeavaliativa1.Adapter.TodoAdapter;
import com.example.atividadeavaliativa1.Model.Album;
import com.example.atividadeavaliativa1.Model.Coment;
import com.example.atividadeavaliativa1.Model.Photo;
import com.example.atividadeavaliativa1.Model.Post;
import com.example.atividadeavaliativa1.Model.Todo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListApiRestActivity extends AppCompatActivity
        implements Response.Listener<JSONArray>,
        Response.ErrorListener {

    List<Todo> todos =  new ArrayList<>();
    List<Post> posts =  new ArrayList<>();
    List<Coment> coments =  new ArrayList<>();
    List<Album> albums =  new ArrayList<>();
    List<Photo> photos =  new ArrayList<>();

    private String url;
    private String typeclass;
    private RecyclerView rv;
    private TodoAdapter todoAdapter;
    private AlbumAdapter albumAdapter;
    private PhotoAdapter photoAdapter;
    private PostAdapter postAdapter;
    private ComentAdapter comentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_api_rest);

        Intent intent = getIntent();
        typeclass = intent.getStringExtra("IdentifyClass");
        TextView title = (TextView) findViewById(R.id.TitleList);

        switch (typeclass){
            case "TODO":
                title.setText("LIST TODOS");
                url = "https://jsonplaceholder.typicode.com/todos";
                break;
            case "POST":
                title.setText("LIST POSTS");
                url = "https://jsonplaceholder.typicode.com/posts";
                break;
            case "COMENT":
                title.setText("LIST COMENTS");
                url = "https://jsonplaceholder.typicode.com/comments";
                break;
            case "ALBUM":
                title.setText("LIST ALBUMS");
                url = "https://jsonplaceholder.typicode.com/albums";
                break;
            case "PHOTO":
                title.setText("LIST PHOTOS");
                url = "https://jsonplaceholder.typicode.com/photos";
                break;
        }

        //INSTANCIA O RequestQueue
        RequestQueue queue = Volley.newRequestQueue(this);

        //FAZ O REQUEST
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                this, this);

        //ADICIONA O REQUEST NO RequestQueue
        queue.add(jsonArrayRequest);
    }

    @Override
    public void onResponse(JSONArray response) {
        try{
            for(int i = 0; i < response.length(); i++) {

                JSONObject json = response.getJSONObject(i);

                switch (typeclass){
                    case "TODO":
                        Todo obj = new Todo(json.getInt("userId"),
                                json.getInt("id"),
                                json.getString("title"),
                                json.getBoolean("completed"));
                        todos.add(obj);
                        break;
                    case "POST":
                        Post pst = new Post(json.getInt("userId"),
                                json.getInt("id"),
                                json.getString("title"));
                        posts.add(pst);
                        break;
                    case "COMENT":
                        Coment coment = new Coment(json.getInt("postId"),
                                json.getInt("id"),
                                json.getString("name"),
                                json.getString("email"),
                                json.getString("body"));
                        coments.add(coment);
                        break;
                    case "ALBUM":
                        Album album = new Album(json.getInt("userId"),
                                json.getInt("id"),
                                json.getString("title"));
                        albums.add(album);
                        break;
                    case "PHOTO":
                        Photo photo = new Photo(json.getInt("albumId"),
                                json.getInt("id"),
                                json.getString("title"),
                                json.getString("url"),
                                json.getString("thumbnailUrl"));
                        photos.add(photo);
                        break;
                    default:
                        throw new IllegalStateException("Tipo de lista n??o implementada: " + typeclass.toString());
                }
            }

            switch (typeclass){
                case "TODO":
                    /*LinearLayout llTodos = findViewById(R.id.layoutVerticalItens);
                    for(Todo obj1 : todos) {
                        Button bt = new Button(this);
                        bt.setText(obj1.getTitle());
                        bt.setTag(obj1);
                        bt.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Button btn = (Button) v;
                                Todo todo = (Todo) btn.getTag();
                                Intent intent = new Intent(getApplicationContext(), DetalheItemLisActivity.class);
                                intent.putExtra("obj", todo);
                                startActivity(intent);
                            }
                        });
                        llTodos.addView(bt);
                    }*/
                    rv = findViewById(R.id.RecyclerViewListApi);
                    rv.setLayoutManager(new LinearLayoutManager(this));

                    todoAdapter = new TodoAdapter(todos, R.layout.layout_todo);
                    rv.setAdapter(todoAdapter);

                    break;
                case "POST":
                    /*LinearLayout llPosts = findViewById(R.id.layoutVerticalItens);
                    for(Post obj1 : posts) {
                        Button bt = new Button(this);
                        bt.setText(obj1.getTitle());
                        bt.setTag(obj1);
                        bt.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Button btn = (Button) v;
                                Post post = (Post) btn.getTag();
                                Intent intent = new Intent(getApplicationContext(), DetalheItemLisActivity.class);
                                intent.putExtra("obj", post);
                                startActivity(intent);
                            }
                        });
                        llPosts.addView(bt);
                    }*/
                    rv = findViewById(R.id.RecyclerViewListApi);
                    rv.setLayoutManager(new LinearLayoutManager(this));

                    postAdapter = new PostAdapter(posts, R.layout.layout_post);
                    rv.setAdapter(postAdapter);

                    break;
                case "COMENT":
                    /*LinearLayout llComent = findViewById(R.id.layoutVerticalItens);
                    for(Coment obj1 : coments) {
                        Button bt = new Button(this);
                        bt.setText(obj1.getName());
                        bt.setTag(obj1);
                        bt.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Button btn = (Button) v;
                                Coment coment = (Coment) btn.getTag();
                                Intent intent = new Intent(getApplicationContext(), DetalheItemLisActivity.class);
                                intent.putExtra("obj", coment);
                                startActivity(intent);
                            }
                        });
                        llComent.addView(bt);
                    }*/

                    rv = findViewById(R.id.RecyclerViewListApi);
                    rv.setLayoutManager(new LinearLayoutManager(this));

                    comentAdapter = new ComentAdapter(coments, R.layout.layout_coment);
                    rv.setAdapter(comentAdapter);

                    break;
                case "ALBUM":
                    /*LinearLayout llAlbum = findViewById(R.id.layoutVerticalItens);
                    for(Album obj1 : albums) {
                        Button bt = new Button(this);
                        bt.setText(obj1.getTitle());
                        bt.setTag(obj1);
                        bt.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Button btn = (Button) v;
                                Album album = (Album) btn.getTag();
                                Intent intent = new Intent(getApplicationContext(), DetalheItemLisActivity.class);
                                intent.putExtra("obj", album);
                                startActivity(intent);
                            }
                        });
                        llAlbum.addView(bt);
                    }*/
                    rv = findViewById(R.id.RecyclerViewListApi);
                    rv.setLayoutManager(new LinearLayoutManager(this));

                    albumAdapter = new AlbumAdapter(albums,R.layout.layout_album);
                    rv.setAdapter(albumAdapter);

                    break;
                case "PHOTO":
                    /*LinearLayout llphotos = findViewById(R.id.layoutVerticalItens);
                    for(Photo obj1 : photos) {
                        Button bt = new Button(this);
                        bt.setText(obj1.gettitle());
                        bt.setTag(obj1);
                        bt.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Button btn = (Button) v;
                                Photo photo = (Photo) btn.getTag();
                                Intent intent = new Intent(getApplicationContext(), DetalheItemLisActivity.class);
                                intent.putExtra("obj", photo);
                                startActivity(intent);
                            }
                        });
                        llphotos.addView(bt);
                    }*/

                    rv = findViewById(R.id.RecyclerViewListApi);
                    rv.setLayoutManager(new LinearLayoutManager(this));

                    photoAdapter = new PhotoAdapter(photos, R.layout.layout_photo);
                    rv.setAdapter(photoAdapter);
                    break;
                default:
                    throw new IllegalStateException("N??o foi poss??vel exibir a lista.");
            }
        } catch (JSONException e) {
            Log.e("erro",e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        alert("Response Error: " + error.getMessage());
    }

    public void alert(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }
}