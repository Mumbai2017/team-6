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

public class VolunteerRegisterActivity extends AppCompatActivity {

    Button btn;
    int year_x,month_x,day_x;
    String date = "1999-05-12";
    static final int DIALOG_ID=0;
    TextView dob;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_register);
        dob = (TextView) findViewById(R.id.et_vol_dob1);
        showDialogbtn();

    }

    public void registerVolunteer(View view) {
        EditText password = (EditText) findViewById(R.id.et_vol_password);
        EditText name = (EditText) findViewById(R.id.et_vol_name);
        EditText email = (EditText) findViewById(R.id.et_vol_email);
        EditText location = (EditText) findViewById(R.id.et_vol_location);
        EditText phone = (EditText) findViewById(R.id.et_vol_phone);
        EditText type = (EditText) findViewById(R.id.et_vol_type);

        RadioGroup gender = (RadioGroup) findViewById(R.id.rg_vol_gender);
        int selectedId = gender.getCheckedRadioButtonId();
        RadioButton checkedGender = (RadioButton) findViewById(selectedId);

        new RegisterVolunteer(this.getApplicationContext()).execute(
                name.getText().toString() + ","
                + email.getText().toString() + ","
                + password.getText().toString() + ","
                + checkedGender.getText().toString()+ ","
                + location.getText().toString() + ","
                + date + ","
                + type.getText().toString() + ","
                + phone.getText().toString());
    }
    ;
    public void showDialogbtn(){
        btn=(Button) findViewById(R.id.et_vol_dob);
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
            month_x=month+1;
            day_x=dayOfMonth;
            date=year_x+"-"+month_x+"-"+day_x;
            dob.setText(date);
        }
    };

    protected Dialog onCreateDialog(int id){
        if(id==DIALOG_ID){
            return new DatePickerDialog(this, datpickerListener , year_x, month_x,day_x);
        }
        return null;
    }

}
