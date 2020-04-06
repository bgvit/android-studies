package com.example.passmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static final String login_usuario = "";

    public void Acesso(View v) {
        String Login = ((EditText)findViewById(R.id.editTextLogin)).getText().toString();
        String Senha = ((EditText)findViewById(R.id.editTextSenha)).getText().toString();

        Intent CrudActivity = new Intent(this, CrudActivity.class);
        startActivity(CrudActivity);
        finish();
    }
}
