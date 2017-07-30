package com.example.acer1.makeawish;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class DoctorRegisterActivity extends AppCompatActivity {
    Button btn;
    int year_x,month_x,day_x;
    static final int DIALOG_ID=0;
    String date="1995-5-12";
    TextView dob;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_doctor);
        dob = (TextView) findViewById(R.id.et_vol_dob1);

        showDialogbtn();
    }

    public void registerDoctor(View view){
        EditText password = (EditText) findViewById(R.id.et_doc_password);
        EditText email= (EditText) findViewById(R.id.et_doc_email);
        EditText name = (EditText) findViewById(R.id.et_doc_name);
        EditText age  = (EditText) findViewById(R.id.et_doc_age);
        EditText phone = (EditText) findViewById(R.id.et_doc_age);
        EditText alt_phone = (EditText) findViewById(R.id.et_doc_alt_phone);
        EditText hosp = (EditText) findViewById(R.id.et_doc_hosp_name);

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
                        + date + ","
                        + checkedGender.getText().toString());
    }

    public void showDialogbtn(){
        btn=(Button) findViewById(R.id.et_doc_dob);
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDialog(DIALOG_ID);
                    }
                }
        );
    }
    private DatePickerDialog.OnDateSetListener datpickerListener
            = new DatePickerDialog.OnDateSetListener(){

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            year_x=year;
            month_x=month;
            day_x=dayOfMonth;
            Toast.makeText(DoctorRegisterActivity.this,year_x+"/"+month_x+"/"+day_x, Toast.LENGTH_LONG).show();

        }
    };

    protected Dialog onCreateDialog(int id){
        if(id==DIALOG_ID){
            return new DatePickerDialog(this, datpickerListener , year_x, month_x,day_x);
        }
        return null;

    }

}
