package com.dakshin.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class DisplayAllCrops extends AppCompatActivity {

    Spinner placeSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_all_crops);
        final Spinner districtSpinner=findViewById(R.id.select_district_spinner);
        Spinner cropSpinner=findViewById(R.id.select_crop_spinner);
        placeSpinner=findViewById(R.id.select_place_spinner);
        final String[] districts=getResources().getStringArray(R.array.list_of_districts);
        final String[] crops=getResources().getStringArray(R.array.crop_names);
        ArrayAdapter<String> districtAdapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,districts);
        ArrayAdapter<String> cropsAdapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,crops);
        districtSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0)
                    return;
                populateThirdSpinner(districts[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        districtSpinner.setAdapter(districtAdapter);
        cropSpinner.setAdapter(cropsAdapter);

    }

    private void populateThirdSpinner(String district) {
        String places[];
        switch (district)
        {
            case "Kancheepuram":
                places=getResources().getStringArray(R.array.Kancheepuram_places);
                break;
            case "Kanyakumari":
                places=getResources().getStringArray(R.array.Kanyakumari_places);
                break;
            case "Vellore":
                places=getResources().getStringArray(R.array.Vellore_places);
                break;
            case "Salem":
                places=getResources().getStringArray(R.array.Salem_places);
                break;
            case "Trichy":
                places=getResources().getStringArray(R.array.Tiruchirapalli_places);
                break;
            case "Madurai":
                places=getResources().getStringArray(R.array.Madurai_places);
                break;
            case "Coimbatore":
                places=getResources().getStringArray(R.array.Coimbatore_places);
                break;
            case "Sivagangai":
                places=getResources().getStringArray(R.array.Sivagangai_places);
                break;
            case "Thanjavur":
                places=getResources().getStringArray(R.array.Thanjavur_places);
                break;
            case "Thirunelveli":
                places=getResources().getStringArray(R.array.Thirunelveli_places);
                break;
            default:
                places=new String[]{"ERROR!"};
        }
        ArrayAdapter<String> placesAdapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,places);
        placeSpinner.setAdapter(placesAdapter);
    }
}
