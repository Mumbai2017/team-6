package com.example.acer1.makeawish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showForm(View view) {
        startActivity(new Intent(this, WishGrantingForm.class));
    }

    public void registerVolunteer(View view) {
        startActivity(new Intent(this, VolunteerRegisterActivity.class));
    }
}
