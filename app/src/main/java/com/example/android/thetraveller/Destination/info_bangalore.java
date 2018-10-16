package com.example.android.thetraveller.Destination;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import com.example.android.thetraveller.ExpandableListAdapter;
import com.example.android.thetraveller.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class info_bangalore extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String,List<String>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_bangalore);

        listView=(ExpandableListView) findViewById(R.id.lvExp);
        initData();
        listAdapter=new ExpandableListAdapter(this,listDataHeader,listHash);
        listView.setAdapter(listAdapter);
    }

    private void initData() {
        listDataHeader=new ArrayList<>();
        listHash=new HashMap<>();

        listDataHeader.add("History");
        listDataHeader.add("Tourism");
        listDataHeader.add("Culture");
        listDataHeader.add("Economy");
        listDataHeader.add("Education");

        List<String> history=new ArrayList<>();
        history.add("its history...");
        history.add("its history2...");
        List<String> tourism=new ArrayList<>();
        tourism.add("its Tourism...");
        List<String> culture=new ArrayList<>();
        culture.add("its culture...");
        List<String> economy=new ArrayList<>();
        economy.add("its economy...");
        List<String> education=new ArrayList<>();
        education.add("its education...");

        listHash.put(listDataHeader.get(0),history);
        listHash.put(listDataHeader.get(1),tourism);
        listHash.put(listDataHeader.get(2),culture);
        listHash.put(listDataHeader.get(3),economy);
        listHash.put(listDataHeader.get(4),education);

    }
}

