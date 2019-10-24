package com.example.leasemasteronboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUp();
    }

    public void setUp(){

        //landingPage

        Button landingPage = findViewById(R.id.landingPage);
        landingPage.setOnClickListener(view ->{
            startActivity(new Intent(this, LandingPageLogedOut.class));
        });

        Button next = findViewById(R.id.next);
        next.setOnClickListener(view ->{
            startActivity(new Intent(this, Signup.class));
        });

        Button next1 = findViewById(R.id.next1);
        next1.setOnClickListener(view ->{
            startActivity(new Intent(this, LogIn.class));
        });

        Button next2 = findViewById(R.id.next2);
        next2.setOnClickListener(view ->{
            startActivity(new Intent(this, SignupFbGoogle.class));
        });

        Button verification = findViewById(R.id.verification);
        verification.setOnClickListener(view ->{
            startActivity(new Intent(this, Verification.class));
        });

        Button propertyDetails = findViewById(R.id.propertyDetails);
        propertyDetails.setOnClickListener(view -> {
            startActivity(new Intent(this, PropertyDetails.class));
        });
        Button saveToList = findViewById(R.id.saveToList);
        saveToList.setOnClickListener(view -> {
            startActivity(new Intent(this, SaveToList.class));
        });


    }
}
