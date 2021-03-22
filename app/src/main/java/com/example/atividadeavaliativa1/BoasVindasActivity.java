package com.example.atividadeavaliativa1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BoasVindasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boas_vindas);
        TextView tv = (TextView) findViewById(R.id.textViewUsuarioLogado);
        Intent it = getIntent();
        String txt = it.getStringExtra("UsuarioLogado");
        tv.setText(txt);
    }

    public void BackLogin(View view){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

    public void BackSplash(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}