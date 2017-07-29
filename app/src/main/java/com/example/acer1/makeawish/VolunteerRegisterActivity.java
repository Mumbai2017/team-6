package com.example.acer1.makeawish;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class VolunteerRegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_register);
    }

    public void registerVolunteer(View view) {
        EditText password = (EditText) findViewById(R.id.et_vol_password);
        EditText name = (EditText) findViewById(R.id.et_vol_name);
        EditText email = (EditText) findViewById(R.id.et_vol_email);
        EditText location = (EditText) findViewById(R.id.et_vol_location);
        EditText phone = (EditText) findViewById(R.id.et_vol_phone);
        EditText dob = (EditText) findViewById(R.id.et_vol_dob);
        EditText type = (EditText) findViewById(R.id.et_vol_type);

        RadioGroup gender = (RadioGroup) findViewById(R.id.rg_vol_gender);
        RadioButton checkedGender = (RadioButton) findViewById(gender.getCheckedRadioButtonId());

        new RegisterVolunteer(this.getApplicationContext()).execute(
                name.getText().toString() + ","
                + email.getText().toString() + ","
                + password.getText().toString() + ","
                + checkedGender.getText().toString()+ ","
                + location.getText().toString() + ","
                + dob.getText().toString() + ","
                + type.getText(),toString() + ","
                + phone.getText().toString());
    }
}
