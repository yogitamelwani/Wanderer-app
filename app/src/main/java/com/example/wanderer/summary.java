package com.example.wanderer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class summary extends AppCompatActivity {
    ImageButton menu;
    Button book;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        menu=(ImageButton) findViewById(R.id.Bmenu);
        book=(Button) findViewById(R.id.Bbook);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(summary.this, com.example.wanderer.menu.class);
                startActivity(intent);
                finish();
            }
        });

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(summary.this,booking_confirmed.class);
                startActivity(intent);
                finish();
            }
        });
    }
}