package com.dakshin.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class DisplayAllCrops extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_all_crops);
        Spinner districtSpinner=findViewById(R.id.select_district_spinner);
        Spinner cropSpinner=findViewById(R.id.select_crop_spinner);
        String[] districts=getResources().getStringArray(R.array.list_of_districts);
        String[] crops=getResources().getStringArray(R.array.crop_names);
        ArrayAdapter<String> districtAdapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,districts);
        ArrayAdapter<String> cropsAdapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,crops);
        districtSpinner.setAdapter(districtAdapter);
        cropSpinner.setAdapter(cropsAdapter);

    }
}
