package com.itzhari.preexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.itzhari.preexam.Vistas.Crearcuenta;
import com.itzhari.preexam.Vistas.Play;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void  gocreateaccount(View view){
        Intent intent= new Intent(this, Crearcuenta.class);

        startActivity(intent);

    }
    public void  iniciarsesion(View view){
        Intent intent= new Intent(this,  Play.class);

        startActivity(intent);

    }
}
