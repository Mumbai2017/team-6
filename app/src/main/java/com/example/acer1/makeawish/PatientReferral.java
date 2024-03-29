package com.example.acer1.makeawish;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;

class PatientReferral extends AsyncTask<String, Void, String> {
    Context ctx;

    public PatientReferral(Context context)
    {
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

            String refname = rec[0];
            String fathername = rec[1];
            String mothername = rec[2];
            String disease = rec[3];
            // String location = rec[4];
            String dob = rec[4];
            //  String type = rec[6];
            //  String phone = rec[7];

            httpclient = new DefaultHttpClient();
            request = new HttpGet("http://13.229.56.82/team-6/PHP_SCRIPTS/doctorreferral.php?refname="+refname+"&fathername="+fathername+"&mothernamename="+mothername+"&disease="+disease+"&DOB="+dob);
            // System.out.println("http://13.229.56.82/team-6/PHP_SCRIPTS/RegisterVolunteer.php?email="+email+"&password="+password+"&name="+name+"&gender="+gender+"&location="+location+"&DOB="+dob+"&type="+type+"&phone="+phone);
            response = httpclient.execute(request);
        } catch (Exception e) {
            result = e.getMessage();
            e.printStackTrace();
        }

        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(
                    response.getEntity().getContent()));
            String line;
            while ((line = rd.readLine()) != null) {
                result = result + line;
            }
        } catch (Exception e) {
            Log.e("Error2","err "+e);
            result = "error2";
        }
        return result;
    }

    protected void onPostExecute(String result) {

        Log.e("Result", "Result" + result);
        if (result.trim().equalsIgnoreCase("1"))
        {
            Toast.makeText(ctx,"Wish Successfully Referred",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(ctx,"Sorry the wish has already been granted before",Toast.LENGTH_LONG).show();
        }
    }
}
