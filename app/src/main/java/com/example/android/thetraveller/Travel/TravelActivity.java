package com.example.android.thetraveller.Travel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.example.android.thetraveller.Adapters.CardViewOptionsAdapter;
import com.example.android.thetraveller.Models.CardItemEntity;
import com.example.android.thetraveller.R;

import java.util.ArrayList;
import java.util.List;

public class TravelActivity extends AppCompatActivity implements CardViewOptionsAdapter.OnItemClickListener {

    RecyclerView mTravelOptionsRecycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);


        List<CardItemEntity> cardEntities = getTravelItems();


        mTravelOptionsRecycleView = findViewById(R.id.travel_options_recycle_view);
        CardViewOptionsAdapter cardViewOptionsAdapter = new CardViewOptionsAdapter(this, cardEntities);

        mTravelOptionsRecycleView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mTravelOptionsRecycleView.setItemAnimator(new DefaultItemAnimator());
        mTravelOptionsRecycleView.setAdapter(cardViewOptionsAdapter);
    }

    @Override
    public void onItemClick(int position) {

        switch (position) {
            case 0:
                startActivity(new Intent(getBaseContext(),HotelActivity.class));
                break;
            case 1:
//                i = ShoppingCurrentCityActivity.getStartIntent(mActivity);
                startActivity(new Intent(getBaseContext(),ShoppingActivity.class));
                break;
            case 2:
//                i = MapViewRealTimeActivity.getStartIntent(mActivity);
                startActivity(new Intent(getBaseContext(),MapsActivity.class));
                break;
        }
    }
    private List<CardItemEntity> getTravelItems() {
        List<CardItemEntity> cardEntities = new ArrayList<>();
        cardEntities.add(
                new CardItemEntity(
                        getResources().getDrawable(R.drawable.hotel2),
                        getResources().getString(R.string.hotel)));
        cardEntities.add(
                new CardItemEntity(
                        getResources().getDrawable(R.drawable.shop),
                        getResources().getString(R.string.online_Shopping)));
        cardEntities.add(
                new CardItemEntity(
                        getResources().getDrawable(R.drawable.location),
                        getResources().getString(R.string.real_time_locator)));
        return cardEntities;
    }
}
