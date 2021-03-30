package com.example.mma;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SolveLinear extends AppCompatActivity {
    private Button btn_solve;
    private TextView tv_result;
    private EditText edt_a1;
    private EditText edt_b1;
    private EditText edt_c1;
    private EditText edt_a2;
    private EditText edt_b2;
    private EditText edt_c2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solve_linear);
        //Back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Linear");
        btn_solve = findViewById(R.id.btn_solve);
        edt_a1 = findViewById(R.id.edt_a1);
        edt_b1 = findViewById(R.id.edt_b1);
        edt_c1 = findViewById(R.id.edt_c1);
        edt_a2 = findViewById(R.id.edt_a2);
        edt_b2 = findViewById(R.id.edt_b2);
        edt_c2 = findViewById(R.id.edt_c2);

        tv_result = findViewById(R.id.tv_result);
        btn_solve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a1 = edt_a1.getText().toString();
                String b1 = edt_b1.getText().toString();
                String c1 = edt_c1.getText().toString();
                String a2 = edt_a2.getText().toString();
                String b2 = edt_b2.getText().toString();
                String c2 = edt_c2.getText().toString();
                if(a1.isEmpty()||b1.isEmpty()||c1.isEmpty()||a2.isEmpty()||b2.isEmpty()||c2.isEmpty()){
                    tv_result.setText("Please fill in all fields !!");
                }
                else{
                    Double numA1 = Double.parseDouble(a1);
                    Double numB1 = Double.parseDouble(b1);
                    Double numC1 = Double.parseDouble(c1);
                    Double numA2 = Double.parseDouble(a2);
                    Double numB2 = Double.parseDouble(b2);
                    Double numC2 = Double.parseDouble(c2);
                tv_result.setText(solveSet(numA1,numB1,numC1,numA2,numB2,numC2));

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

    public static String solveSet(Double a1, Double b1, Double c1, Double a2, Double b2, Double c2) {
        double D, Dx, Dy, x, y;
        D = a1 * b2 - a2 * b1;
        Dx = c1 * b2 - c2 * b1;
        Dy = a1 * c2 - a2 * c1;
        if (D == 0) {
            if (Dx + Dy == 0) {
                System.out.println("He phuong trinh co vo so nghiem");
                return "No Solution!!";
            } else {
                System.out.println("He phuong trinh vo nghiem");
                return "No Solution!!";
            }
        } else {
            x = Dx / D;
            y = Dy / D;
            System.out.println("He phuong trinh co nghiem (x, y) = (" + x + "," + y + ")");
            return "(x, y) = (" + x + "," + y + ")";
        }
    }

}