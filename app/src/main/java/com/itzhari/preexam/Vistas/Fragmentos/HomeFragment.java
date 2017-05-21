package com.itzhari.preexam.Vistas.Fragmentos;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.itzhari.preexam.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        ImageView img= (ImageView) view.findViewById(R.id.imgiv);
        ImageView img2 = (ImageView) view.findViewById(R.id.imgiv2);
        ImageView img3=(ImageView) view.findViewById(R.id.imgiv3);
        Glide.with(this).load("http://2.bp.blogspot.com/-hsyZc_hCd-k/U2kWM55vrWI/AAAAAAAA1XM/fX9qkmeL1qo/s1600/kanna-toyokazu-nagano-1-990x500.jpg").into(img);
        Glide.with(this).load("http://destinolandia.com/wp-content/2012/10/laboca.jpg").into(img2);
        Glide.with(this).load("https://s-media-cache-ak0.pinimg.com/736x/11/d2/11/11d211c45ef9be347d27b160239690c2.jpg").into(img3);

        return view;
    }

}
