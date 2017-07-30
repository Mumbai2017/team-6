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

class WishRegister extends AsyncTask<String, Void, String> {
    Context ctx;

    public WishRegister(Context context)
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
            String referreddetails = rec[1];
            String w_id = rec[2];
            String pt_id =rec[3];
            String specialnotes = rec[4];
            String dateofadmission = rec[5];
            String dateidentified = rec[6];
            String wish1 = rec[7];
            String wish2 = rec[8];
            String wish3 = rec[9];
            String proposeddate = rec[10];
            String runwish = rec[11];
            String dateofsubmission = rec[12];
            String daysrequired = rec[13];
            String approvedwish = rec[14];
            String v_id = rec[15];
            String d1 = rec[16];
            String d2 = rec[17];
            String d3 = rec[18];
            String approvedbystaff = rec[19];
            String approvaldate = rec[20];
            String dateofwish = rec[21];
            String infoaboutfamily = rec[22];
            String infoaboutfriend = rec[23];
            String govtidtaken = rec[24];
            String color = rec[25];
            String book = rec[26];
            String game = rec[27];
            String food = rec[28];
            String music = rec[29];
            String hobby = rec[30];
            String show = rec[31];
            String actor = rec[32];
            String schooltrip = rec[33];
            String futurewish = rec[34];
            String input1 = rec[35];
            String input2 = rec[36];
            String input3 = rec[37];
            String wishstatus = rec[38];

            httpclient = new DefaultHttpClient();
            request = new HttpGet("http://13.229.56.82/team-6/PHP_SCRIPTS/WishForm.php?referreddetails="+referreddetails+"&w_id="+w_id+"&pt_id="+pt_id+
                    "&specialnotes="+specialnotes+
                    "&dateofadmission="+dateofadmission
                    +"&dateidentified="+dateidentified
                    +"&wish1="+wish1
                    +"&wish2="+wish2
                    +"&wish3="+wish3
                    +"&proposeddate="+proposeddate
                    +"&runwish="+runwish
                    +"&dateofsubmission="+dateofsubmission
                    +"&daysrequired="+daysrequired
                    +"&approvedwish="+approvedwish
                    +"&v_id="+v_id
                    +"&d1="+d1
                    +"&d2="+d2
                    +"&d3="+d3
                    +"&approvedbystaff="+approvedbystaff
                    +"&approvaldate="+approvaldate
                    +"&dateofwish="+dateofwish
                    +"&infoaboutfamily="+infoaboutfamily
                    +"&infoaboutfriend="+infoaboutfriend
                    +"&govidtaken="+govtidtaken
                    +"&favcolor="+color
                    +"&favbook="+book
                    +"&favgame="+game
                    +"&favfood="+food
                    +"&favmusic="+music
                    +"&favhobby="+hobby
                    +"&favshow="+show
                    +"&favactor="+actor
                    +"&schooltrip="+schooltrip
                    +"&futurewish="+futurewish
                    +"&input1="+input1
                    +"&input2="+input2
                    +"&input3="+input3
                    +"&wishstatus="+wishstatus

            );
            // System.out.println("http://13.229.56.82/team-6/PHP_SCRIPTS/WishForm.php?email="+email+"&password="+password+"&name="+name+"&gender="+gender+"&location="+location+"&DOB="+dob+"&type="+type+"&phone="+phone);
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
