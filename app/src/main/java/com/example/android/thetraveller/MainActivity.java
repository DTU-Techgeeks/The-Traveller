package com.example.android.thetraveller;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.android.thetraveller.Destination.LoadingActivitybangalore;
import com.example.android.thetraveller.Destination.LoadingScreenChennai;
import com.example.android.thetraveller.Destination.LoadingScreenDelhi;
import com.example.android.thetraveller.Destination.LoadingScreenHyderabad;
import com.example.android.thetraveller.Destination.LoadingScreenKolkata;
import com.example.android.thetraveller.Destination.LoadingScreenMumbai;
import com.example.android.thetraveller.MyFriends.MyFriendsActivity;
import com.example.android.thetraveller.MyTrips.MyTripsActivity;
import com.example.android.thetraveller.MyTrips.TripsActivity;
import com.example.android.thetraveller.Travel.TravelActivity;
import com.example.android.thetraveller.Utils.UtilActivity;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbarMain);
        toolbar.setTitle("The Traveller");

        ProfileDrawerItem profileDrawerItem = new ProfileDrawerItem().withTextColor(Color.GREEN).withName("XYZ").withEmail("XYZ123@gmail.com").withIcon(getResources().getDrawable(R.drawable.avatar));
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.blue)
                .addProfiles(
                        profileDrawerItem
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();
        headerResult.updateProfile(profileDrawerItem);

        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("Destination").withIcon(R.drawable.destination).withTextColor(Color.BLACK);
        PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(2).withName("Travel").withIcon(R.drawable.travel_icon).withTextColor(Color.BLACK);
        PrimaryDrawerItem item3 = new PrimaryDrawerItem().withIdentifier(3).withName("My Trips").withIcon(R.drawable.trip).withTextColor(Color.BLACK);
        PrimaryDrawerItem item4 = new PrimaryDrawerItem().withIdentifier(4).withName("My Friends").withIcon(R.drawable.friend).withTextColor(Color.BLACK);
        PrimaryDrawerItem item5 = new PrimaryDrawerItem().withIdentifier(5).withName("Utilities").withIcon(R.drawable.utilities).withTextColor(Color.BLACK);

        PrimaryDrawerItem item6 = new PrimaryDrawerItem().withIdentifier(6).withName("About us").withIcon(R.drawable.about_us);
        PrimaryDrawerItem item7 = new PrimaryDrawerItem().withIdentifier(7).withName("Sign Out").withIcon(R.drawable.logout);
        PrimaryDrawerItem item8 = new PrimaryDrawerItem().withIdentifier(8).withName("Settings").withIcon(R.drawable.settings);

//create the drawer and remember the `Drawer` result object
        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(headerResult)
                .withToolbar(toolbar)
                .addDrawerItems(
                        item1,
                        item2,
                        item3,
                        item4,
                        item5,
                        new DividerDrawerItem(),
                        item6,
                        item7,
                        item8
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                        switch (position){
                            case 1 : startActivity(new Intent(getBaseContext(),MainActivity.class));
                                break;
                            case 2 : startActivity(new Intent(getBaseContext(),TravelActivity.class));
                                break;
                            case 3 : startActivity(new Intent(getBaseContext(),TripsActivity.class));
                                break;
                            case 4 : startActivity(new Intent(getBaseContext(),MyFriendsActivity.class));
                                break;
                            case 5 : startActivity(new Intent(getBaseContext(),UtilActivity.class));
                                break;
                            case 6 : startActivity(new Intent(getBaseContext(),AboutUsActivity.class));
                                break;
                            case 7 : startActivity(new Intent(getBaseContext(),MainActivity.class));
                                break;
                            case 8 : startActivity(new Intent(getBaseContext(),SettingsActivity.class));
                                break;

                        }
                        return true;
                    }
                })
                .build();
        result.updateItem(item1);
        result.updateItem(item2);

        CardView delhicard= findViewById(R.id.delhi);
        CardView bangalorecard= findViewById(R.id.bangalore);
        CardView hyderabadcard= findViewById(R.id.hyderabad);
        CardView mumbaicard= findViewById(R.id.mumbai);
        CardView kolkatacard= findViewById(R.id.kolkata);
        CardView chennaicard= findViewById(R.id.chennai);

        delhicard.setOnClickListener(this);
        hyderabadcard.setOnClickListener(this);
        kolkatacard.setOnClickListener(this);
        bangalorecard.setOnClickListener(this);
        mumbaicard.setOnClickListener(this);
        chennaicard.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.mumbai:
                startActivity(new Intent(MainActivity.this,LoadingScreenMumbai.class));
                break;
            case R.id.delhi:
                startActivity(new Intent(MainActivity.this,LoadingScreenDelhi.class));
                break;
            case R.id.kolkata:
                startActivity(new Intent(MainActivity.this,LoadingScreenKolkata.class));
                break;
            case R.id.bangalore:
                startActivity(new Intent(MainActivity.this,LoadingActivitybangalore.class));
                break;
            case R.id.hyderabad:
                startActivity(new Intent(MainActivity.this,LoadingScreenHyderabad.class));
                break;
            case R.id.chennai:
                startActivity(new Intent(MainActivity.this,LoadingScreenChennai.class));
                break;


        }
    }
}
