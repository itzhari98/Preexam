package com.itzhari.preexam.Vistas.Fragmentos;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.app.Fragment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.itzhari.preexam.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class inicioFragment extends Fragment {
    public static final String ARG_ARTICLES_NUMBER = "articles_number";
    ImageView ivPicture;
    FloatingActionButton btnTakepicture;
    static  final  int REQUEST_IMAGE_CAPTURE=1;


    public inicioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_inicio, container, false);

        ivPicture = (ImageView)view.findViewById(R.id.imageviewpicture);
        btnTakepicture =(FloatingActionButton) view.findViewById(R.id.tomar);
        btnTakepicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePicture();

            }
        });

        return view;

    }
    private void takePicture() {
        Intent takePictureInten = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePictureInten.resolveActivity(getActivity().getPackageManager())!=null){
            startActivityForResult(takePictureInten, REQUEST_IMAGE_CAPTURE);


        }

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == getActivity().RESULT_OK){
            Bundle extras = data.getExtras();

            Bitmap imageBi = (Bitmap) extras.get("data");
            ivPicture.setImageBitmap(imageBi);
            ivPicture.setVisibility(View.VISIBLE);


        }
    }
}
