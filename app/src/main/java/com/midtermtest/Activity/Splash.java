package com.midtermtest.Activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.midtermtest.R;

public class Splash extends AppCompatActivity {
    private static final String TAG = "Splash";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread Background = new Thread() {
            public void run() {

                try {
                    sleep(800);
                    finish();
                    Intent intent = new Intent(Splash.this, LoginActivity.class);
                    startActivity(intent);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Background.start();
    }
}

