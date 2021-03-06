package com.dakshin.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DisplayAllDistricts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_all_districts);
        ListView listView=findViewById(R.id.districts_list_view);
        final String[] array=getResources().getStringArray(R.array.list_of_districts);
        ArrayAdapter<String> adapter;

        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,array);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name=array[i];
                Intent intent = new Intent(DisplayAllDistricts.this,Button2_CropActivity.class);
                intent.putExtra("District",name);
                startActivity(intent);
            }
        });
    }
}
