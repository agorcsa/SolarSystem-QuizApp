package com.example.android.solarsystemquiz;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.felipecsl.gifimageview.library.GifImageView;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class SplashScreen extends AppCompatActivity {

    private GifImageView gifImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        // Set GIFImageView as a resource
        gifImageView = (GifImageView) findViewById(R.id.gifImageView);

        try {
            InputStream inputSteam = getAssets().open("planetsmovement.gif");
            byte[] bytes = IOUtils.toByteArray(inputSteam);
            gifImageView.setBytes(bytes);
            gifImageView.startAnimation();
        } catch (IOException ex) {

        }

        //Wait for a few seconds and start MainActivity

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SplashScreen.this.startActivity(new Intent(SplashScreen.this, MainActivity.class));
                SplashScreen.this.finish();
            }

        },14000); // 14000 = 14 seconds
    }
}