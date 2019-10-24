package com.example.leasemasteronboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SaveToList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.save_to_list);

        TextView createNewList_Label = findViewById(R.id.createNewList_Label);
        createNewList_Label.setOnClickListener(view -> {
            startActivity(new Intent(this, CreateList.class));
        });
    }
}
