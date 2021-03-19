package com.example.unicon;

import androidx.appcompat.app.AppCompatActivity;

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

import java.util.ArrayList;

public class ConvertActivity extends AppCompatActivity {
    private Spinner ddlFrom ;
    private Spinner ddlTo;
    private EditText edt_number;
    private TextView tv_result;
    private ArrayAdapter<Unit> adaptFrom;
    private ArrayAdapter<Unit> adaptTo;
    private ArrayList<Unit> unitFrom;
    private ArrayList<Unit> unitTo;
    private int selectedFrom;
    private Button btn_convert;
    private Double scalingFactorFrom;
    private Double scalingFactorTo;
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
        Bundle args = intent.getBundleExtra("FROM");
        unitFrom = (ArrayList<Unit>) args.getSerializable("ARRAYLIST");
        adaptFrom = new ArrayAdapter<Unit>(this,R.layout.support_simple_spinner_dropdown_item,unitFrom);
        ddlFrom.setAdapter(adaptFrom);
        unitTo = (ArrayList<Unit>) unitFrom.clone();
        selectedFrom = ddlFrom.getSelectedItemPosition();
        unitTo.remove(selectedFrom);
        adaptTo = new ArrayAdapter<Unit>(this,R.layout.support_simple_spinner_dropdown_item,unitTo);
        ddlTo.setAdapter(adaptTo);

        Unit uFrom = (Unit) ddlFrom.getSelectedItem();
        scalingFactorFrom = uFrom.getScalingFactor();

        Unit uTo = (Unit) ddlTo.getSelectedItem();
        scalingFactorTo = uTo.getScalingFactor();
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
                scalingFactorFrom = u.getScalingFactor();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ddlTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Unit u = (Unit) ddlTo.getSelectedItem();
                scalingFactorTo = u.getScalingFactor();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Unit u = (Unit) ddlTo.getSelectedItem();
                scalingFactorTo = u.getScalingFactor();
            }
        });
        btn_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String from = edt_number.getText().toString();
                double fr;
                if(from.isEmpty()){
                   fr = 0.0;
                }
                else
                 fr= Double.parseDouble(from);
                String result = String.valueOf(fr*scalingFactorFrom/scalingFactorTo);
                tv_result.setText(result);
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