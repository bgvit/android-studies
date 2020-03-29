package com.senac.minhaapp;

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
import services.logarService;

public class MainActivity extends AppCompatActivity implements ServiceConnection {
    private logarService LogarService;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        intent = new Intent(this, logarService.class);
        bindService(intent, this, Context.BIND_AUTO_CREATE);
    }
    @Override
    protected void onPause() {
        super.onPause();
        unbindService(this);
    }
    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        logarService.MyBinder b = (logarService.MyBinder) iBinder;
        LogarService = b.getService();
        Toast.makeText(MainActivity.this, "Connected", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
        LogarService = null;
    }
    public void botao(View v){
        EditText id1 =
                (EditText)findViewById(R.id.Login);
        EditText id2 =
                (EditText)findViewById(R.id.Senha);
        String login = id1.getText().toString();
        String senha = id2.getText().toString();
        String status = LogarService.validar(login,
                senha)?"Acesso Autorizado":"Erro";
        Toast.makeText(this, status,
                Toast.LENGTH_SHORT).show();
    }
}
