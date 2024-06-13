package com.example.librarytemi;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.robotemi.sdk.listeners.OnRobotReadyListener;

import android.net.Uri;

/**
 * This class represents the Promo Video activity
 *
 * @author Genesis Benedith
 */
public class VideoActivity extends AppCompatActivity implements OnRobotReadyListener {

    VideoView videoView;
    MediaController mediaController = new MediaController(this);


//    @Override
//    public void onRobotReady(boolean b) {
//
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.promo_video);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.promo_video);
        VideoView promoVideoView = (VideoView) findViewById(R.id.promoVideoView);
        mediaController.setMediaPlayer(videoView);
        videoView.setMediaController(mediaController);
        // set Video URL
        promoVideoView.setVideoURI();
    }

    @Override
    public void onRobotReady(boolean b) {

    }
}
