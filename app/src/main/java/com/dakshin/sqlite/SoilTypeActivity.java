package com.dakshin.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SoilTypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soil_type);
        ListView listview;
        listview=findViewById(R.id.Display_crops);
        final String[] array = getResources().getStringArray(R.array.soil);;
        ArrayAdapter<String> adapter;

        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,array);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name=array[i];
                Intent intent = new Intent(SoilTypeActivity.this,Soildetails.class);
                intent.putExtra("Soil_type",name);
                startActivity(intent );
            }
        });

    }
}
