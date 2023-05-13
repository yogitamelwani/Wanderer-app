package com.example.wanderer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;
import java.util.Map;

public class registration extends AppCompatActivity {
    //textInputEditText
    EditText textname, textemail, textpassword;
    Button btnsubmit;
    String name, email, password;
    TextView texterror, Tloginnow;
    ProgressBar progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Tloginnow=findViewById(R.id.loginnow);
        textemail=findViewById(R.id.email);
        textname=findViewById(R.id.name);
        textpassword=findViewById(R.id.password);
        btnsubmit=findViewById(R.id.submit);
        texterror=findViewById(R.id.error);
        progress=findViewById(R.id.loading);
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                texterror.setVisibility(View.GONE);
                progress.setVisibility(View.VISIBLE);
                name= String.valueOf(textname.getText());
                email= String.valueOf(textemail.getText());
                password= String.valueOf(textpassword.getText());
                Toast.makeText(getApplicationContext(), "Registration successfull", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getApplicationContext(),login.class);
                startActivity(intent);
                finish();
                /*
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url ="http://10.2.56.234/programs/wanderer-android/registration.php";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                progress.setVisibility(View.GONE);
                                if(response.equals("success")){
                                    Toast.makeText(getApplicationContext(), "Registration successfull", Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(getApplicationContext(),login.class);
                                    startActivity(intent);
                                    finish();
                                }
                                else{
                                    texterror.setText(response);
                                    texterror.setVisibility(View.VISIBLE);
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
                        paramV.put("name", name);
                        paramV.put("email", email);
                        paramV.put("password", password);
                        return paramV;
                    }
                };
                queue.add(stringRequest);

                 */
            }
        });
        Tloginnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}