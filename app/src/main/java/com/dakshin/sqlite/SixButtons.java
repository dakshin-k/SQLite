package com.dakshin.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SixButtons extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six_buttons);
    }

    public void displayAllDistricts(View v) {
        Intent intent=new Intent(SixButtons.this,DisplayAllDistricts.class);
        startActivity(intent);
    }
}
