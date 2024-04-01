package com.example.meditation_app;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

public class Mind extends AppCompatActivity {
    private ListView songsListView;
    private TextView infoTextView;
    private MediaPlayer mediaPlayer;
    private SeekBar seekBar;
    private Button playPauseButton;
    private boolean isPlaying = false;
    private int[] songResources = {
            R.raw.song1, R.raw.song2, R.raw.song3, R.raw.song4, R.raw.song5,
            R.raw.song6, R.raw.song7, R.raw.song8, R.raw.song9, R.raw.song10
    };
    private int currentSongIndex = -1;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mind);

        songsListView = findViewById(R.id.songsListView);
        infoTextView = findViewById(R.id.infoTextView);
        seekBar = findViewById(R.id.seekBar);
        playPauseButton = findViewById(R.id.playPauseButton);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.song_names, android.R.layout.simple_list_item_1);
        songsListView.setAdapter(adapter);

        songsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                currentSongIndex = position;
                playSong(songResources[position]);
            }
        });

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                isPlaying = false;
                seekBar.setProgress(0);
                playPauseButton.setText("Play");
                infoTextView.setText("Stopped");
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    private void playSong(int songResource) {
        try {
            mediaPlayer.reset();
            mediaPlayer.setDataSource(getResources().openRawResourceFd(songResource));
            mediaPlayer.prepare();
            mediaPlayer.start();
            isPlaying = true;
            playPauseButton.setText("Pause");
            infoTextView.setText("Now Playing: " + getResources().getStringArray(R.array.song_names)[currentSongIndex]);
            seekBar.setMax(mediaPlayer.getDuration());
            updateSeekBar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playPause(View view) {
        if (isPlaying) {
            mediaPlayer.pause();
            isPlaying = false;
            playPauseButton.setText("Play");
        } else {
            mediaPlayer.start();
            isPlaying = true;
            playPauseButton.setText("Pause");
            updateSeekBar();
        }
    }

    private void updateSeekBar() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mediaPlayer != null && isPlaying) {
                    int mCurrentPosition = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress(mCurrentPosition);
                    updateSeekBar();
                }
            }
        }, 1000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
