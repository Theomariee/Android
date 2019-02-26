package esir.tp2;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Environment;
import android.os.IBinder;
import android.view.View;

import java.io.IOException;

public class PlayerService extends Service implements MediaPlayer.OnPreparedListener {
    private MediaPlayer player;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initMediaPlayer();
    }

    @Override
    public void onDestroy() {
        player.release();
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String action = intent.getAction();

        switch(action) {
            case Constants.PLAY :
                play();
                break;

            case Constants.STOP :
                stop();
                break;

            default :
                break;
        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onPrepared(MediaPlayer var1) {
        player.start();
    }

    protected void initMediaPlayer() {
        String url = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/sample.mp3";

        player = new MediaPlayer();
        player.setAudioStreamType(AudioManager.STREAM_MUSIC);

        try {
            player.setDataSource(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        player.setLooping(true);
        player.setOnPreparedListener(this);
    }

    protected void play() {
        player.prepareAsync();
    }

    protected void stop() {
        player.stop();
    }
}
