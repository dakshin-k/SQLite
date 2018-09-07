package com.dakshin.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class button6 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button6);
        ArrayAdapter<String> adapter;
        final Spinner cropSpinner=findViewById(R.id.Crop);
        final String[] crops=getResources().getStringArray(R.array.crop_names);
        ArrayAdapter<String> cropsAdapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,crops);
        cropSpinner.setAdapter(cropsAdapter);
        cropSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0)
                    return;
                populateListView(crops[i]);
            }
        });
        }
        public void populateListView(String Crop_Name)
        {
            String[] array;
            ListView listView;
            listView = findViewById(R.id.Season);;
            switch (Crop_Name) {
                case "Maize":
                    array = getResources().getStringArray(R.array.Maize);
                    break;
                case "Paddy":
                    array = getResources().getStringArray(R.array.Paddy);
                    break;
                case "Chillies":
                    array = getResources().getStringArray(R.array.Chillies);
                    break;
                case "Banana":
                    array = getResources().getStringArray(R.array.Banana);
                    break;
                case "Total Pulses":
                    array = getResources().getStringArray(R.array.TotalPulses);
                    break;
                case "Cotton":
                    array = getResources().getStringArray(R.array.Cotton);
                    break;
                case "Sugarcane":
                    array = getResources().getStringArray(R.array.SugarCane);
                    break;
                case "Cholam":
                    array = getResources().getStringArray(R.array.Cholam);
                    break;
                case "Groundnut":
                    array = getResources().getStringArray(R.array.GroundNut);
                    break;
                default:
                    array = new String[]{"ERROR!"};


            }
            Adapter adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,array);
            listView.setAdapter((ListAdapter) adapter);

        }
}
