package com.dakshin.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class button6 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button6);
        final Spinner cropSpinner=findViewById(R.id.Crop);
        final Spinner districtSpinner=findViewById(R.id.select_district_spinner);
        final String districts[]=getResources().getStringArray(R.array.list_of_districts);
        final String[] crops=getResources().getStringArray(R.array.crop_names);
        ArrayAdapter<String> cropsAdapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,crops);
        ArrayAdapter<String>districtAdapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,districts);
        districtSpinner.setAdapter(districtAdapter);
        cropSpinner.setAdapter(cropsAdapter);
        cropSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0)
                    return;
                populateListView(crops[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        districtSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i==0)
                    return;
                String name=districts[i];
                //difference between names on database and on weather server
                if (name.equals("Sivagangai"))
                    name="Sivaganga";
                else if(name.equals("Thirunelveli"))
                    name="Tirunelveli";
                final String tname=name;
                String url="http://api.apixu.com/v1/forecast.json?key=18e87376dc4d492d965121840180709&q="+name; //site to download weather details from
                final TextView weather=findViewById(R.id.weather_details);
                weather.setText("Please wait...");
               // final String weatherresult;
                StringRequest request = new StringRequest(Request.Method.GET,
                        url,
                        new Response.Listener<String>() {

                            @Override

                            public void onResponse(String response) {
                                try {
                                    Log.d("tag","result recieved"+response);
                                    String weatherresult="";
                                        JSONObject res=new JSONObject(response);
                                        weatherresult+="Weather in "+tname+":\n";
                                        JSONObject current=res.getJSONObject("current");
                                        weatherresult+="Temperature: "+current.getDouble("temp_c")+" Celsius\n";
                                        weatherresult+="Precipitation: "+current.getInt("precip_mm")+" mm\n";
                                        weatherresult+="Humidity: "+current.getInt("humidity")+"\n";
                                        weatherresult+="Current Status: "+current.getJSONObject("condition").getString("text")+"\n\n";

                                        weatherresult+="Forecast:\n";
                                        JSONObject forecast=res.getJSONObject("forecast");
                                        Log.d("tag","forecast object recieved");
                                        JSONArray fd=forecast.getJSONArray("forecastday");
                                        Log.d("tag","forecastday recieved");
                                        JSONObject forecast2=fd.getJSONObject(0).getJSONObject("day");
                                        Log.d("tag","done/n"+forecast2.toString());
                                        weatherresult+="Temperature: "+forecast2.getDouble("mintemp_c")+" to "+forecast2.getDouble("maxtemp_c")+" Celsius\n";
                                        weatherresult+="Precipitation: "+forecast2.getInt("totalprecip_mm")+" mm\n" ;
                                        weatherresult+="Average Humidity: "+forecast2.getInt("avghumidity")+"\n";
                                        weatherresult+="Status: "+forecast2.getJSONObject("condition").getString("text");
                                        weather.setText(weatherresult);

                                    }
                                catch (Exception ex){
                                    Toast.makeText(button6.this, "JSON Exception caught!", Toast.LENGTH_SHORT).show();
                                    Log.d("tag","JSON Exception caught");
                                    ex.printStackTrace();
                                }
                            }

                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.d("tag","HTTP Error raised"+error.toString());
                            }
                        }
                );

                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

                requestQueue.add(request);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

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
