package com.example.mma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class EquationMenuActivity extends AppCompatActivity {

    private ArrayList<Equation> equations;
    private ListView list_equation;
    private ListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equation_menu);
        //Back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Equation Solver");

        equations = new ArrayList<Equation>();
        Equation e1 = new Equation("Quadratic Equation","Ax^2 + Bx +C = 0");
        Equation e2 = new Equation("Cubic Equation","Ax^3 + Bx^2 + Cx + D = 0");
        Equation e3 = new Equation("Biquadratic Equation", "Ax^4 + Bx^2 + C = 0");
        Equation e4 = new Equation("System of Linear Equation", "A1x + B1y = C1 / A2x + B2y = C2");
        equations.add(e1);
        equations.add(e2);
        equations.add(e3);
        equations.add(e4);
        EquationAdapter adapter = new EquationAdapter(this,equations);
        list_equation = findViewById(R.id.list_equation);
        list_equation.setAdapter(adapter);
        list_equation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    System.out.println("Quadratic Equation");
                    Intent intent = new Intent(EquationMenuActivity.this, SolveQuadratic.class);
                    startActivity(intent);
                }
                else if(position == 1){
                    System.out.println("Cubic Equation");
                    Intent intent = new Intent(EquationMenuActivity.this, SolveCubic.class);
                    startActivity(intent);
                }
                else if(position == 2){
                    System.out.println("Biquadratic Equation");
                    Intent intent = new Intent(EquationMenuActivity.this, SolveBiquadratic.class);
                    startActivity(intent);
                }
                else if(position == 3){
                    System.out.println("System of Linear Equation");
                    Intent intent = new Intent(EquationMenuActivity.this, SolveLinear.class);
                    startActivity(intent);
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

}