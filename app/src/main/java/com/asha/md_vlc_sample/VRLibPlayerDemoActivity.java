package com.asha.md_vlc_sample;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.Surface;

import com.asha.vrlib.MDVRLibrary;

/**
 * Created by hzqiujiadi on 16/8/26.
 * hzqiujiadi ashqalcn@gmail.com
 */
public class VRLibPlayerDemoActivity extends VLCVideoActivity {

    private MDVRLibrary mVRLibrary;

    public static void start(Context context, Uri uri){
        Intent intent = new Intent(context, VRLibPlayerDemoActivity.class);
        intent.setData(uri);
        context.startActivity(intent);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vrdemo);

        init();
    }

    protected void init() {
        mVRLibrary = MDVRLibrary.with(this)
                .displayMode(MDVRLibrary.DISPLAY_MODE_NORMAL)
                .interactiveMode(MDVRLibrary.INTERACTIVE_MODE_TOUCH)
                .asVideo(new MDVRLibrary.IOnSurfaceReadyCallback() {
                    @Override
                    public void onSurfaceReady(Surface surface) {
                        vlcSetSurface(surface);
                    }
                })
                .build(R.id.gl_view);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mVRLibrary.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mVRLibrary.onPause(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mVRLibrary.onDestroy();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mVRLibrary.onOrientationChanged(this);
    }
}
