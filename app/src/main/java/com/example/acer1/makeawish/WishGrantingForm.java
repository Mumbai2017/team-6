package com.example.acer1.makeawish;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

public class WishGrantingForm extends AppCompatActivity {

    Button btn,btn1,btn2,btn3;
    TextView dt1,dt2,dt3,dt;
    int year_x,month_x,day_x;
    static final int DIALOG_ID=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_granting_form);
        showDialogbtn1();
        showDialogbtn();showDialogbtn2();
        showDialogbtn3();




    }

    public void showDialogbtn(){
        btn=(Button) findViewById(R.id.et_pat_dob);
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
            Toast.makeText(WishGrantingForm.this,year_x+"/"+month_x+"/"+day_x, Toast.LENGTH_LONG).show();

        }
    };

    protected Dialog onCreateDialog(int id){
        if(id==DIALOG_ID){
            return new DatePickerDialog(this, datpickerListener , year_x, month_x,day_x);
        }
        return null;

    }

    public void showDialogbtn1(){
        btn1=(Button) findViewById(R.id.et_pat_dt_admn);
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDialog(DIALOG_ID);
                    }
                }
        );
    }

    public void showDialogbtn2(){
        btn1=(Button) findViewById(R.id.et_pat_dt_admn);
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDialog(DIALOG_ID);
                    }
                }
        );
    }
    public void showDialogbtn3(){
        btn1=(Button) findViewById(R.id.et_pat_prposed_dt);
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDialog(DIALOG_ID);
                    }
                }
        );
    }

}
