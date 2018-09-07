package com.dakshin.sqlite;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

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
        final TextView sratehead=findViewById(R.id.seedrateheading);
        final TextView spacinghead=findViewById(R.id.spacingheading);
        final TextView sratetview=findViewById(R.id.seedratetview);
        final TextView spacingview=findViewById(R.id.spacingtview);
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
        cropSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String srate="";
                String spacing="";
                Resources res=getResources();
                if(i==0)
                    return;
                Log.d("tag","position = "+i);
                Log.d("tag","crop = "+crops[i]);
                switch(crops[i])
                {
                    case "Paddy":
                        srate=res.getString(R.string.paddysrate);
                        spacing=res.getString(R.string.paddyspcing);
                        break;
                    case "Maize":
                        srate=res.getString(R.string.maizesrate);
                        spacing=res.getString(R.string.maizespacing);
                        break;
                    case "Cholam":
                        srate=res.getString(R.string.cholamsrate);
                        spacing=res.getString(R.string.cholamspacing);

                        break;
                    case "Total Pulses":
                        srate=res.getString(R.string.totalpulsesrate);
                        spacing=res.getString(R.string.totalpulsespacing);
                        break;
                    case "Sugarcane":
                        spacing=res.getString(R.string.sugarcanespacing);
                        srate=res.getString(R.string.sugarcanesrate);
                        break;
                    case "Cotton":
                        spacing=res.getString(R.string.cottonspacing);
                        srate=res.getString(R.string.cottonsrate);
                        break;
                    case "Groundnut":
                        spacing=res.getString(R.string.groundnutspacing);
                        srate=res.getString(R.string.groundnutsrate);
                        break;
                    case "Chillies":
                        spacing=res.getString(R.string.chilliespacing);
                        srate=res.getString(R.string.chilliesrate);
                        break;
                    case "Banana":
                        spacing=res.getString(R.string.bananaspacing);
                        srate=res.getString(R.string.bananasrate);
                        break;
                    default:
                }
                    sratetview.setText(srate);
                    spacingview.setText(spacing);

                    sratehead.setVisibility(TextView.VISIBLE);
                    spacinghead.setVisibility(View.VISIBLE);
                    sratetview.setVisibility(TextView.VISIBLE);
                    spacingview.setVisibility(TextView.VISIBLE);
                }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
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
