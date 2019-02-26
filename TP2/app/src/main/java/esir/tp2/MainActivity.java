package esir.tp2;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void onClickPlayButton(View view) {
        startService(new Intent(this, PlayerService.class).setAction(Constants.PLAY));
    }

    protected void onClickStopButton(View view) {
        startService(new Intent(this, PlayerService.class).setAction(Constants.STOP));
    }
}
