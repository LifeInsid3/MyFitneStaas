package com.example.myfitnestaas;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView videoView = findViewById(R.id.videoView2);

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.vidi);

        videoView.requestFocus(0);

        videoView.start();
        intent = new Intent(this,MainActivity.class);
    }

    public void btn1(View view) {
        Intent intent = new Intent(this,InfoActivity.class);
        startActivity(intent);
    }

    public void btn2(View view) {
        Intent intent = new Intent(this,TimeTableActivity.class);
        startActivity(intent);
    }
}