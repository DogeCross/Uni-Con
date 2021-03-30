package com.example.mma;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SolveQuadratic extends AppCompatActivity {
    private Button btn_solve;
    private TextView tv_result;
    private EditText edt_a;
    private EditText edt_b;
    private EditText edt_c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solve_quadratic);
        //Back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Quadratic");
        btn_solve = findViewById(R.id.btn_solve);
        edt_a = findViewById(R.id.edt_d);
        edt_b = findViewById(R.id.edt_b);
        edt_c = findViewById(R.id.edt_c);
        tv_result = findViewById(R.id.tv_result);
        btn_solve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = edt_a.getText().toString();
                String b = edt_b.getText().toString();
                String c = edt_c.getText().toString();
                if(a.isEmpty()||b.isEmpty()||c.isEmpty()){
                    tv_result.setText("Please fill in all fields !!");
                }
                else{
                    Double numA = Double.parseDouble(a);
                    Double numB = Double.parseDouble(b);
                    Double numC = Double.parseDouble(c);
                    tv_result.setText(solveQuadratic(numA,numB,numC));
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

    public static String solveQuadratic(Double a, Double b, Double c) {
        Double delta, x1, x2;
        String result = "";
        delta = Math.pow(b, 2) - 4 * a * c;
        if (delta < 0) {
            result = "No Solution!";
        } else if (delta == 0) {
            x1 = x2 = -b / (2 * a);
            System.out.println("x1 = x2 = " + x1);
        } else {
            x1 = (-b + Math.sqrt(delta)) / (2 * a);
            x2 = (-b - Math.sqrt(delta)) / (2 * a);
            result = "x1 = " + x1 + "\nx2 = " + x2;
        }
        System.out.println(result);
        return  result;
    }



}