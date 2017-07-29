package com.sahebsingh.donor;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class MainActivity extends AppCompatActivity {
    Button btnIn,btnReg;

    EditText etEmail,etPass;
   RequestQueue requestQueue;
    String checkUrl="http://192.168.43.129/doner/checkin.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            btnIn = (Button) findViewById(R.id.btnIn);
            etEmail= (EditText) findViewById(R.id.etEmail);
            etPass = (EditText) findViewById(R.id.etPass);
            btnReg = (Button) findViewById(R.id.btnRegister);
            requestQueue = Volley.newRequestQueue(getApplicationContext());


        btnIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String email=etEmail.getText().toString();
                    String pass = etPass.getText().toString();
                    if(email.length()==0 ){
                        etEmail.setError("Please Enter the Email");
                        etEmail.requestFocus();
                        return;
                    }
                    if(pass.length()==0 ){
                        etPass.setError("Please Enter the Email");
                        etPass.requestFocus();
                        return;
                    }
                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, checkUrl, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                JSONArray details = response.getJSONArray("details");
                                JSONObject detail = details.getJSONObject(0);
                                String name= detail.getString("name");
                                Intent i = new Intent(getApplicationContext(),user_login.class);
                                i.getStringExtra(name);
                                startActivity(i);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    });
                    requestQueue.add(jsonObjectRequest);



                }
            });


    }


    }




