package com.example.practica2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class QuotationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotation);
        TextView tv = findViewById(R.id.textViewInScroolView);
        tv.setText(getString(R.string.press_refresh,getString(R.string.name)));
    }

    public void imageButtonListener(){
        TextView tv = findViewById(R.id.textViewInScroolView);
        tv.setText(getString(R.string.sample_quotation));
        tv = findViewById(R.id.textViewAuthor);
        tv.setText(getString(R.string.sample_author));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater m = getMenuInflater();
        m.inflate(R.menu.menu_quotation,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.newQuote: {imageButtonListener();
                                return true;}
            case R.id.newFav:return true;
            default: return super.onOptionsItemSelected(item);
        }
    }
}
