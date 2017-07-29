package com.example.acer1.makeawish;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;

public class HistoryFetcherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_fetcher);

        ListView lv_wish_history = (ListView) findViewById(R.id.lv_wish_history);
        ArrayList<String> myStringArray1 = new ArrayList<String>();

        HttpClient httpclient;
        HttpGet request;
        HttpResponse response = null;
        String result = "";

        try {
            httpclient = new DefaultHttpClient();
            request = new HttpGet("http://13.229.56.82/team-6/PHP_SCRIPTS/FetchHistory.php");
            response = httpclient.execute(request);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(
                    response.getEntity().getContent()));
            String line;
            while ((line = rd.readLine()) != null) {
                myStringArray1.add(line);
            }
        } catch (Exception e) {
            Log.e("Error2","err "+e);
            result = "error2";
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_wish, R.id.tv_list_wish, myStringArray1);
        lv_wish_history.setAdapter(adapter);
    }
}
