package com.example.leasemasteronboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class LandingPageLogedOut extends AppCompatActivity {

    private EditText searchProperty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_page_log_out);

        searchProperty = findViewById(R.id.searchProperty);

    }
}
