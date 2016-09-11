package com.asha.md_vlc_sample;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String URL = "file:///sdcard/vr/video_31b451b7ca49710719b19d22e19d9e60.mp4";

    private static final String URL_RTSP = "rtsp://218.204.223.237:554/live/1/66251FC11353191F/e7ooqwcfbqjoo80j.sdp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onVRLibClicked(View view) {
        VRLibPlayerDemoActivity.start(MainActivity.this, Uri.parse(URL));
    }

    public void onRTSPVRLibClicked(View view) {
        VRLibPlayerDemoActivity.start(MainActivity.this, Uri.parse(URL_RTSP));
    }
}
