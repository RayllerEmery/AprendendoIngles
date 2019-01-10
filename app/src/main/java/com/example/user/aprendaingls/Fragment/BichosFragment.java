package com.example.user.aprendaingls.Fragment;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.user.aprendaingls.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BichosFragment extends Fragment implements View.OnClickListener{
    private ImageButton imgBtnDog, imgBtnCat, imgBtnLion, imgBtnMonk, imgBtnShp, imgBtnCow;
    private MediaPlayer mediaPlayer;

    public BichosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bichos, container, false);

        //buscando id's
        imgBtnCat = view.findViewById(R.id.imgBtnCat);
        imgBtnDog = view.findViewById(R.id.imgBtnDog);
        imgBtnLion = view.findViewById(R.id.imgBtnLion);
        imgBtnMonk = view.findViewById(R.id.imgBtnMonk);
        imgBtnShp = view.findViewById(R.id.imgBtnShp);
        imgBtnCow = view.findViewById(R.id.imgBtnCow);

        imgBtnDog.setOnClickListener(this);
        imgBtnCat.setOnClickListener(this);
        imgBtnLion.setOnClickListener(this);
        imgBtnMonk.setOnClickListener(this);
        imgBtnShp.setOnClickListener(this);
        imgBtnCow.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgBtnDog:
                executaMusica(mediaPlayer = MediaPlayer.create(getActivity(), R.raw.dog));
                break;
            case R.id.imgBtnCat:
                executaMusica(mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cat));
                break;
            case R.id.imgBtnLion:
                executaMusica(mediaPlayer = MediaPlayer.create(getActivity(), R.raw.lion));
                break;
            case R.id.imgBtnMonk:
                executaMusica(mediaPlayer = MediaPlayer.create(getActivity(), R.raw.monkey));
                break;
            case R.id.imgBtnShp:
                executaMusica(mediaPlayer = MediaPlayer.create(getActivity(), R.raw.sheep));
                break;
            case R.id.imgBtnCow:
                executaMusica(mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cow));
                break;
        }
    }

    public void executaMusica(final MediaPlayer mediaPlayer){
        mediaPlayer.start();

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
                mediaPlayer.release();
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null && !mediaPlayer.isPlaying()){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
