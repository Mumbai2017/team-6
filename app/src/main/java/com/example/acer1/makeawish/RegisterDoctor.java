package com.example.acer1.makeawish;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;

class RegisterDoctor extends AsyncTask<String, Void, String> {
    Context ctx;


    public RegisterDoctor(Context context)
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

            String email = rec[0];
            String password = rec[1];
            String name = rec[2];
            String age = rec[3];
            String phone = rec[4];
            String altphone = rec[5];
            String hosp = rec[6];
            String dob = rec[7];
            String gender = rec[8];

            httpclient = new DefaultHttpClient();
            request = new HttpGet("http://13.229.56.82/team-6/PHP_SCRIPTS/RegisterDoctor.php?email="+email+"&password="+password+"&name="+name+"&age="+age+"&phone="+phone+"&altphone"+altphone+"&hosp="+hosp+"&DOB="+dob+"gender="+gender);
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
            //Intent i = new Intent(ctx, FirstActivity.class);
            //ctx.startActivity(i);
        }
        else
        {
            Toast.makeText(ctx,"Unable to register please try again",Toast.LENGTH_LONG).show();
        }


    }
}