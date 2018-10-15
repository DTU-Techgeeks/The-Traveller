package com.example.android.thetraveller;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.felipecsl.gifimageview.library.GifImageView;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class LoadingScreenDelhi extends AppCompatActivity {

    private GifImageView gifImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);

        gifImageView=findViewById(R.id.gifimage1);
        try {
            InputStream inputStream=getAssets().open("loading.gif");
            byte[] bytes= IOUtils.toByteArray(inputStream);
            gifImageView.setBytes(bytes);
            gifImageView.startAnimation();
        }catch (IOException ex)
        {

        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                LoadingScreenDelhi.this.startActivity(new Intent(LoadingScreenDelhi.this,Delhi.class));
                LoadingScreenDelhi.this.finish();
            }
        },3000);
    }
    }

