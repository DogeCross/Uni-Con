package com.example.mma;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigInteger;
import java.util.ArrayList;

public class ConvertCoefficientActivity extends AppCompatActivity {

    private Spinner ddlFrom;
    private Spinner ddlTo;
    private EditText edt_number;
    private TextView tv_result;
    private ArrayAdapter<Unit> adaptFrom;
    private ArrayAdapter<Unit> adaptTo;
    private ArrayList<Unit> unitFrom;
    private ArrayList<Unit> unitTo;
    private int selectedFrom;
    private Button btn_convert;
    private Double scalingStrFactorFrom;
    private Double scalingStrFactorTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);
        //Back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Get components
        ddlFrom = findViewById(R.id.ddl_from);
        ddlTo = findViewById(R.id.ddl_to);
        btn_convert = findViewById(R.id.btn_convert);
        edt_number = findViewById(R.id.edt_number);
        tv_result = findViewById(R.id.txt_result);
        //Get unit list from intent and put it into spinner
        Intent intent = getIntent();
        //Set activity title
        String title = intent.getExtras().getString("TITLE");
        getSupportActionBar().setTitle(title);
        //Get Arraylist
        Bundle args = intent.getBundleExtra("FROM");
        unitFrom = (ArrayList<Unit>) args.getSerializable("ARRAYLIST");
        adaptFrom = new ArrayAdapter<Unit>(this, R.layout.support_simple_spinner_dropdown_item, unitFrom);
        ddlFrom.setAdapter(adaptFrom);
        unitTo = (ArrayList<Unit>) unitFrom.clone();
        selectedFrom = ddlFrom.getSelectedItemPosition();
        unitTo.remove(selectedFrom);
        adaptTo = new ArrayAdapter<Unit>(this, R.layout.support_simple_spinner_dropdown_item, unitTo);
        ddlTo.setAdapter(adaptTo);

        Unit uFrom = (Unit) ddlFrom.getSelectedItem();
        scalingStrFactorFrom = uFrom.getScalingFactor();

        Unit uTo = (Unit) ddlTo.getSelectedItem();
        scalingStrFactorTo = uTo.getScalingFactor();

        //Change second spinner unit list dynamically when select item on first spinner
        ddlFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedFrom = ddlFrom.getSelectedItemPosition();
                unitTo.clear();
                unitTo = (ArrayList<Unit>) unitFrom.clone();
                unitTo.remove(selectedFrom);
                adaptTo.clear();
                adaptTo.addAll(unitTo);
                ddlTo.setAdapter(adaptTo);
                Unit u = (Unit) ddlFrom.getSelectedItem();
                scalingStrFactorFrom = u.getScalingFactor();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ddlTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Unit u = (Unit) ddlTo.getSelectedItem();
                scalingStrFactorTo = u.getScalingFactor();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Unit u = (Unit) ddlTo.getSelectedItem();
                scalingStrFactorTo = u.getScalingFactor();

            }
        });
        btn_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getText = edt_number.getText().toString();
                String getFrom ="" ;
                String getTo ="";
                if(scalingStrFactorFrom == 10.0){
                    getFrom = "dec";
                }
                else if (scalingStrFactorFrom == 2.0){
                    getFrom = "bin";
                }
                else if (scalingStrFactorFrom == 8.0){
                    getFrom = "oct";
                }
                else if (scalingStrFactorFrom == 6.0){
                    getFrom = "hex";
                }
                if(scalingStrFactorTo == 10.0){
                    getTo = "dec";
                }
                else if (scalingStrFactorTo == 2.0){
                    getTo= "bin";
                }
                else if (scalingStrFactorTo== 8.0){
                    getTo= "oct";
                }
                else if (scalingStrFactorTo == 6.0){
                    getTo = "hex";
                }
                String result = "CAN NOT CONVERT";
                if (getText.isEmpty()) {
                    result = "0.0";
                }
                if (getFrom.equals("dec") && getTo.equals("bin")) {
                    result = DecToBin(getText);
                } else if (getFrom.equals("dec") && getTo.equals("hex")) {
                    result = DecToHex(getText).toUpperCase();
                } else if (getFrom.equals("dec") && getTo.equals("oct")) {
                    result = DecToOct(getText).toUpperCase();
                } else if (getFrom.equals("hex") && getTo.equals("bin")) {
                    result = HexToBin(getText);
                } else if (getFrom.equals("hex") && getTo.equals("dec")) {
                    result = HexToDec(getText);
                } else if (getFrom.equals("hex") && getTo.equals("oct")) {
                    result = HexToOct(getText).toUpperCase();
                } else if (getFrom.equals("bin") && getTo.equals("dec")) {
                    result = BinToDec(getText);
                } else if (getFrom.equals("bin") && getTo.equals("hex")) {
                    result = BinToHex(getText).toUpperCase();
                } else if (getFrom.equals("bin") && getTo.equals("oct")) {
                    result = BinToOct(getText).toUpperCase();
                } else if (getFrom.equals("oct") && getTo.equals("dec")) {
                    result = OctToDec(getText);
                } else if (getFrom.equals("oct") && getTo.equals("hex")) {
                    result = OctToHex(getText).toUpperCase();
                } else if (getFrom.equals("oct") && getTo.equals("bin")) {
                    result = OctToBin(getText);
                }
                tv_result.setText(result);
            }


            //Convert Decimal to Binary
            public String DecToBin(String dec) {
                if (!isStringInt(dec)) {
                    return "CAN NOT CONVERT";
                } else {
                    Integer i = Integer.parseInt(dec);
                    if (i == 0) {
                        return dec;
                    } else {
                        return Integer.toBinaryString(i);
                    }
                }
            }

            //Convert Decimal to Hex
            public String DecToHex(String dec) {
                if (!isStringInt(dec)) {
                    return "CAN NOT CONVERT";
                }
                return Integer.toHexString(Integer.parseInt(dec));
            }

            //Convert Decimal to Oct
            public String DecToOct(String dec) {
                if (!isStringInt(dec)) {
                    return "CAN NOT CONVERT";
                }
                return Integer.toOctalString(Integer.parseInt(dec));
            }

            //Convert Hex to Binary
            public String HexToBin(String hex) {
                try {
                    return new BigInteger(hex, 16).toString(2);
                } catch (Exception e) {
                    return "CAN NOT CONVERT";
                }
            }

            //Convert Hex to Decimal
            public String HexToDec(String hex) {
                try {
                    return new BigInteger(hex, 16).toString();
                } catch (Exception e) {
                    return "CAN NOT CONVERT";
                }
            }

            //Convert Hex to Oct
            public String HexToOct(String hex) {
                try {
                    return new BigInteger(hex, 16).toString(8);
                } catch (Exception e) {
                    return "CAN NOT CONVERT";
                }
            }

            //Convert Binary to Decimal
            public String BinToDec(String bin) {
                if (!isStringBinary(bin)) {
                    return "CAN NOT CONVERT";
                }
                return "" + Integer.parseInt(bin, 2);
            }

            //Convert Binary to Hex
            public String BinToHex(String bin) {
                if (!isStringBinary(bin)) {
                    return "CAN NOT CONVERT";
                }
                return Integer.toHexString(Integer.parseInt(bin, 2));
            }

            //Convert Binary to Oct
            public String BinToOct(String bin) {
                if (!isStringBinary(bin)) {
                    return "CAN NOT CONVERT";
                }
                return Integer.toOctalString(Integer.parseInt(BinToDec(bin)));
            }

            //Convert Oct to Decimal
            public String OctToDec(String oct) {
                if (!isStringOctal(oct)) {
                    return "CAN NOT CONVERT";
                }
                return "" + Integer.parseInt(oct, 8);
            }

            //Convert Oct to Binary
            public String OctToBin(String oct) {
                if (!isStringOctal(oct)) {
                    return "CAN NOT CONVERT";
                }
                return Integer.toBinaryString(Integer.parseInt(oct));
            }

            //Convert Oct to Hex
            public String OctToHex(String oct) {
                if (!isStringOctal(oct)) {
                    return "CAN NOT CONVERT";
                }
                return Integer.toHexString(Integer.parseInt(oct, 8));
            }

            //Check is Octal
            public boolean isStringOctal(String octal) {
                boolean isOctal = false;
                if (octal != null && !octal.isEmpty()) {
                    int number = Integer.parseInt(octal);

                    while (number > 0) {
                        if (number % 10 <= 7) {
                            isOctal = true;
                        } else {
                            isOctal = false;
                            break;
                        }
                        number /= 10;
                    }
                }
                return isOctal;
            }

            //check is Integer
            public boolean isStringInt(String s) {
                try {
                    Integer.parseInt(s);
                    return true;
                } catch (NumberFormatException ex) {
                    return false;
                }
            }

            //check is Binary
            public boolean isStringBinary(String value) {
                for (int i = 0; i < value.length(); i++) {
                    int tempB = value.charAt(i);
                    if (tempB == '0' || tempB == '1') {
                        continue;
                    }
                    return false;
                }
                return true;
            }


        });
    }

    // Create back button on action bar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

}
