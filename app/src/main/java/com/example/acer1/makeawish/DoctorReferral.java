package com.example.acer1.makeawish;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DoctorReferral extends AppCompatActivity {

    Button btn;
    int year_x,month_x,day_x;
    String dob;
    TextView dob1;
    static final int DIALOG_ID=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_referral);

        dob1 = (TextView) findViewById(R.id.ref_dob1);

        showDialogbtn();
    }
    public void showDialogbtn(){
        btn=(Button) findViewById(R.id.ref_dob);
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
            month_x = month + 1;
            day_x=dayOfMonth;
            dob = year_x+"/"+month_x+"/"+day_x;
        }
    };

    protected Dialog onCreateDialog(int id){
        if(id==DIALOG_ID){
            return new DatePickerDialog(this, datpickerListener , year_x, month_x,day_x);
        }
        return null;

    }

    public void referChild(View view) {
        EditText refName = (EditText) findViewById(R.id.ref_name);
        EditText fatherName = (EditText) findViewById(R.id.ref_fname);
        EditText motherName = (EditText) findViewById(R.id.ref_mname);
        EditText dis = (EditText) findViewById(R.id.ref_dis);
        TextView dob = (TextView) findViewById(R.id.ref_dob1);

        new PatientReferral(this).execute(
                refName.getText().toString() + ","
                        + fatherName.getText().toString() + ","
                        + motherName.getText().toString() + ","
                        + dis.getText().toString() + ","
                        + dob
        );
    }
}
