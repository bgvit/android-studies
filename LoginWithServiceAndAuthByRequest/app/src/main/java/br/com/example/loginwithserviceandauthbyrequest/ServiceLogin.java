package br.com.example.loginwithserviceandauthbyrequest;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.StrictMode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class ServiceLogin extends Service {
    public ServiceLogin() {
    }

    private final IBinder mBinder = new MyBinder();

    public class MyBinder extends Binder {
        ServiceLogin getService() {
            return ServiceLogin.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    public boolean validar(String login, String senha) {
        return conexao(login, senha);
    }

    public boolean conexao(String login, String senha) {
        HttpURLConnection conn = null;
        StringBuilder sbParams = new StringBuilder();
        HashMap<String, String> params = null;
        int i = 0;

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        try {
            String url = "http://10.0.2.2:8888";
            URL urlObj = new URL(url);
            conn = (HttpURLConnection) urlObj.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept-Charset", "UTF-8");

            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);

            conn.connect();

            String paramsString = sbParams.toString();

            DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
            wr.writeBytes(paramsString);
            wr.flush();
            wr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            InputStream in = new BufferedInputStream(conn.getInputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            System.out.println(result);

            return ValidarAcesso(login, senha, result.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return false;
    }

    public boolean ValidarAcesso(String login, String senha, String Json) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        Acesso acesso = objectMapper.readValue(Json, Acesso.class);
        String loginJson = acesso.getLogin();
        String senhaJson = acesso.getSenha();

        if (login.equals(loginJson) && senha.equals(senhaJson))
            return true;

        return false;

    }
}
