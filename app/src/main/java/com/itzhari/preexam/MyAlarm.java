package com.itzhari.preexam;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyAlarm extends BroadcastReceiver {
    public MyAlarm() {
    }

    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Alarma!", Toast.LENGTH_SHORT).show();
    }
}
