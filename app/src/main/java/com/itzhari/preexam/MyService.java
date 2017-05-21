package com.itzhari.preexam;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
        @Override
        public int onStartCommand (Intent intent,int flags, int starId){
            Toast.makeText(this, "Empieza el servicio", Toast.LENGTH_SHORT).show();
            return START_STICKY;

        }
        @Override
        public void onDestroy () {
            super.onDestroy();
            Toast.makeText(this, "Termina el servicio", Toast.LENGTH_SHORT).show();

        }

}
