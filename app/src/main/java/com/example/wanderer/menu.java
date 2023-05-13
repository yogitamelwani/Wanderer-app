package com.example.wanderer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class menu extends AppCompatActivity {
    ImageButton close;
    TextView explore, categories, profile, settings;
    Button logout;
    String textname,textemail,email;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        close=findViewById(R.id.close);
        explore=findViewById(R.id.explore);
        categories=findViewById(R.id.categories);
        profile=findViewById(R.id.profile);
        settings=findViewById(R.id.settings);
        logout=findViewById(R.id.logout);
        SharedPreferences sharedPreferences = getSharedPreferences("MyAppName", MODE_PRIVATE);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        categories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), categories.class);
                startActivity(intent);
                finish();
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), profile.class);
                startActivity(intent);
                finish();
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), settings.class);
                startActivity(intent);
                finish();
            }
        });


        email=String.valueOf(sharedPreferences.getString("email",""));

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), login.class);
                startActivity(intent);
                finish();
                /*RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url = "http://192.168.1.8/programs/wanderer-android/logout.php";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if(response.equals("success")) {

                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                    editor.putString("logged", "");
                                    editor.putString("name", "");
                                    editor.putString("email", "");
                                    editor.putString("apikey", "");
                                    editor.apply();

                                    Intent intent = new Intent(getApplicationContext(), login.class);
                                    startActivity(intent);
                                    finish();
                                }
                                else{
                                    Toast.makeText(menu.this, response, Toast.LENGTH_SHORT).show();
                                }

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }) {
                    protected Map<String, String> getParams() {
                        Map<String, String> paramV = new HashMap<>();
                        paramV.put("email", email);
                        paramV.put("apikey", sharedPreferences.getString("apikey",""));
                        return paramV;
                    }
                };
                queue.add(stringRequest);

                 */
            }
        });
        

    }
}