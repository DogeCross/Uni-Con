package com.example.mma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenuActivity extends AppCompatActivity {
    private Button btn_calculator;
    private Button btn_converter;
    private Button btn_equation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        btn_calculator = findViewById(R.id.btn_calculator);
        btn_converter = findViewById(R.id.btn_converter);
        btn_equation = findViewById(R.id.btn_equation);
        btn_calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, CalculatorActivity.class);
                startActivity(intent);
            }
        });
        btn_converter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, ConverterMenuActivity.class);
                startActivity(intent);
            }
        });
        btn_equation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, EquationMenuActivity.class);
                startActivity(intent);

            }
        });
    }
}