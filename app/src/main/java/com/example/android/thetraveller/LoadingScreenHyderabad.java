package com.example.android.thetraveller;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.felipecsl.gifimageview.library.GifImageView;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class LoadingScreenHyderabad extends AppCompatActivity {
    private GifImageView gifImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen_hyderabad);
        gifImageView=findViewById(R.id.gifimage2);
        try {
            InputStream inputStream=getAssets().open("loading2.gif");
            byte[] bytes= IOUtils.toByteArray(inputStream);
            gifImageView.setBytes(bytes);
            gifImageView.startAnimation();
        }catch (IOException ex)
        {

        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                LoadingScreenHyderabad.this.startActivity(new Intent(LoadingScreenHyderabad.this,Delhi.class));
                LoadingScreenHyderabad.this.finish();
            }
        },3000);
    }
    }

