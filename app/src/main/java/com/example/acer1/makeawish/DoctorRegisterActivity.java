package com.example.acer1.makeawish;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class DoctorRegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_doctor);
    }

    public void registerDoctor(View view){
        EditText password = (EditText) findViewById(R.id.et_doc_password);
        EditText email= (EditText) findViewById(R.id.et_doc_email);
        EditText name = (EditText) findViewById(R.id.et_doc_name);
        EditText age  = (EditText) findViewById(R.id.et_doc_age);
        EditText phone = (EditText) findViewById(R.id.et_doc_age);
        EditText alt_phone = (EditText) findViewById(R.id.et_doc_alt_phone);
        EditText hosp = (EditText) findViewById(R.id.et_doc_hosp_name);
        EditText dob = (EditText) findViewById(R.id.et_doc_dob);

        RadioGroup gender = (RadioGroup) findViewById(R.id.rg_doc_gender);
        RadioButton checkedGender = (RadioButton) findViewById(gender.getCheckedRadioButtonId());

        new RegisterDoctor(this.getApplicationContext()).execute(
                email.getText().toString() + ","
                        + password.getText().toString() + ","
                        + name.getText().toString() + ","
                        + age.getText().toString()+ ","
                        + phone.getText().toString() + ","
                        + alt_phone.getText().toString() + ","
                        + hosp.getText(),toString() + ","
                        + dob.getText().toString()
                        + checkedGender.getText().toString());
    }
}
