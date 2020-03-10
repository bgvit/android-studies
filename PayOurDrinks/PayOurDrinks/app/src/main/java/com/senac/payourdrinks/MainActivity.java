package com.senac.payourdrinks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcTotal(View v) {
        float total = 0;
        String people = ((EditText)findViewById(R.id.editTextPeople)).getText().toString();
        int number_people = Integer.parseInt(people);

        String values[] = ((EditText)findViewById(R.id.editTextValues)).getText().toString().split(" ");

        List<Float> nvalues = new ArrayList<>();

        for (int i = 0; i == values.length; i++) {
            nvalues.add(Float.valueOf(values[i]));
            total += nvalues.get(i).floatValue();
        }

        TextView totalText = findViewById(R.id.textViewTotalValor);
        String total_string = String.valueOf(total/number_people);
        totalText.setText(total_string);
    }
}
