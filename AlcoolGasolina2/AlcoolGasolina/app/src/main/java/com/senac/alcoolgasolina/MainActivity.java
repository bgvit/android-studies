package com.senac.alcoolgasolina;

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

    public void calcular(View v) {
        String gasValueString = ((EditText) findViewById(R.id.gasEditText)).getText().toString();
        String alcoholValueString = ((EditText)findViewById(R.id.alcoolEditText)).getText().toString();

        float gasValueFloat = Float.parseFloat(gasValueString);
        float alcoholValueFloat = Float.parseFloat(alcoholValueString);

        if (alcoholValueFloat <= (gasValueFloat * 0.75)) {
            Intent alcoolIntent = new Intent(this, alcoolActivity.class);
            startActivity(alcoolIntent);
            finish();
        } else {
            Intent gasIntent = new Intent(this, gasActivity.class);
            startActivity(gasIntent);
            finish();
        }
    }
}
