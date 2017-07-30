package com.example.acer1.makeawish;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class PaymentActivity extends AppCompatActivity {
    Button btnPay;
    EditText etCnum, etCVV, etDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        etCnum = (EditText) findViewById(R.id.etCnum);
        etCVV = (EditText) findViewById(R.id.etCvv);
        etDate = (EditText) findViewById(R.id.etDate);

        if (etCnum.getText().toString().length() == 0 || etCnum.getText().toString().length() > 12) {
            etCnum.setError("Plese Enter a Valid Card Number");
            etCnum.requestFocus();
            return;
        }
        if (etCVV.getText().toString().length() == 0 || etCVV.getText().toString().length() > 3) {
            etCVV.setError("Plese Enter a Valid CVV");
            etCVV.requestFocus();
            return;
        }
        if (etDate.getText().toString().length() == 0) {
            etDate.setError("Plese Enter a Valid Expiry Date");
            etDate.requestFocus();
            return;
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_payment, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.refer:
                Intent i = new Intent(Intent.ACTION_SENDTO);
                String emailTO = "ceo@makeawishindia.org";
                i.setType("text/plain");
                i.setData(Uri.parse("mailto:" + emailTO));
                i.putExtra(i.EXTRA_EMAIL, emailTO);
                startActivity(i);
                break;
            case R.id.pTM:
                Intent p = new Intent(Intent.ACTION_VIEW);
                p.setData(Uri.parse("https://www.paytm.com"));
                startActivity(p);
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}

