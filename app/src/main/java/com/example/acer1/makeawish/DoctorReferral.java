package com.example.acer1.makeawish;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class DoctorReferral extends AppCompatActivity {

    Button btn;
    int year_x,month_x,day_x;
    static final int DIALOG_ID=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_referral);
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
            month_x=month;
            day_x=dayOfMonth;
            Toast.makeText(DoctorReferral.this,year_x+"/"+month_x+"/"+day_x, Toast.LENGTH_LONG).show();

        }
    };

    protected Dialog onCreateDialog(int id){
        if(id==DIALOG_ID){
            return new DatePickerDialog(this, datpickerListener , year_x, month_x,day_x);
        }
        return null;

    }

}
