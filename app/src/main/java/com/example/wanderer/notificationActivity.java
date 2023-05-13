package com.example.wanderer;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class notificationActivity extends AppCompatActivity {
    TextView tdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        tdata=findViewById(R.id.textViewData);
        String data= getIntent().getStringExtra("data");
        tdata.setText(data);
    }
}