package com.itzhari.preexam.Vistas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.itzhari.preexam.MyService;
import com.itzhari.preexam.R;

public class Play extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

    }
    public void empezarServ(View view){
        Intent intent= new Intent(this, CotenedorActivity.class);
        startActivity(intent);
        startService(new Intent(getBaseContext(),MyService.class));

    }

}
