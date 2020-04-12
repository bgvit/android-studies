package com.example.fuelservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ServiceConnection {

    private Calculadora calculadora;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        intent = new Intent(this, Calculadora.class);
        bindService(intent, this, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unbindService(this);
    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Calculadora.MyBinder b = (Calculadora.MyBinder) iBinder;
        calculadora = b.getService();
        Toast.makeText(MainActivity.this, "Connected",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
        calculadora=null;
    }
    public void launchCalc(View v){
        Calculadora calc = new Calculadora();
        EditText litros = (EditText)findViewById(R.id.litrosText);
        EditText kms = (EditText)findViewById(R.id.kmText);
        float resultado = calc.calcularConsumo(kms.getText().toString(),litros.getText().toString());
        EditText resultadoText= (EditText)findViewById(R.id.resultText);
        resultadoText.setText(String.valueOf(resultado));
    }

}
