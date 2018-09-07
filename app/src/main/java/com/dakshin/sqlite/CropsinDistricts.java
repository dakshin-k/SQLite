package com.dakshin.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class CropsinDistricts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cropsin_districts);
        Spinner cropSpinner=findViewById(R.id.button3_select_crop_spinner);
        final String[] crops=getResources().getStringArray(R.array.crop_names);
        ArrayAdapter<String> cropsAdatper=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,crops);
        cropSpinner.setAdapter(cropsAdatper);
        final ListView listView=findViewById(R.id.crop_place_listview);
        cropSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0)
                    return;
                String[] places;
                switch(crops[i])
                {
                    case "Paddy":
                        places=getResources().getStringArray(R.array.paddyplaces);
                        break;
                    case "Maize":
                        places=getResources().getStringArray(R.array.maizelist);
                        break;
                    case "Cholam":
                        places=getResources().getStringArray(R.array.cholamlist);
                        break;
                    case "Total Pulses":
                        places=getResources().getStringArray(R.array.totalpulseslist);
                        break;
                    case "Sugarcane":
                        places=getResources().getStringArray(R.array.sugarcanelist);
                        break;
                    case "Cotton":
                        places=getResources().getStringArray(R.array.cottonlist);
                        break;
                    case "Groundnut":
                        places=getResources().getStringArray(R.array.groundnutlist);
                        break;
                    case "Chillies":
                        places=getResources().getStringArray(R.array.chillieslist);
                        break;
                    case "Banana":
                        places=getResources().getStringArray(R.array.bananalist);
                        break;
                    default:
                        places=new String[]{""};
                }
                ArrayAdapter<String>adapter =new ArrayAdapter<String>(CropsinDistricts.this,android.R.layout.simple_list_item_1,places);
                listView.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
