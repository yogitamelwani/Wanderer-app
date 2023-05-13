package com.example.wanderer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class trip_package extends AppCompatActivity {
    ImageButton menu;
    Button book,book2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_package);
        menu=(ImageButton) findViewById(R.id.Bmenu);
        book=(Button) findViewById(R.id.button);
        book2=(Button) findViewById(R.id.button2);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(trip_package.this, com.example.wanderer.menu.class);
                startActivity(intent);
                finish();
            }
        });

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(trip_package.this,summary.class);
                startActivity(intent);
                finish();
            }
        });
        book2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(trip_package.this,summary.class);
                startActivity(intent);
                finish();
            }
        });
    }
}