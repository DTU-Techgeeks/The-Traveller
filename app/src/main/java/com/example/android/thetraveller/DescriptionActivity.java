package com.example.android.thetraveller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class DescriptionActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        CardView delhicard= findViewById(R.id.delhi);
        CardView bangalorecard= findViewById(R.id.bangalore);
        CardView hyderabadcard= findViewById(R.id.hyderabad);
        CardView mumbaicard= findViewById(R.id.mumbai);
        CardView kolkatacard= findViewById(R.id.kolkata);
        CardView chennaicard= findViewById(R.id.chennai);

         chennaicard.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
               Intent i=new Intent(DescriptionActivity.this,LoadingScreenDelhi.class);
                startActivity(i);
             }
         });

        delhicard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(DescriptionActivity.this,LoadingScreenDelhi.class);
                startActivity(i);
            }
        });

        hyderabadcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(DescriptionActivity.this,LoadingScreenHyderabad.class);
                startActivity(i);
            }
        });

       bangalorecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(DescriptionActivity.this,LoadingActivitybangalore.class);
                startActivity(i);
            }
        });
       kolkatacard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(DescriptionActivity.this,LoadingScreenDelhi.class);
                startActivity(i);
            }
        });

        mumbaicard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(DescriptionActivity.this,LoadingScreenDelhi.class);
                startActivity(i);
            }
        });
    }

}
