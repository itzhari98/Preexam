package com.itzhari.preexam.Vistas;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.itzhari.preexam.MainActivity;
import com.itzhari.preexam.R;

public class Crearcuenta extends AppCompatActivity {
    private FirebaseAuth firebaseAuth ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crearcuenta);
        showtoolbar(getResources().getString(R.string.Titulo_toolbar_crearcuenta),true);
        firebaseAuth = FirebaseAuth.getInstance();
        final TextInputEditText etEmail = (TextInputEditText)findViewById(R.id.email);
        final TextInputEditText etName = (TextInputEditText)findViewById(R.id.name);
        final TextInputEditText etUser = (TextInputEditText)findViewById(R.id.user);
        final TextInputEditText etPasword = (TextInputEditText)findViewById(R.id.password);
        final TextInputEditText etPasswordcon = (TextInputEditText)findViewById(R.id.confirpass);
        Button creat=(Button) findViewById(R.id.login);
        creat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String user = etUser.getText().toString();
                String name = etName.getText().toString();

                String password = etPasword.getText().toString();
                String passwordcon=etPasswordcon.getText().toString();
                if(email.equals("")){
                    Toast.makeText(getApplicationContext(),"Introducir un email por favor", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!password.equals(passwordcon)){
                    if (password.equals("")){
                        Toast.makeText(getApplicationContext(),"Introducir un email por favor", Toast.LENGTH_SHORT).show();
                        return;
                    }

                }

                firebaseAuth.createUserWithEmailAndPassword(email,password)
                       .addOnCompleteListener(Crearcuenta.this, new OnCompleteListener<AuthResult>() {
                           @Override
                           public void onComplete(@NonNull Task<AuthResult> task) {
                               if(!task.isSuccessful()){
                                   Toast.makeText(Crearcuenta.this,"Auth failed ",Toast.LENGTH_SHORT).show();

                               }
                               else {
                                   startActivity(new Intent(Crearcuenta.this, MainActivity.class));
                                   finish();
                               }

                           }
                       });

            }
        });

}
    public void showtoolbar(String title, boolean upButton){
        Toolbar tolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(tolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

    }


}
