package com.example.passmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class searchByRegistryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_by_registry);
    }

    public void searchByRegistry(View v){
        String registry = ((EditText)findViewById(R.id.RegistryeditText)).getText().toString();
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(searchByRegistryActivity.this);

        String loginString = myPreferences.getString("LOGIN", "unknown");
        String senhaString = myPreferences.getString("SENHA", "unknown");

        EditText login = ((EditText)findViewById(R.id.LogineditText));
        EditText senha = ((EditText)findViewById(R.id.PasswordeditText));

        login.setText(loginString, TextView.BufferType.NORMAL);
        senha.setText(senhaString, TextView.BufferType.NORMAL);


    }
}
