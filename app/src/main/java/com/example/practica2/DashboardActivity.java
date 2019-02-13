package com.example.practica2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }

    public void buttonCallback(View v){
        int id = v.getId();
        Intent intent;
        if(id == R.id.about){
            intent = new Intent(getApplicationContext(),AboutActivity.class);
        }else if(id == R.id.favQ){
            intent =new Intent(getApplicationContext(),FavouriteActivity.class);
        }else if(id == R.id.getQ){
            intent =new Intent(getApplicationContext(),QuotationActivity.class);
        }else {
            intent =new Intent(getApplicationContext(),SettingsActivity.class);
        }
        startActivity(intent);
    }
}
