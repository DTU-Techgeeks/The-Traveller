package com.example.android.thetraveller;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class AboutUsActivity extends AppCompatActivity {

    private static final String EMAIL = "techgeeks235@gmail.com";
    private static final String GITHUB_REPO = "https://github.com/DTU-Techgeeks/The-Traveller";

    private CardView cv_fork,cv_report_bug,cv_contact_us,cv_share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        cv_fork = findViewById(R.id.cv_fork);
        cv_report_bug = findViewById(R.id.cv_report_bug);
        cv_share = findViewById(R.id.cv_share);
        cv_contact_us = findViewById(R.id.cv_contact_us);


        cv_fork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewIntent =
                        new Intent(Intent.ACTION_VIEW, Uri.parse(GITHUB_REPO));
                startActivity(viewIntent);
            }
        });

        cv_report_bug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        cv_contact_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", EMAIL, null));
                intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_hello));
                startActivity(Intent.createChooser(intent, getString(R.string.email_send)));
            }
        });

        cv_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent(Intent.ACTION_SEND);
                sendIntent.setType("text/plain");
                sendIntent.putExtra(Intent.EXTRA_TEXT,
                        getString(R.string.share_text));
                startActivity(sendIntent);
            }
        });
    }
}
