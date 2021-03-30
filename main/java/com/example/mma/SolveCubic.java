package com.example.mma;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SolveCubic extends AppCompatActivity {
    private Button btn_solve;
    private TextView tv_result;
    private EditText edt_a;
    private EditText edt_b;
    private EditText edt_c;
    private EditText edt_d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solve_cubic);
        //Back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Cubic");
        btn_solve = findViewById(R.id.btn_solve);
        edt_a = findViewById(R.id.edt_a);
        edt_b = findViewById(R.id.edt_b);
        edt_c = findViewById(R.id.edt_c);
        edt_d = findViewById(R.id.edt_d);
        tv_result = findViewById(R.id.tv_result);
        btn_solve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = edt_a.getText().toString();
                String b = edt_b.getText().toString();
                String c = edt_c.getText().toString();
                String d = edt_d.getText().toString();
                if(a.isEmpty()||b.isEmpty()||c.isEmpty()){
                    tv_result.setText("Please fill in all fields !!");
                }
                else{
                    Double numA = Double.parseDouble(a);
                    Double numB = Double.parseDouble(b);
                    Double numC = Double.parseDouble(c);
                    Double numD = Double.parseDouble(d);
                    tv_result.setText(solveCubic(numA,numB,numC,numD));

                }

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

    public static String solveCubic(Double a, Double b, Double c, Double d) {

        Double delta = b * b - 3 * a * c;
        Double k = (9 * a * b * c - 2 * Math.pow(b, 3) - 27 * Math.pow(a, 2) * d) / (2 * Math.sqrt(Math.pow(Math.abs(delta), 3)));
        Double x1;
        Double x2;
        Double x3;
        //If delta > 0 && |k|<1
        if (delta > 0 && Math.abs(k) < 1) {
            x1 = (2 * Math.sqrt(delta) * Math.cos((Math.acos(k)) / 3) - b) / (3 * a);
            x2 = (2 * Math.sqrt(delta) * Math.cos(((Math.acos(k)) / 3 - ((2 * Math.PI) / 3))) - b) / (3 * a);
            x3 = (2 * Math.sqrt(delta) * Math.cos(((Math.acos(k)) / 3 + ((2 * Math.PI) / 3))) - b) / (3 * a);
            System.out.println("x1 =" + x1);
            System.out.println("\nx2 =" + x2);
            System.out.println("\nx3 =" + x3);
            return "x1 = " + x1 + "\nx2 = " + x2 + "\nx3 = " + x3;
        } //If delta > 0 && |k|>1
        else if (delta > 0 && Math.abs(k) > 1) {
            x1 = ((Math.sqrt(delta) * Math.abs(k)) / (3 * a * k)) * (Math.cbrt(k + Math.sqrt(Math.pow(k, 2) - 1)) + Math.cbrt(k - Math.sqrt(Math.pow(k, 2) - 1))) - (b / (3 * a));
            System.out.println("x =" + x1);
            return "x =" + x1;
        } //If delta = 0
        else if (delta == 0) {
            x1 = (-b + Math.cbrt(Math.pow(b, 3) - 27 * Math.pow(a, 2) * d)) / (3 * a);
            System.out.println("x =" + x1);
            return "x =" + x1;
        } //If delta < 0
        else if (delta < 0) {
            x1 = (Math.sqrt(Math.abs(delta))/(3*a))*(Math.cbrt(k+Math.sqrt(Math.pow(k, 2)+1))+Math.cbrt(k-Math.sqrt(Math.pow(k, 2)+1)))-(b/(3*a));
            System.out.println("x = " + x1);
            return "x =" + x1;
        }
        else return "Error";
    }
}