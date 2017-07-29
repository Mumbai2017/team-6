package com.example.acer1.makeawish;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DonorRegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_register);
    }

    public void registerDonor(View view) {
        EditText email = (EditText) findViewById(R.id.et_don_email);
        EditText password = (EditText) findViewById(R.id.et_don_password);
        EditText name = (EditText) findViewById(R.id.et_don_name);
        EditText dob = (EditText) findViewById(R.id.et_vol_dob);
        EditText phone = (EditText) findViewById(R.id.et_vol_phone);
        EditText location = (EditText) findViewById(R.id.et_vol_location);

        new RegisterDonor(this.getApplicationContext()).execute(
                name.getText().toString() + ","
                        + email.getText().toString() + ","
                        + password.getText().toString() + ","
                        + name.getText().toString() + ","
                        + dob.getText().toString() + ","
                        + phone.getText().toString() + ","
                        + location.getText().toString());
    }
}
