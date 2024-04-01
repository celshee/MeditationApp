package com.example.meditation_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.VideoView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class fragmen6 extends Fragment {

    View view;
    VideoView videoView;
    Button playPauseButton;
    boolean isPlaying = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_fragmen6, container, false);

        // Initialize VideoView
        videoView = view.findViewById(R.id.videoView);

        // Set video path
        String videoPath = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.video8;
        videoView.setVideoPath(videoPath);

        // Initialize play/pause button
        playPauseButton = view.findViewById(R.id.playPauseButton);
        playPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlaying) {
                    videoView.pause();
                    playPauseButton.setText("Play");
                } else {
                    videoView.start();
                    playPauseButton.setText("Pause");
                }
                isPlaying = !isPlaying;
            }
        });

        return view;
    }
}
