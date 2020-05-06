package br.com.exemplo.exemplobroadcastreceiver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class BroadcastService extends Service {
    private final IBinder mBinder = new MyBinder();

    public class MyBinder extends Binder {
        BroadcastService getService() {
            return BroadcastService.this;
        }
    }
    public BroadcastService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

}
