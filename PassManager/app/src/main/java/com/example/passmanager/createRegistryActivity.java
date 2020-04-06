package com.example.passmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class createRegistryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_registry);
    }

    public void saveCreateRegistry(View v) {

        String registry = ((EditText)findViewById(R.id.RegistryeditText)).getText().toString();
        String login = ((EditText)findViewById(R.id.LogineditText)).getText().toString();
        String senha = ((EditText)findViewById(R.id.PasswordeditText)).getText().toString();

        SharedPreferences minhasPreferencias = PreferenceManager.getDefaultSharedPreferences(createRegistryActivity.this);
        SharedPreferences.Editor myEditor = minhasPreferencias.edit();
        myEditor.putString("REGISTRY", registry);
        myEditor.putString("LOGIN", login);
        myEditor.putString("SENHA", senha);
        myEditor.commit();
        Toast.makeText(this, "SP OK", Toast.LENGTH_LONG).show();
        finish();
    }
}
