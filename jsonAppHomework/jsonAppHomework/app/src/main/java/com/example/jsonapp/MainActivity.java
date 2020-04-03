package com.example.jsonapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Salvar(View v) throws ClassNotFoundException {
        String latitude = ((EditText) findViewById(R.id.latitudeText)).getText().toString();
        String longitude = ((EditText) findViewById(R.id.longitudeText)).getText().toString();
        EditText jsonFile = (EditText) findViewById(R.id.saveJson);
        try {
            String json = (new MeuJsonReaderWriter(latitude, longitude)).createJson();
            jsonFile.setText(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Escrever(View v) throws IOException {
        EditText latitude = (EditText)findViewById(R.id.latitudeTextFinal);
        EditText longitude = (EditText)findViewById(R.id.longitudeTextFinal);
        EditText jsonFile = (EditText)findViewById(R.id.saveJson);
        GeoJson geoJson = (new MeuJsonReaderWriter(jsonFile.getText().toString())).readJson();
        latitude.setText(geoJson.getGeometry().getLatitude());
        longitude.setText(geoJson.getGeometry().getLongitude());
    }
}
