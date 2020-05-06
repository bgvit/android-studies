package br.com.example.loginwithserviceandauthbyrequest;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ServiceConnection {
    private ServiceLogin logar;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        intent = new Intent(this, ServiceLogin.class);
        bindService(intent, this, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unbindService(this);
    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ServiceLogin.MyBinder b = (ServiceLogin.MyBinder) iBinder;
        logar = b.getService();
        Toast.makeText(MainActivity.this, "Connected", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
        logar = null;
    }

    public void botao(View v) {

        EditText id1 = (EditText) findViewById(R.id.loginPlainText);
        EditText id2 = (EditText) findViewById(R.id.senhaPlainText);

        String login = id1.getText().toString();
        String senha = id2.getText().toString();
        System.out.println(login);
        System.out.println(senha);
        String status = logar.validar(login, senha) ? "Acesso Autorizado" : "Erro";
        System.out.println(status);
        Toast.makeText(this, status, Toast.LENGTH_SHORT).show();
    }
}