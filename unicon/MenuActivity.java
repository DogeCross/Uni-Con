package com.example.unicon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.io.Serializable;
import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {
    private int selectedFrom;
    private ArrayList<Unit> unitTo;
    private ArrayList<Unit> unitFrom;
    private ArrayAdapter<Unit> adaptTo;
    private ArrayAdapter<Unit> adaptFrom;
    private Double kg = 1000.0;
    private Double g = 1.0;
    private Double oz = 28.3495231;
    private Double lbs = 453.59237;
    private Double scalingFactorFrom;
    private Double scalingFactorTo;
    private Button btn_weight;
    private Button btn_currency;
    private Button btn_length;
    private Button btn_heat;
    private Button btn_area;
    private Button btn_pressure;
    private Button btn_speed;
    private Button btn_volume;
    private Button btn_time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_weight = findViewById(R.id.btn_weight);
        btn_heat = findViewById(R.id.btn_heat);
        btn_weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unitFrom = new ArrayList<Unit>();
                Unit u = new Unit("weight","Kilogram (kg)",kg);
                Unit u2 = new Unit("weight","Gram (g)",g);
                Unit u3 = new Unit("weight","Pound (lbs)",lbs);
                Unit u4 = new Unit("weight","Ounce(oz)",oz);
                unitFrom.add(u);
                unitFrom.add(u2);
                unitFrom.add(u3);
                unitFrom.add(u4);
                Intent intent = new Intent(MenuActivity.this, ConvertActivity.class);
                Bundle args = new Bundle();
                args.putSerializable("ARRAYLIST",(Serializable) unitFrom);
                intent.putExtra("FROM",args);
                startActivity(intent);
            }
        });
        btn_heat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unitFrom = new ArrayList<Unit>();
                Unit u = new Unit("heat","Kelvin(K)",1.0);
                Unit u2 = new Unit("heat","Celsius (°C)",2.0);
                Unit u3 = new Unit("heat","Fahrenheit (°F)",3.0);
                Unit u4 = new Unit("heat","Rankine(°R)",4.0);
                unitFrom.add(u);
                unitFrom.add(u2);
                unitFrom.add(u3);
                unitFrom.add(u4);
                Intent intent = new Intent(MenuActivity.this, ConvertActivity.class);
                Bundle args = new Bundle();
                args.putSerializable("ARRAYLIST",(Serializable) unitFrom);
                intent.putExtra("FROM",args);
                startActivity(intent);
            }
        });
    }


}