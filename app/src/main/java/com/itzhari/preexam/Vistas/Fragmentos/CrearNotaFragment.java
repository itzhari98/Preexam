package com.itzhari.preexam.Vistas.Fragmentos;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.itzhari.preexam.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CrearNotaFragment extends Fragment {
    EditText contenido;
    EditText  titulo;
    TextView nota;
    public String titu;
    int r;
    public CrearNotaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.activity_crearno, container, false);
        titulo = (EditText) view.findViewById(R.id.titulo);
        nota = (TextView) view.findViewById(R.id.titu1);
        Button btnCre = (Button) view.findViewById(R.id.crearno);

        btnCre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titu=titulo.getText().toString();

                NotasFragment fragment = new NotasFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();




            }
        });
        return view;
    }


}
