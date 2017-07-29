package com.example.acer1.makeawish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class VolunteerLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_login);

    }

    public void submitForm(View view) {
        startActivity(new Intent(this, WishGrantingForm.class));
    }

    public void referVolunteer(View view) {
        Toast.makeText(this, "Not yet done", Toast.LENGTH_SHORT).show();
    }
}
