package com.example.atividadeavaliativa1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void login(View view){
        TextView CampoCpf = (TextView) findViewById(R.id.CpfLogin);
        TextView CampoSenha = (TextView) findViewById(R.id.SenhaLogin);

        String Cpf = CampoCpf.getText().toString();
        String Senha = CampoSenha.getText().toString();

        if (!Cpf.equals("") && !Senha.equals("") && Cpf.equals(Senha)){
            Intent intent = new Intent(this,BoasVindasActivity.class);
            intent.putExtra("UsuarioLogado",Cpf);
            startActivity(intent);
        }
        else{
            alert("Usuário ou Senha Incorretos");
        }

    }
    private void alert(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }
}