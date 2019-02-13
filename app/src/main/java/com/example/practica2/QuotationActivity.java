package com.example.practica2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class QuotationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotation);
        TextView tv = findViewById(R.id.textViewInScroolView);
        tv.setText(getString(R.string.press_refresh,getString(R.string.name)));
    }

    public void imageButtonListener(View v){
        TextView tv = findViewById(R.id.textViewInScroolView);
        tv.setText(getString(R.string.sample_quotation));
        tv = findViewById(R.id.textViewAuthor);
        tv.setText(getString(R.string.sample_author));
    }
}
