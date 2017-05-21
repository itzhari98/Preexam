package com.itzhari.preexam.Vistas;

import android.app.AlarmManager;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.itzhari.preexam.R;
import com.itzhari.preexam.Vistas.Fragmentos.NotasFragment;
import com.itzhari.preexam.Vistas.Fragmentos.inicioFragment;

public class CrearnoActivity extends AppCompatActivity {
    Button button;
    AlarmManager am;
    EditText ti;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crearno);
          ti=(EditText)findViewById(R.id.tiempo);
        button=(Button)findViewById(R.id.guardar);
        am=(AlarmManager) getSystemService(Context.ALARM_SERVICE);

        button.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                String i,o;
                int j=0;
                String con= ti.getText().toString().trim();
                int lon=con.length();

                if(lon>=1){
                    i=con+"0".trim();
                }
                else{
                    i=con+"00".trim();
                }
                int seg= Integer.parseInt(i);


                Intent in = new Intent();
                in.setAction("com.itzhari.preexam.action.ALARM_RECEIVER");
                PendingIntent pi = PendingIntent.getBroadcast(
                        getApplicationContext(),
                        0,
                        in,
                        0);
                am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+seg,pi);
                NotasFragment fragment = new NotasFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();


            }
        });


    }

}
