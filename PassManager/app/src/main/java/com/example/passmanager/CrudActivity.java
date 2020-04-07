package com.example.passmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CrudActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud);
    }

    public void AcessoCreateRegistry(View v) {

        Intent createRegistryActivity = new Intent(this, createRegistryActivity.class);
        startActivity(createRegistryActivity);
        finish();
    }
    public void AcessoSearchByRegistry(View v) {

        Intent searchByRegistryActivity = new Intent(this, searchByRegistryActivity.class);
        startActivityForResult(searchByRegistryActivity, 2);
        /*startActivity(searchByRegistryActivity);*/
        finish();
    }

}
