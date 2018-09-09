package com.dakshin.sqlite;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class FertilizerDisease extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fertilizer_disease);
        //todo delete cholam and total pulses from arrraydiseases
        //todo may need to change the id of the crop spinner; it's duplicate
        Spinner cropSpinner=findViewById(R.id.select_crop_spinner);
        Spinner diseaseSpinner=findViewById(R.id.select_disease_spinner);
        final String tempcrops[]=getResources().getStringArray(R.array.ltd_crop_names);

        ArrayAdapter<String> cropsAdapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,tempcrops);
        //remove cholam and total pulses from the diseases
        cropSpinner.setAdapter(cropsAdapter);
        cropSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i!=0)
                    populateDiseaseSpinner(tempcrops[i],i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void populateDiseaseSpinner(String tempcrop,final int i) {
        String[] diseases;
        switch(tempcrop)
        {
            case "Paddy":
                diseases=getResources().getStringArray(R.array.paddydiseases);
                break;
            case "Maize":
                diseases=getResources().getStringArray(R.array.maizediseases);
                break;
            case "Sugarcane":
                diseases=getResources().getStringArray(R.array.sugarcanediseases);
                break;
            case "Cotton":
                diseases=getResources().getStringArray(R.array.cottondiseases);
                break;
            case "Groundnut":
                diseases=getResources().getStringArray(R.array.groundnutdiseases);
                break;
            case "Chillies":
                diseases=getResources().getStringArray(R.array.chilliesdiseases);
                break;
            case "Banana":
                diseases=getResources().getStringArray(R.array.bananadiseases);
                break;
            default:
                diseases=new String[]{""};
        }
        Spinner diseaseSpinner=findViewById(R.id.select_disease_spinner);
        ArrayAdapter<String>diseaseAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,diseases);
        diseaseSpinner.setAdapter(diseaseAdapter);
        TextView view=findViewById(R.id.disease_cure_header);
        view.setVisibility(TextView.VISIBLE);
        Button button=findViewById(R.id.button_open_disease_url);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String url=getResources().getStringArray(R.array.disease_links)[i];
               Intent intent=new Intent(Intent.ACTION_VIEW);
               intent.setData(Uri.parse(url));
               startActivity(intent);
            }
        });
        button.setVisibility(Button.VISIBLE);
    }
}
