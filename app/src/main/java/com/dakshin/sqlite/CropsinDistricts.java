package com.dakshin.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.Spinner;

public class CropsinDistricts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cropsin_districts);
        Spinner cropSpinner=findViewById(R.id.button3_select_crop_spinner);
        String[] crops=getResources().getStringArray(R.array.crop_names);
        ArrayAdapter<String> cropsAdatper=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,crops);
        cropSpinner.setAdapter(cropsAdatper);
        cropSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0)
                    return;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
