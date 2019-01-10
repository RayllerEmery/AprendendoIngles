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
public class VogaisFragment extends Fragment implements View.OnClickListener{
    private MediaPlayer mediaPlayer;
    private ImageButton a, e, i, o, u;

    public VogaisFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_vogais, container, false);

        a = view.findViewById(R.id.imgBtnA);
        e = view.findViewById(R.id.imgBtnE);
        i = view.findViewById(R.id.imgBtnI);
        o = view.findViewById(R.id.imgBtnO);
        u = view.findViewById(R.id.imgBtnU);

        a.setOnClickListener(this);
        e.setOnClickListener(this);
        o.setOnClickListener(this);
        i.setOnClickListener(this);
        u.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case (R.id.imgBtnA):
                exeSound(mediaPlayer = MediaPlayer.create(getActivity(), R.raw.a));
                break;
            case(R.id.imgBtnE):
                exeSound(mediaPlayer = MediaPlayer.create(getActivity(), R.raw.e));
                break;
            case(R.id.imgBtnI):
                exeSound(mediaPlayer = MediaPlayer.create(getActivity(), R.raw.i));
                break;
            case(R.id.imgBtnO):
                exeSound(mediaPlayer = MediaPlayer.create(getActivity(), R.raw.o));
                break;
            case(R.id.imgBtnU):
                exeSound(mediaPlayer = MediaPlayer.create(getActivity(), R.raw.u));
                break;
        }

    }

    public void exeSound(final MediaPlayer mediaPlayer){
        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer.release();
                mp.release();
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
