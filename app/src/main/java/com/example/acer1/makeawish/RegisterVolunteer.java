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

class RegisterVolunteer extends AsyncTask<String, Void, String> {
    Context ctx;

    public RegisterVolunteer(Context context)
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

            String name = rec[0];
            String email = rec[1];
            String password = rec[2];
            String gender = rec[3];
            String location = rec[4];
            String dob = rec[5];
            String type = rec[6];
            String phone = rec[7];

            httpclient = new DefaultHttpClient();
            request = new HttpGet("http://13.229.56.82/team-6/PHP_SCRIPTS/RegisterVolunteer.php?email="+email+"&password="+password+"&name="+name+"&gender="+gender+"&location="+location+"&DOB="+dob+"&type="+type+"&phone="+phone);
            System.out.println("http://13.229.56.82/team-6/PHP_SCRIPTS/RegisterVolunteer.php?email="+email+"&password="+password+"&name="+name+"&gender="+gender+"&location="+location+"&DOB="+dob+"&type="+type+"&phone="+phone);
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
            Toast.makeText(ctx,"Successfully Registered",Toast.LENGTH_LONG).show();
            ctx.startActivity(new Intent(ctx, VolunteerLoginActivity.class));
        }
        else
        {
            Toast.makeText(ctx,"Unable to register. Please try again",Toast.LENGTH_LONG).show();
        }
    }
}
