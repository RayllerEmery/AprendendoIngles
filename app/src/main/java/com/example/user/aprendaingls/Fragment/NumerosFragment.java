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
public class NumerosFragment extends Fragment implements View.OnClickListener{
    private ImageButton btnOne, btnTwo, btnThr, btnFour, btnFive, btnSix;
    private MediaPlayer mediaPlayer;

    public NumerosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_numeros, container, false);

        btnOne = view.findViewById(R.id.btnOne);
        btnTwo = view.findViewById(R.id.btnTwo);
        btnThr = view.findViewById(R.id.btnThr);
        btnFour = view.findViewById(R.id.btnFour);
        btnFive = view.findViewById(R.id.btnFive);
        btnSix = view.findViewById(R.id.btnSix);

        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThr.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnOne:
                executaMusica(mediaPlayer = MediaPlayer.create(getActivity(), R.raw.one));
                break;
            case R.id.btnTwo:
                executaMusica(mediaPlayer = MediaPlayer.create(getActivity(), R.raw.two));
                break;
            case R.id.btnThr:
                executaMusica(mediaPlayer = MediaPlayer.create(getActivity(), R.raw.three));
                break;
            case R.id.btnFour:
                executaMusica(mediaPlayer = MediaPlayer.create(getActivity(), R.raw.four));
                break;
            case R.id.btnFive:
                executaMusica(mediaPlayer = MediaPlayer.create(getActivity(), R.raw.five));
                break;
            case R.id.btnSix:
                executaMusica(mediaPlayer = MediaPlayer.create(getActivity(), R.raw.six));
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
