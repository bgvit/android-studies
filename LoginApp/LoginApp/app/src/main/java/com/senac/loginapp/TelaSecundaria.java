package com.senac.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TelaSecundaria extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_secundaria);

        Intent intent = getIntent();
        String usuario = intent.getStringExtra(MainActivity.login_usuario);

        TextView login = findViewById(R.id.textViewLoginShow);
        login.setText(usuario);
    }
}
