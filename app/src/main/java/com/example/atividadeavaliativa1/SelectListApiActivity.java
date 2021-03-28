package com.example.atividadeavaliativa1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SelectListApiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boas_vindas);
        TextView tv = (TextView) findViewById(R.id.textViewUsuarioLogado);
        Intent it = getIntent();
        String txt = it.getStringExtra("UsuarioLogado");
        tv.setText(txt);
    }

    public void OpenTodoApi(View view){
        Intent intent = new Intent(this, ListApiRestActivity.class);
        intent.putExtra("IdentifyClass","TODO");
        startActivity(intent);
    }

    public void OpenPostsApi(View view){
        Intent intent = new Intent(this, ListApiRestActivity.class);
        intent.putExtra("IdentifyClass","POST");
        startActivity(intent);
    }

    public void OpenComentsApi(View view){
        Intent intent = new Intent(this, ListApiRestActivity.class);
        intent.putExtra("IdentifyClass","COMENT");
        startActivity(intent);
    }

    public void OpenAlbumsApi(View view){
        Intent intent = new Intent(this, ListApiRestActivity.class);
        intent.putExtra("IdentifyClass","ALBUM");
        startActivity(intent);
    }

    public void OpenPhotosApi(View view){
        Intent intent = new Intent(this, ListApiRestActivity.class);
        intent.putExtra("IdentifyClass","PHOTO");
        startActivity(intent);
    }
}