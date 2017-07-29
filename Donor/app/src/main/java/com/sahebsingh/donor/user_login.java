package com.sahebsingh.donor;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class user_login extends AppCompatActivity {
    FloatingActionButton fAdd;
    ListView lvHistory;
    String hist = "";
    String getUrl = "http://192.168.43.129/doner/history.php";
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        lvHistory = (ListView) findViewById(R.id.lvHistory);
        fAdd = (FloatingActionButton) findViewById(R.id.fabAdd);
        requestQueue = Volley.newRequestQueue(getApplicationContext());
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, getUrl, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                try {
//                    JSONArray historys = response.getJSONArray("history");
//                    for(int i = 0 ;i<historys.length();i++) {
//                        JSONObject history = historys.getJSONObject(i);
//                        String name= history.getString("");
//                    }
//
//
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//        requestQueue.add(jsonObjectRequest);
//        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,);
//        lvHistory.setAdapter(adapter);
//
//    }
//}
    }
}