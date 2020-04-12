package com.example.fuelservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class Calculadora extends Service {
    private final IBinder mBinder = new MyBinder();

    public class MyBinder extends Binder {
        Calculadora getService() {
            return Calculadora.this;
        }
    }
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    public float calcularConsumo(String kmString, String litrosString ){
        float kmFloat = Float.parseFloat(kmString);
        float litrosFloat = Float.parseFloat(litrosString);
        float resultado = kmFloat / litrosFloat;
        return resultado;
    }
}
