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

public class DonorRegisterActivity extends AppCompatActivity {
    Button btn;
    int year_x,month_x,day_x;
    static final int DIALOG_ID=0;
    TextView dob;
    String date="1995-5-12";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_register);
        dob = (TextView) findViewById(R.id.et_don_dob1);
        showDialogbtn();
    }

    public void registerDonor(View view) {
        EditText email = (EditText) findViewById(R.id.et_don_email);
        EditText password = (EditText) findViewById(R.id.et_don_password);
        EditText name = (EditText) findViewById(R.id.et_don_name);
        EditText phone = (EditText) findViewById(R.id.et_don_phone);
        EditText location = (EditText) findViewById(R.id.et_don_location);

        new RegisterDonor(this.getApplicationContext()).execute(
                name.getText().toString() + ","
                        + email.getText().toString() + ","
                        + password.getText().toString() + ","
                        + dob.getText().toString() + ","
                        + phone.getText().toString() + ","
                        + location.getText().toString());
    }

    public void showDialogbtn(){
        btn=(Button) findViewById(R.id.et_don_dob);
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

        }
    };

    protected Dialog onCreateDialog(int id){
        if(id==DIALOG_ID){
            return new DatePickerDialog(this, datpickerListener , year_x, month_x,day_x);
        }
        return null;

    }

}
