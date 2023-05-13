package com.example.wanderer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class trip_detail extends AppCompatActivity {
    ImageButton menu;
    Button book;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_detail);
        menu=(ImageButton) findViewById(R.id.Bmenu);
        book=(Button) findViewById(R.id.Bbook);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(trip_detail.this, com.example.wanderer.menu.class);
                startActivity(intent);
                finish();
            }
        });

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(trip_detail.this,summary.class);
                startActivity(intent);
                finish();
            }
        });
    }
}