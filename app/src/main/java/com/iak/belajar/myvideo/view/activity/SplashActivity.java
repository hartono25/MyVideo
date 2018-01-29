package com.iak.belajar.myvideo.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

import com.iak.belajar.myvideo.R;
import com.iak.belajar.myvideo.utility.AppConstant;
import com.iak.belajar.myvideo.utility.CommonFunction;


public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                CommonFunction.moveActivity(SplashActivity.this, MainActivity.class, true);
            }
        };

        handler.postDelayed(runnable, AppConstant.SPLASH_TIME);
    }
}
