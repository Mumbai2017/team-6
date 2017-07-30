package com.example.acer1.makeawish;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

        dt = (TextView) findViewById(R.id.btn_pat_dob);
        dt1 = (TextView) findViewById(R.id.btn_pat_dt_admn);
        dt2 = (TextView) findViewById(R.id.btn_pat_dt_identified);
        dt3 = (TextView) findViewById(R.id.btn_pat_proposed_dt);
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
        btn1=(Button) findViewById(R.id.btn_pat_dt_admn);
        btn1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDialog(DIALOG_ID);
                    }
                }
        );
    }

    public void showDialogbtn2(){
        btn2=(Button) findViewById(R.id.btn_pat_dt_identified);
        btn2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDialog(DIALOG_ID);
                    }
                }
        );
    }
    public void showDialogbtn3(){
        btn3=(Button) findViewById(R.id.btn_pat_proposed_dt);
        btn3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDialog(DIALOG_ID);
                    }
                }
        );
    }

    public void submitGrantForm(View view) {
        EditText doc = (EditText) findViewById(R.id.et_pat_doc);
        EditText dt_admn = (EditText) findViewById(R.id.et_pat_dt_admn);
        EditText education = (EditText) findViewById(R.id.et_pat_education);
        EditText fourOne = (EditText) findViewById(R.id.et_pat_4_1);
        EditText fourTwo = (EditText) findViewById(R.id.et_pat_4_2);
        EditText fourThree = (EditText) findViewById(R.id.et_pat_4_3);
        EditText fourFour = (EditText) findViewById(R.id.et_pat_4_4);
        EditText fourFive = (EditText) findViewById(R.id.et_pat_4_5);
        EditText fourSix = (EditText) findViewById(R.id.et_pat_4_6);
        EditText fourSeven = (EditText) findViewById(R.id.et_pat_4_7);
        EditText fourEight = (EditText) findViewById(R.id.et_pat_4_8);
        EditText dt_identified = (EditText) findViewById(R.id.et_pat_dt_identified);
        EditText fatherName = (EditText) findViewById(R.id.et_pat_father_name);
        EditText guardianName = (EditText) findViewById(R.id.et_pat_guardian_name);
        EditText motherName = (EditText) findViewById(R.id.et_pat_mother_name);
        EditText motherTongue = (EditText) findViewById(R.id.et_pat_mother_tongue);
        EditText notesByDoc = (EditText) findViewById(R.id.et_pat_notes_by_doc);
        EditText permAddress = (EditText) findViewById(R.id.et_pat_perm_address);
        EditText permReferredFrom = (EditText) findViewById(R.id.et_pat_perm_referred_from);
        EditText phone = (EditText) findViewById(R.id.et_pat_phone);
        EditText proposeddt = (EditText) findViewById(R.id.et_pat_prposed_dt);
        EditText q1 = (EditText) findViewById(R.id.et_pat_q1);
        EditText q2 = (EditText) findViewById(R.id.et_pat_q2);
        EditText q3 = (EditText) findViewById(R.id.et_pat_q3);
        EditText q5 = (EditText) findViewById(R.id.et_pat_q5);
        EditText q6 = (EditText) findViewById(R.id.et_pat_q6);
        EditText rushwish = (EditText) findViewById(R.id.et_pat_rushwish);
        EditText sibling = (EditText) findViewById(R.id.et_pat_sibling);
        EditText stay = (EditText) findViewById(R.id.et_pat_stay);
        EditText tempAddress = (EditText) findViewById(R.id.et_pat_temp_address);
        EditText wish1 = (EditText) findViewById(R.id.et_pat_wish1);
        EditText wish2 = (EditText) findViewById(R.id.et_pat_wish2);
        EditText wish3 = (EditText) findViewById(R.id.et_pat_wish3);
        EditText caseNo = (EditText) findViewById(R.id.pat_case_no);
        EditText hospital = (EditText) findViewById(R.id.pat_hospital);
        EditText name = (EditText) findViewById(R.id.pat_name);

        RadioGroup gender = (RadioGroup) findViewById(R.id.pat_gender);
        int index = gender.getCheckedRadioButtonId();
        RadioButton checkedGender = (RadioButton) findViewById(index);

        CheckBox d1 = (CheckBox) findViewById(R.id.et_pat_d1);
        CheckBox d2 = (CheckBox) findViewById(R.id.et_pat_d2);
        CheckBox d3 = (CheckBox) findViewById(R.id.et_pat_d3);

        new WishRegister(this).execute(
                "Details" + ","
                + "6526" + ","
                + "8697" + ","
                + notesByDoc.getText().toString() +","
                + dt_admn.getText().toString() + ","
                + dt_identified.getText().toString() + ","
                + wish1.getText().toString() + ","
                + wish2.getText().toString() + ","
                + wish3.getText().toString() + ","
                + proposeddt.getText().toString() + ","
                + rushwish.getText().toString() + ","
                + "2011-03-03" + ","
                + "3" + ","
                + "2012-02-02" + ","
                + "1" + ","
                + (d1.isChecked() ? "1" : "0") + ","
                + (d2.isChecked() ? "1" : "0") + ","
                + (d3.isChecked() ? "1" : "0") + ","
                + "1" + ","
                + "2012-08-08" + ","
                + "2013-02-04" + ","
                + q1.getText().toString() + ","
                + q2.getText().toString() + ","
                + q3.getText().toString() + ","
                + fourOne + ","
                + fourTwo + ","
                + fourThree + ","
                + fourFour + ","
                + fourFive + ","
                + fourSix + ","
                + fourSeven + ","
                + fourEight + ","
                + q5.getText().toString() + ","
                + q6.getText().toString() + ","
                + "0"
        );
    }
}
