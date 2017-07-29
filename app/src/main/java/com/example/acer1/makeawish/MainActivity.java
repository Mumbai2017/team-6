package com.example.acer1.makeawish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userList = (Spinner) findViewById(R.id.spn_user_list);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.user_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        userList.setAdapter(adapter);
    }

    public void registerVolunteer(View view) {
        startActivity(new Intent(this, VolunteerRegisterActivity.class));
    }

    public void login(View view) {
        String userType = userList.getSelectedItem().toString();

        switch (userType) {
            case "Volunteer":

                break;
            case "Doctor":
                break;
            case "Donor":
                break;
            default:
                Toast.makeText(this, "Please select a user type", Toast.LENGTH_SHORT).show();
        }
    }

    public void register(View view) {
        String userType = userList.getSelectedItem().toString();

        switch (userType) {
            case "Volunteer":
                startActivity(new Intent(this, VolunteerRegisterActivity.class));
                break;
            case "Doctor":
                //startActivity(new Intent(this, DoctorRegisterActivity.class));
                break;
            case "Donor":
                //startActivity(new Intent(this, DonorRegisterActivity.class));
                break;
            default:
                Toast.makeText(this, "Please select a user type", Toast.LENGTH_SHORT).show();
        }
    }
}
