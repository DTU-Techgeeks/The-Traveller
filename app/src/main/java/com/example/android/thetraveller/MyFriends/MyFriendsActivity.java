package com.example.android.thetraveller.MyFriends;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.android.thetraveller.R;

public class MyFriendsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_friends);

        Toast.makeText(this,"You don't have any friends yet",Toast.LENGTH_LONG).show();
    }
}
