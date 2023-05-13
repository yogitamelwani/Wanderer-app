package com.example.wanderer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText search;
    SharedPreferences sharedPreferences;
    ImageButton menu,mumbai,kolkata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        search=findViewById(R.id.search);
        menu=findViewById(R.id.hamburger);
        mumbai=findViewById(R.id.img_mumbai);
        kolkata=findViewById(R.id.img_kolkata);

        sharedPreferences = getSharedPreferences("MyAppName", MODE_PRIVATE);
        if (sharedPreferences.getString("logged", "false").equals("false")) {
            Intent intent = new Intent(getApplicationContext(), login.class);
            startActivity(intent);
            finish();
        }

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), menu.class);
                startActivity(intent);
                finish();
            }
        });

        mumbai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), trip_detail.class);
                startActivity(intent);
                finish();
            }
        });

        kolkata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), trip_detail.class);
                startActivity(intent);
                finish();
            }
        });

        /*textname.setText(sharedPreferences.getString("name",""));
        textemail.setText(sharedPreferences.getString("email",""));
        email=String.valueOf(sharedPreferences.getString("email",""));
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url = "http://192.168.1.7/programs/logout.php";

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
                                    Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
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
            }
        });

        fetchuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url = "http://192.168.1.7/programs/profile.php";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                fetchresult.setText(response);
                                fetchresult.setVisibility(View.VISIBLE);

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }) {
                    protected Map<String, String> getParams() {
                        Map<String, String> paramV = new HashMap<>();
                        paramV.put("email", sharedPreferences.getString("email",""));
                        paramV.put("apikey", sharedPreferences.getString("apikey",""));
                        return paramV;
                    }
                };
                queue.add(stringRequest);
            }
        });
        */

    }
}