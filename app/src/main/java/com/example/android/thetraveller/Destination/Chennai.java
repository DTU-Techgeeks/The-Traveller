package com.example.android.thetraveller.Destination;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.example.android.thetraveller.R;

public class Chennai extends AppCompatActivity implements View.OnClickListener {

    public static double lat = 13.0827;
    public static double lon = 80.2707;
    public static char interestedInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chennai);
        CardView cardRestro=findViewById(R.id.cardRestro);
        CardView cardHotel= findViewById(R.id.cardHotel);
        CardView cardMarket=findViewById(R.id.cardMarket);
        CardView cardHospi=findViewById(R.id.cardHospi);
        CardView cardInfo=findViewById(R.id.cardInfo);
        CardView cardSearch=findViewById(R.id.cardSearch);

        cardRestro.setOnClickListener(this);
        cardHospi.setOnClickListener(this);
        cardHotel.setOnClickListener(this);
        cardInfo.setOnClickListener(this);
        cardMarket.setOnClickListener(this);
        cardSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.cardInfo:
                startActivity(new Intent(getBaseContext(),infoHyd.class));
                break;

            case R.id.cardSearch:
                startActivity( new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com")));
                break;

            case R.id.cardRestro:
                interestedInfo = 'R';
                startActivity(new Intent(getBaseContext(),CityMaps.class).putExtra("Activity", "Chennai"));
                break;
            case R.id.cardHotel:
                interestedInfo = 'H';
                startActivity(new Intent(getBaseContext(),CityMaps.class).putExtra("Activity", "Chennai"));
                break;
            case R.id.cardMarket:
                interestedInfo = 'M';
                startActivity(new Intent(getBaseContext(),CityMaps.class).putExtra("Activity", "Chennai"));
                break;
            case R.id.cardHospi:
                interestedInfo = 'O';
                startActivity(new Intent(getBaseContext(),CityMaps.class).putExtra("Activity", "Chennai"));
                break;

        }

    }
}
