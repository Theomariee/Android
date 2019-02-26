package esir.tp2;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer player = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMediaPlayer();
    }

    protected void initMediaPlayer() {
        String url = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/sample.mp3";

        player.setAudioStreamType(AudioManager.STREAM_MUSIC);

        try {
            player.setDataSource(url);
            player.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }

        player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Button playButton = findViewById(R.id.playButton);
                playButton.setEnabled(true);
            }
        });
    }

    protected void onClickPlayButton(View view) {
        if(player.isPlaying()) {
            player.stop();
            player.prepareAsync();
        }
        
        player.start();
    }

    protected void onClickStopButton(View view) {
        player.stop();
    }
}
