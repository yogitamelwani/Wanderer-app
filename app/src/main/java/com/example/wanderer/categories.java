package com.example.wanderer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;

import java.util.ArrayList;

public class categories extends AppCompatActivity {
    GridView coursesGV;
    ImageButton menu;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);



        menu=(ImageButton) findViewById(R.id.hamburger);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(categories.this, com.example.wanderer.menu.class);
                startActivity(intent);
                finish();
            }
        });

                coursesGV = findViewById(R.id.idGVcourses);
                ArrayList<CourseModel> courseModelArrayList = new ArrayList<CourseModel>();

                courseModelArrayList.add(new CourseModel("Beaches", R.drawable.img));
                courseModelArrayList.add(new CourseModel("Mountains", R.drawable.mountains));
                courseModelArrayList.add(new CourseModel("Heritage", R.drawable.heritage));
                courseModelArrayList.add(new CourseModel("Pilgrimage", R.drawable.img_3));
        courseModelArrayList.add(new CourseModel("Honeymoon", R.drawable.img_1));
        courseModelArrayList.add(new CourseModel("Romantic", R.drawable.img_2));
        courseModelArrayList.add(new CourseModel("Adventure", R.drawable.img_4));
        courseModelArrayList.add(new CourseModel("Trekking", R.drawable.img_5));

                CourseGVAdapter adapter = new CourseGVAdapter(this, courseModelArrayList);
                coursesGV.setAdapter(adapter);
            }
        }


