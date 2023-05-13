package com.example.wanderer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class booking_confirmed extends AppCompatActivity {
    Button home;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_confirmed);

        home=(Button) findViewById(R.id.home);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {

            if (ContextCompat.checkSelfPermission(booking_confirmed.this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED)
            {

                ActivityCompat.requestPermissions(booking_confirmed.this, new String[]{Manifest.permission.POST_NOTIFICATIONS}, 101);
}
            }

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeNotification();
                Intent intent=new Intent(booking_confirmed.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
    public void makeNotification() {

            String chanelID="CHANNEL ID_NOTIFICATION";

            NotificationCompat.Builder builder =

                    new NotificationCompat.Builder(getApplicationContext(),chanelID);

            builder.setSmallIcon(R.drawable.ic_notifications) .setContentTitle("Wanderer")
                    .setContentText("Your Booking has Been Confirmed. Click here to check invoice.")
                    .setAutoCancel(true)
                    .setPriority (NotificationCompat.PRIORITY_DEFAULT);

            Intent intent = new Intent(getApplicationContext(), notificationActivity.class);

            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            intent.putExtra("data", "Time to Pack Your Bags");

            PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_MUTABLE);

            builder.setContentIntent(pendingIntent);
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);


            NotificationChannel notificationChannel;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationChannel = notificationManager.getNotificationChannel(chanelID);

                if (notificationChannel == null) {

                    int importance = NotificationManager.IMPORTANCE_HIGH;
                    notificationChannel=new NotificationChannel(chanelID,"Some description", importance);
                    notificationChannel.setLightColor(Color.GREEN);
                    notificationChannel.enableVibration(true);
                    notificationManager.createNotificationChannel(notificationChannel);

                }
            }
            notificationManager.notify(0,builder.build());
        }
    }
