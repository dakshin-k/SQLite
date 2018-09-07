package com.dakshin.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Soildetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soildetails);
        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        String name = (String) bd.get("Soil_type");
        ListView listview;
        listview=findViewById(R.id.Display_Soildata);
        final String[] array;
        ArrayAdapter<String> adapter;
        switch (name) {
            case "Red":
                array = getResources().getStringArray(R.array.Red);
                break;
            case "Black":
                array = getResources().getStringArray(R.array.Black);
                break;
            case "Coastal":
                array = getResources().getStringArray(R.array.Coastal);
                break;
            case "Laterite":
                array = getResources().getStringArray(R.array.Laterite);
                break;
            default:
                array = new String[]{"ERROR!"};


        }
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,array);
        listview.setAdapter(adapter);


    }
}
