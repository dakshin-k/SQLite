package com.dakshin.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SoilTypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soil_type);
        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        String name = (String) bd.get("District");
        ListView listview;
        listview=findViewById(R.id.Display_crops);
        final String[] array;
        ArrayAdapter<String> adapter;
        switch (name) {
            case "Kancheepuram":
                array = getResources().getStringArray(R.array.Kanchipuram_crops);
                break;
            case "Kanyakumari":
                array = getResources().getStringArray(R.array.Kanykuamari_Crops);
                break;
            case "Vellore":
                array = getResources().getStringArray(R.array.Vellore_Crops);
                break;
            case "Salem":
                array = getResources().getStringArray(R.array.Salem_Crops);
                break;
            case "Trichy":
                array = getResources().getStringArray(R.array.Trichy_Crops);
                break;
            case "Madurai":
                array = getResources().getStringArray(R.array.Madurai_Crops);
                break;
            case "Coimbatore":
                array = getResources().getStringArray(R.array.Coimbatore_Crops);
                break;
            case "Sivagangai":
                array = getResources().getStringArray(R.array.Sivagangai_Crops);
                break;
            case "Thanjavur":
                array = getResources().getStringArray(R.array.Tanjore_Crops);
                break;
            case "Thirunelveli":
                array = getResources().getStringArray(R.array.Tirunelveli_crops);
                break;
            default:
                array = new String[]{"ERROR!"};


        }
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,array);
        listview.setAdapter(adapter);
    }
}
