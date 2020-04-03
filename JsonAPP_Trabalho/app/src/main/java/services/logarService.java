package services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class logarService extends Service {
    private final IBinder mBinder = new MyBinder();

    public logarService() {
    }

    public class MyBinder extends Binder {
        logarService getService() {
            return logarService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    public boolean validar(String login, String senha){
        if(login.equals("Anderson") && senha.equals("123456"))
            return true;

        return false;
    }


}
