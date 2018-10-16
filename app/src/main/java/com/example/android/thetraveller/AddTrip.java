package com.example.android.thetraveller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class AddTrip extends AppCompatActivity {
    EditText etname;
    EditText etcity;
    EditText etdate;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trip);
        etname=findViewById(R.id.etname);
        etcity=findViewById(R.id.etcity);
        etdate=findViewById(R.id.etdate);
        btnAdd=findViewById(R.id.btnadd);
        final ListView listView=findViewById(R.id.listView);
        final List<UserModel> users=new ArrayList<>();

        final CustomAdapter adapter=new CustomAdapter(this,users);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                UserModel model=users.get(i);

                if(model.isSelected())
                    model.setSelected(false);
                else
                    model.setSelected(true);

                users.set(i,model);

                adapter.updateRecords(users);

            }
        });
//        etdate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//        Calendar now = Calendar.getInstance();
//        DatePickerDialog dateOfBirthPicker = DatePickerDialog.newInstance(
//                AddTrip.this,
//                now.get(Calendar.YEAR),
//                now.get(Calendar.MONTH),
//                now.get(Calendar.DAY_OF_MONTH)
//        );
//
//       // dateOfBirthPicker.showYearPickerFirst(true);
//        dateOfBirthPicker.show(getFragmentManager(), "DATE OF BIRTH PICKER");
//        etdate.setText(Calendar.DAY_OF_MONTH+"/"+Calendar.MONTH+"/"+Calendar.YEAR);
//            }
//        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                users.add(new UserModel(false,etname.getText().toString().trim()+" trip  planned to "+etcity.getText().toString().trim()+" on "+etdate.getText().toString().trim()));
                listView.setAdapter(adapter);
                etname.setText("");  etcity.setText(""); etdate.setText(""); adapter.updateRecords(users);

            }
        });

    }

//    @Override
//    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
//
//    }
}

