package com.example.wanderer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class login extends AppCompatActivity {
    TextView Tregisternow, texterror;
    EditText textemail, textpassword;
    Button submitbtn;
    String email, password, name, apikey;
    ProgressBar progress;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Tregisternow=findViewById(R.id.registernow);
        textemail=findViewById(R.id.email);
        textpassword=findViewById(R.id.password);
        progress=findViewById(R.id.loading);
        texterror=findViewById(R.id.error);
        submitbtn=findViewById(R.id.submit);
        /*sharedPreferences=getSharedPreferences("MyAppName", MODE_PRIVATE);

        if(sharedPreferences.getString("logged","false").equals("true")){
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            finish();
        }

         */

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email= String.valueOf(textemail.getText());
                password= String.valueOf(textpassword.getText());
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
                /*
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url ="http://192.168.1.8/programs/wanderer-android/login.php";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                progress.setVisibility(View.GONE);

                                try {
                                    JSONObject jsonObject=new JSONObject(response);
                                    String status=jsonObject.getString("status");
                                    String message=jsonObject.getString("message");

                                    if(status.equals("success")){

                                        name=jsonObject.getString("name");
                                        email=jsonObject.getString("email");
                                        apikey=jsonObject.getString("apikey");
                                        SharedPreferences.Editor editor=sharedPreferences.edit();
                                        editor.putString("logged","true");
                                        editor.putString("name",name);
                                        editor.putString("email",email);
                                        editor.putString("apikey",apikey);
                                        editor.apply();
                                        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                    else{
                                        texterror.setText(message);
                                        texterror.setVisibility(View.VISIBLE);
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    Toast.makeText(getApplicationContext(), e.getMessage().toString() , Toast.LENGTH_SHORT).show();


                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progress.setVisibility(View.GONE);
                        texterror.setText(error.getLocalizedMessage());
                        texterror.setVisibility(View.VISIBLE);
                    }
                }){
                    protected Map<String, String> getParams(){
                        Map<String, String> paramV = new HashMap<>();
                        paramV.put("email", email);
                        paramV.put("password", password);
                        return paramV;
                    }
                };
                queue.add(stringRequest);

                 */
            }
        });
        Tregisternow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),registration.class);
                startActivity(intent);
                finish();
            }
        });
    }
}