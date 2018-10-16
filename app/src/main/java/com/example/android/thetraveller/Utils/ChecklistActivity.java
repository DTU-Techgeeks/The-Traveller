package com.example.android.thetraveller.Utils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.android.thetraveller.R;

import java.util.ArrayList;
import java.util.List;

public class ChecklistActivity extends AppCompatActivity {
    EditText itemAdd;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checklist);
        itemAdd=findViewById(R.id.etadd);
        btnAdd=findViewById(R.id.btnadd);

        final ListView listView=findViewById(R.id.listView);
        final List<com.example.android.thetraveller.UserModel> users=new ArrayList<>();
        users.add(new com.example.android.thetraveller.UserModel(false,"Charger"));
        users.add(new com.example.android.thetraveller.UserModel(false,"Toothbrush"));
        users.add(new com.example.android.thetraveller.UserModel(false,"Tooth paste"));
        users.add(new com.example.android.thetraveller.UserModel(false,"Towel"));
        users.add(new com.example.android.thetraveller.UserModel(false,"Clothes"));

        final com.example.android.thetraveller.CustomAdapter adapter=new com.example.android.thetraveller.CustomAdapter(this,users);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                com.example.android.thetraveller.UserModel model=users.get(i);

                if(model.isSelected())
                    model.setSelected(false);
                else
                    model.setSelected(true);

                users.set(i,model);

                adapter.updateRecords(users);

            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                SparseBooleanArray positionChecker=listView.getCheckedItemPositions();
                int count=listView.getCount();
                for(int item=count-1;item>=0;item--)
                {
                    if(positionChecker.get(item))
                    {
                        users.remove(item);
                        positionChecker.clear();
                        adapter.notifyDataSetChanged();
                        listView.setAdapter(adapter); // adapter.remove(listView.get(item)); //(listView,item);
                    }
                }

                return false;
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                users.add(new com.example.android.thetraveller.UserModel(false,itemAdd.getText().toString().trim()));
                listView.setAdapter(adapter);
                itemAdd.setText("");  adapter.updateRecords(users);
            }
        });
    }
}
