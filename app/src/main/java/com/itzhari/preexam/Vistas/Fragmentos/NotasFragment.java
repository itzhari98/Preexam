package com.itzhari.preexam.Vistas.Fragmentos;


import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.itzhari.preexam.R;
import com.itzhari.preexam.Vistas.Crearcuenta;
import com.itzhari.preexam.Vistas.CrearnoActivity;
import com.itzhari.preexam.Vistas.Play;

import static com.itzhari.preexam.Vistas.Fragmentos.inicioFragment.ARG_ARTICLES_NUMBER;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotasFragment extends Fragment {
    private Activity activity;
    FloatingActionButton not;
     public TextView ti;
     ImageView note;

    public NotasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notas, container, false);
        not = (FloatingActionButton) view.findViewById(R.id.crear);


        ti = (TextView) view.findViewById(R.id.titu1);

        not.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                creno();
            }
        });

        return view;
    }

    private void creno(){
        CrearNotaFragment fragment= new CrearNotaFragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
    }


}
