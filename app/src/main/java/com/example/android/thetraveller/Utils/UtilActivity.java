package com.example.android.thetraveller.Utils;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.android.thetraveller.Adapters.CardViewOptionsAdapter;
import com.example.android.thetraveller.Models.CardItemEntity;
import com.example.android.thetraveller.R;

import java.util.ArrayList;
import java.util.List;

public class UtilActivity extends AppCompatActivity implements CardViewOptionsAdapter.OnItemClickListener {

    private RecyclerView mUtilityOptionsRecycleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_util);

        mUtilityOptionsRecycleView = findViewById(R.id.utility_options_recycle_view);

        List<CardItemEntity> cardEntities = getUtilityItems();

        CardViewOptionsAdapter cardViewOptionsAdapter = new CardViewOptionsAdapter(this, cardEntities);
        mUtilityOptionsRecycleView.setLayoutManager(new LinearLayoutManager(getBaseContext(),LinearLayoutManager.VERTICAL,false));
        mUtilityOptionsRecycleView.setItemAnimator(new DefaultItemAnimator());
        mUtilityOptionsRecycleView.setAdapter(cardViewOptionsAdapter);

    }

    @Override
    public void onItemClick(int position) {
        switch (position) {
            case 0:
                startActivity(new Intent(getBaseContext(),ChecklistActivity.class));
                break;
            case 1 :
                startActivity(new Intent(getBaseContext(),WeatherForecastActivity.class));
                break;
            case 2 :
                startActivity(new Intent(getBaseContext(),CompassActivity.class));
                break;
            case 3 :
                startActivity(new Intent(getBaseContext(),CurrencyActivity.class));
                break;
        }
    }

    private List<CardItemEntity> getUtilityItems() {
        List<CardItemEntity> cardEntities = new ArrayList<>();
        cardEntities.add(
                new CardItemEntity(
                        getResources().getDrawable(R.drawable.checklist2),
                        getResources().getString(R.string.text_checklist)));
        cardEntities.add(
                new CardItemEntity(
                        getResources().getDrawable(R.drawable.weather2),
                        getResources().getString(R.string.text_weather)));
        cardEntities.add(
                new CardItemEntity(
                        getResources().getDrawable(R.drawable.compass2),
                        getResources().getString(R.string.text_Compass)));
        cardEntities.add(
                new CardItemEntity(
                        getResources().getDrawable(R.drawable.currency),
                        getResources().getString(R.string.text_currency)));
        return cardEntities;
    }
}
