package com.example.android.thetraveller;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.felipecsl.gifimageview.library.GifImageView;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class LoadingHotel extends AppCompatActivity {
    private GifImageView gifImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_hotel);
        gifImageView=findViewById(R.id.gifimage3);
        try {
            InputStream inputStream=getAssets().open("loading4.gif");
            byte[] bytes= IOUtils.toByteArray(inputStream);
            gifImageView.setBytes(bytes);
            gifImageView.startAnimation();
        }catch (IOException ex)
        {

        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               startActivity(new Intent(LoadingHotel.this,HotelActivity.class));
                finish();
            }
        },3000);
    }
}
