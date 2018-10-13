package com.example.android.thetraveller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DummyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy);

        if(getIntent().getStringExtra("Parent").equals("LoginActivity"))
            startActivity(new Intent(getBaseContext(), LoginActivity.class));
        else
            startActivity(new Intent(getBaseContext(), MainActivity.class));

    }
}