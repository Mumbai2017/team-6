package com.example.acer1.makeawish;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;

import static android.content.Context.MODE_PRIVATE;

class CheckLogin extends AsyncTask<String, Void, String> {
    Context ctx;
    String us, pw, type1;

    public CheckLogin(Context context) {
        ctx = context;
    }


    protected String doInBackground(String... message) {
        HttpClient httpclient;
        HttpGet request;
        HttpResponse response = null;
        String result = "";
        try {
            String send = message[0];
            String[] rec = send.split(",");
            us = rec[0];

            pw = rec[1];

            type1 = rec[2];
            Log.e("Check", "us=" + us + " pass=" + pw + "type=" + type1 + "ok");
            if (type1.equalsIgnoreCase("Volunteer")) {
                try{
                httpclient = new DefaultHttpClient();
                    request = new HttpGet("http://13.229.56.82/team-6/PHP_SCRIPTS/LoginVolunteer.php?us=" + us + "&pw=" + pw);
                System.out.println("here");
                    response = httpclient.execute(request);
            }
            catch (Exception e) {
                result = "error1";
            }}
            else if (type1.equalsIgnoreCase("Donor")) {
                try{
                httpclient = new DefaultHttpClient();
                request = new HttpGet("http://13.229.56.82/team-6/PHP_SCRIPTS/LoginDonor.php?us=" + us + "&pw=" + pw);
                response = httpclient.execute(request);
            }
                catch (Exception e) {
                    result = "error1";
                }}
            else if (type1.equalsIgnoreCase("Doctor")) {
                try {
                    httpclient = new DefaultHttpClient();

                request = new HttpGet("http://13.229.56.82/team-6/PHP_SCRIPTS/LoginDoctor.php?us=" + us + "&pw=" + pw);
                response = httpclient.execute(request);
            }catch (Exception e) {
                    result = "error1";
                }}
        } catch (Exception e) {
            result = "error1";
        }

        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(
                    response.getEntity().getContent()));
            String line = "";
            while ((line = rd.readLine()) != null) {
                result = result + line;
            }
        } catch (Exception e) {
            result = "error2";
        }
        return result;
    }

    protected void onPostExecute(String result) {

        Log.e("Result", "Result" + result);

        if (result.trim().equalsIgnoreCase("1")) {
            SharedPreferences.Editor editor = ctx.getSharedPreferences("LoginPref", MODE_PRIVATE).edit();
            editor.putString("email", us);
            editor.putString("Password", pw);
            editor.putString("type", type1);
            editor.putString("text", "YES");
            editor.commit();

            if (android.os.Build.VERSION.SDK_INT > 9) {
                StrictMode.ThreadPolicy policy =
                        new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }

//            String url = "http://dcshahfamily.esy.es/DateUp.php";
//            HttpClient client = new DefaultHttpClient();
//
//            try {
//                client.execute(new HttpGet(url));
//            } catch (IOException e) {
//                //do something here
//            }
            switch (type1) {
                case "Volunteer":
                    Intent i = new Intent(ctx, VolunteerLoginActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    ctx.startActivity(i);
                    break;
//                case "Doctor":
//                    Intent i = new Intent(ctx,DoctorLoginActivity.class);
//                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    ctx.startActivity(i);
//                    break;
//                case "Donor":
//                    Intent i = new Intent(ctx,DonorLoginActivity.class);
//                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    ctx.startActivity(i);
//                    break;
                default: {
                    Toast.makeText(ctx, "Invalid ID or PASSWORD", Toast.LENGTH_LONG).show();
                }
            }


        }
    }
}