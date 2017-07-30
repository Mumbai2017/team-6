package com.example.acer1.makeawish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DonorLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_login);
    }

    public void makePayment(View view) {
        startActivity(new Intent(this, PaymentActivity.class));
    }

    public void getHistory(View view) {
        startActivity(new Intent(this, HistoryFetcherActivity.class));
    }
}
