package com.example.android.thetraveller;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Kolkata extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kolkata);
        CardView cardRestro=findViewById(R.id.cardRestro);
        CardView cardHotel= findViewById(R.id.cardHotel);
        CardView cardMarket=findViewById(R.id.cardMarket);
        CardView cardHospi=findViewById(R.id.cardHospi);
        CardView cardInfo=findViewById(R.id.cardInfo);
        CardView cardSearch=findViewById(R.id.cardSearch);

        //cardRestro.setOnClickListener(this);
        //cardHospi.setOnClickListener(this);
        //cardHotel.setOnClickListener(this);
        cardInfo.setOnClickListener(this);
        // cardMarket.setOnClickListener(this);
        cardSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.cardInfo:
                startActivity(new Intent(Kolkata.this,infoKolkata.class));
                break;

            case R.id.cardSearch:
                startActivity( new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com")));
                break;

        }

    }
}
