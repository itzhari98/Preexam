package com.itzhari.preexam.Vistas.Fragmentos;


import android.os.Bundle;
import android.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.itzhari.preexam.R;

import static com.itzhari.preexam.Vistas.Fragmentos.inicioFragment.ARG_ARTICLES_NUMBER;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends Fragment {
    EditText nombree ;
    EditText apellidoe ;
    EditText correoe ;
    EditText contraseñae ;
    TextView edi;
    Button guardatos ;
    Button canceldatos;
    String name,pasword,ape,email;
    String n1,p2,pe3,em4;


    public MeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_me, container, false);
        edi=(TextView)view.findViewById(R.id.editar);

         nombree =(EditText) view.findViewById(R.id.nombre);
        n1=nombree.getText().toString();
         apellidoe =(EditText) view.findViewById(R.id.apellidos);
        pe3=apellidoe.getText().toString();
        correoe =(EditText) view.findViewById(R.id.correo);
        em4=correoe.getText().toString();
         contraseñae =(EditText) view.findViewById(R.id.contraseña);
        p2= contraseñae.getText().toString();
         guardatos = (Button)view.findViewById(R.id.guar);
         canceldatos = (Button)view.findViewById(R.id.cancel);
edi.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        edi.setVisibility(View.INVISIBLE);
        contraseñae.setInputType(InputType.TYPE_CLASS_TEXT);
        edi.setEnabled(false);
        nombree.setEnabled(true);
        apellidoe.setEnabled(true);
        correoe.setEnabled(true);
        contraseñae.setEnabled(true);
        guardatos.setEnabled(true);
        canceldatos.setEnabled(true);
        guardatos.setVisibility(View.VISIBLE);
        canceldatos.setVisibility(View.VISIBLE);
    }
});
        guardatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edi.setVisibility(View.VISIBLE);

                edi.setEnabled(true);
                nombree.setEnabled(false);
                apellidoe.setEnabled(false);
                correoe.setEnabled(false);
                contraseñae.setEnabled(false);
                guardatos.setEnabled(false);
                canceldatos.setEnabled(false);
                guardatos.setVisibility(View.INVISIBLE);
                canceldatos.setVisibility(View.INVISIBLE);
                 guardar();



            }
        });
   canceldatos.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           edi.setVisibility(View.VISIBLE);

           edi.setEnabled(true);
           nombree.setEnabled(false);
           apellidoe.setEnabled(false);
           correoe.setEnabled(false);
           contraseñae.setEnabled(false);
           guardatos.setEnabled(false);
           canceldatos.setEnabled(false);
           guardatos.setVisibility(View.INVISIBLE);
           canceldatos.setVisibility(View.INVISIBLE);
           cancel();

       }
   });
        return view;
    }
    private  void  guardar(){
        name= nombree.getText().toString();
        nombree.setText(name);
        ape = apellidoe.getText().toString();
        apellidoe.setText(ape);
        email = correoe.getText().toString();
        correoe.setText(email);
        pasword = contraseñae.getText().toString();
        contraseñae.setText(pasword);
    }
    private void cancel(){
        nombree.setText(n1);
        apellidoe.setText(pe3);
        correoe.setText(em4);
        contraseñae.setText(p2);

    }


}
