package com.example.android.thetraveller.Adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.android.thetraveller.R;
import com.gustavofao.materialtabs.SlidingFragmentPagerAdapter;

public class TabAdapter extends SlidingFragmentPagerAdapter

{
    private Context context;

    private String[] titles = {
            "Contacts",
            "Favorites",
            "Groups",
    };

    private int[] icons = {
            R.drawable.earth,
            R.drawable.travel,
            R.drawable.onboard_page3
    };

    public TabAdapter(FragmentManager fm , Context context) {
        super(fm);
        this.context = context;
    }
    public TabAdapter(FragmentManager fm) {
        super(fm);

    }



    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public Drawable getPageDrawable(int position) {
        return context.getResources().getDrawable(icons[position]);
    }

    @Override
    public String getToolbarTitle(int position) {
        return titles[position];
    }

    @Override
    public Fragment getItem(int i) {
        return null;
    }
}
