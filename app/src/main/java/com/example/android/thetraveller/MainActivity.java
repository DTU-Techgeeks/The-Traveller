package com.example.android.thetraveller;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbarMain);
        toolbar.setTitle("The Traveller");

        ProfileDrawerItem profileDrawerItem = new ProfileDrawerItem().withTextColor(Color.BLACK).withName("XYZ").withEmail("XYZ@gmail.com").withIcon(getResources().getDrawable(R.mipmap.ic_launcher));
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.earth)
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

        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("Destination").withTextColor(Color.BLACK);
        PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(1).withName("Travel").withTextColor(Color.BLACK);
        PrimaryDrawerItem item3 = new PrimaryDrawerItem().withIdentifier(1).withName("My Trips").withTextColor(Color.BLACK);
        PrimaryDrawerItem item4 = new PrimaryDrawerItem().withIdentifier(1).withName("My Friends").withTextColor(Color.BLACK);
        PrimaryDrawerItem item5 = new PrimaryDrawerItem().withIdentifier(1).withName("Utilities").withTextColor(Color.BLACK);

        PrimaryDrawerItem item6 = new PrimaryDrawerItem().withIdentifier(2).withName("About us");
        PrimaryDrawerItem item7 = new PrimaryDrawerItem().withIdentifier(2).withName("Sign Out");
        PrimaryDrawerItem item8 = new PrimaryDrawerItem().withIdentifier(2).withName("Settings");

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
                            case 0 : startActivity(new Intent(getBaseContext(),MainActivity.class));
                                break;
                            case 1 :
                                startActivity(new Intent(getBaseContext(),SettingsActivity.class));
                                break;
                        }
                        return true;
                    }
                })
                .build();
        result.updateItem(item1);
        result.updateItem(item2);
    }
}
