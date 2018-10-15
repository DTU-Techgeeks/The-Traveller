package com.example.android.thetraveller.Travel;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.android.thetraveller.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.android.thetraveller.Utils.Constants.API_LINK_V2;
import static com.example.android.thetraveller.Utils.Constants.USER_TOKEN;

public class HotelActivity extends AppCompatActivity //implements View.OnClickListener
                                                       {

    private GridView hotel_list;
    private TextView select_city;
    private LottieAnimationView animation_view;
    private TextView text_view;
    private LinearLayout layout;

    private Handler mHandler;
    private String mToken;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_hotel);

        hotel_list = findViewById(R.id.hotel_list);
        select_city = findViewById(R.id.select_city);
        animation_view = findViewById(R.id.animation_view);
        text_view = findViewById(R.id.text_view);
        layout = findViewById(R.id.layout);

        mHandler = new Handler(Looper.getMainLooper());
        SharedPreferences mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mToken = mSharedPreferences.getString(USER_TOKEN, null);

//        fetchCitiesList();

//        setTitle("Hotels");

//        select_city.setOnClickListener(this);

//        Objects.requireNonNull(getSupportActionBar()).setHomeButtonEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getItemId() == android.R.id.home)
//            finish();
//        return super.onOptionsItemSelected(item);
//    }
//
//    /**
//     * Calls API to get hotel list
//     */
//    private void getHotelList(String latitude, String longitude) {
//
//        String uri = API_LINK_V2 + "get-places/" + latitude + "/" + longitude + "/accommodation";
//
//        Log.v("EXECUTING", uri);
//
//        //Set up client
//        OkHttpClient client = new OkHttpClient();
//        //Execute request
//        Request request = new Request.Builder()
//                .header("Authorization", "Token " + mToken)
//                .url(uri)
//                .build();
//        //Setup callback
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                Log.e("Request Failed", "Message : " + e.getMessage());
//                mHandler.post(() -> networkError());
//            }
//
//            @Override
//            public void onResponse(Call call, final Response response) throws IOException {
//                final String res = Objects.requireNonNull(response.body()).string();
//                Log.v("RESPONSE", res + " ");
//                mHandler.post(() -> {
//                    if (response.isSuccessful() && response.body() != null) {
//                        try {
//                            JSONArray feedItems = new JSONArray(res);
//                            Log.v("response", feedItems + " ");
//                            layout.setVisibility(View.VISIBLE);
//                            animation_view.setVisibility(View.GONE);
//                            text_view.setVisibility(View.GONE);
//                            if (feedItems.length() > 0) {
//                                hotel_list.setAdapter(new HotelsAdapter(getBaseContext(), feedItems));
//                            } else {
//                                noResults();
//                            }
//                        } catch (JSONException e1) {
//                            e1.printStackTrace();
//                            networkError();
//                        }
//                    } else {
//                        networkError();
//                    }
//                });
//            }
//        });
//    }
//
//    /**
//     * Fetches the list cities from server
//     */
//    private void fetchCitiesList() {
//
//        String uri = API_LINK_V2 + "get-all-cities/10";
//        Log.v("EXECUTING", uri);
//
//        //Set up client
//        OkHttpClient client = new OkHttpClient();
//        //Execute request
//        final Request request = new Request.Builder()
//                .header("Authorization", "Token " + mToken)
//                .url(uri)
//                .build();
//        //Setup callback
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                Log.e("Request Failed", "Message : " + e.getMessage());
//                mHandler.post(() -> networkError());
//            }
//
//            @Override
//            public void onResponse(Call call, final Response response) {
//                mHandler.post(() -> {
//                    if (response.isSuccessful()) {
//                        try {
//                            String res = response.body().string();
//                            Log.v("RESULT", res);
//                            JSONArray ar = new JSONArray(res);
//                            for (int i = 0; i < ar.length(); i++) {
//                                mSearchCities.add(new CitySearchModel(
//                                        ar.getJSONObject(i).getString("city_name"),
//                                        ar.getJSONObject(i).optString("image"),
//                                        ar.getJSONObject(i).getString("id")));
//                            }
//                        } catch (JSONException | IOException e) {
//                            e.printStackTrace();
//                            networkError();
//                            Log.e("ERROR", "Message : " + e.getMessage());
//                        }
//                    } else {
//                        Log.e("ERROR", "Network error");
//                        networkError();
//                    }
//                });
//            }
//        });
//
//    }
//
//    @Override
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.select_city:
//                new CitySearchDialogCompat(getBaseContext(), getString(R.string.search_title),
//                        getString(R.string.search_hint), null, mSearchCities,
//                        (SearchResultListener<CitySearchModel>) (dialog, item, position) -> {
//                            String selectedCity = item.getId();
//                            selectCity.setText(String.format(getString(R.string.showing_hotels), item.getName()));
//                            dialog.dismiss();
//                            getCityInfo(selectedCity);
//                        }).show();
//                hotel_list.setAdapter(null);
//                break;
//        }
//    }
}
