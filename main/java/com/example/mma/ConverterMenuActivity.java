package com.example.mma;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;

public class ConverterMenuActivity extends AppCompatActivity {
    private int selectedFrom;
    private ArrayList<Unit> unitTo;
    private ArrayList<Unit> unitFrom;
    private ArrayAdapter<Unit> adaptTo;
    private ArrayAdapter<Unit> adaptFrom;
    private Button btn_weight;
    private Button btn_currency;
    private Button btn_length;
    private Button btn_area;
    private Button btn_pressure;
    private Button btn_velocity;
    private Button btn_volume;
    private Button btn_time;
    private Button btn_base;
    private GridView grid_menu;
    int icon[] = {
            R.drawable.area,
            R.drawable.binary,
            R.drawable.currency,
            R.drawable.length,
            R.drawable.pressure,
            R.drawable.speed,
            R.drawable.time,
            R.drawable.volume,
            R.drawable.weight
    };
    String type[] = {"Area", "Binary", "Currency", "Length", "Pressure", "Velocity", "Time", "Volume", "Weight"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter_menu);
        getSupportActionBar().setTitle("Unit Menu");
        //Back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().getCustomView();
        grid_menu = findViewById(R.id.grid_menu);
        gridAdapter adapter = new gridAdapter(type, icon, this);
        grid_menu.setAdapter(adapter);
        grid_menu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    System.out.println("area");
                    unitFrom = new ArrayList<Unit>();
                    Unit u1 = new Unit("area", "Square Kilometer (km^2)", 1000000000000.0);
                    Unit u2 = new Unit("area", "Square Meter (m^2)", 1000000.0);
                    Unit u3 = new Unit("area", "Square Centimeter(cm^2)", 100.0);
                    Unit u4 = new Unit("area", "Square Millimeter(mm^2)", 1.0);
                    Unit u5 = new Unit("area", "Square Hectare (ha)", 10000000000.0);
                    Unit u6 = new Unit("area", "Square Arce (ac)", 4046856422.4);
                    Unit u7 = new Unit("area", "Square Yard (yd^2)", 836127.36);
                    Unit u8 = new Unit("area", "Square Foot (ft^2)", 92903.04);
                    Unit u9 = new Unit("area", "Square Mile (mi^2)", 2589988110336.0);
                    Unit u10 = new Unit("area", "Square Inch (in^2)", 2589988110336.0);
                    unitFrom.add(u1);
                    unitFrom.add(u2);
                    unitFrom.add(u3);
                    unitFrom.add(u4);
                    unitFrom.add(u5);
                    unitFrom.add(u6);
                    unitFrom.add(u7);
                    Intent intent = new Intent(ConverterMenuActivity.this, ConvertActivity.class);
                    Bundle args = new Bundle();
                    args.putSerializable("ARRAYLIST", (Serializable) unitFrom);
                    intent.putExtra("FROM", args);
                    intent.putExtra("TITLE","Area");
                    startActivity(intent);
                } else if (position == 1) {
                    System.out.println("binary");
                    unitFrom = new ArrayList<Unit>();
                    Unit u = new Unit("Base-N", "Decimal (dec)", 10.0);
                    Unit u2 = new Unit("Base-N", "HexaDecimal (hex)", 6.0);
                    Unit u3 = new Unit("Base-N", "Binary (bin)", 2.0);
                    Unit u4 = new Unit("Base-N", "Octal (oct)", 8.0);
                    unitFrom.add(u);
                    unitFrom.add(u2);
                    unitFrom.add(u3);
                    unitFrom.add(u4);
                    Intent intent = new Intent(ConverterMenuActivity.this, ConvertCoefficientActivity.class);
                    Bundle args = new Bundle();
                    args.putSerializable("ARRAYLIST", (Serializable) unitFrom);
                    intent.putExtra("FROM", args);
                    intent.putExtra("TITLE","Base-N");
                    startActivity(intent);
                } else if (position == 2) {
                    System.out.println("currency");
                    unitFrom = new ArrayList<Unit>();
                    Unit u = new Unit("currency", "Vietnam Dong (VND)", 1.0);
                    Unit u2 = new Unit("currency", "US Dollar (USD)", 23081.0);
                    Unit u3 = new Unit("currency", "Euro (EUR)", 27465.70);
                    Unit u4 = new Unit("currency", "Korean Won(KRW)", 20.44);
                    Unit u5 = new Unit("currency", "Japanese Yen(JPY)", 212.37);
                    Unit u6 = new Unit("currency", "Chinese Yuan(RMB)", 3545.80);
                    Unit u7 = new Unit("currency", "Malaysian Ringgit(MYR)", 5613.90);
                    unitFrom.add(u);
                    unitFrom.add(u2);
                    unitFrom.add(u3);
                    unitFrom.add(u4);
                    unitFrom.add(u5);
                    unitFrom.add(u6);
                    unitFrom.add(u7);
                    Intent intent = new Intent(ConverterMenuActivity.this, ConvertActivity.class);
                    Bundle args = new Bundle();
                    args.putSerializable("ARRAYLIST", (Serializable) unitFrom);
                    intent.putExtra("FROM", args);
                    intent.putExtra("TITLE","Currency");
                    startActivity(intent);
                } else if (position == 3) {
                    System.out.println("length");
                    unitFrom = new ArrayList<Unit>();
                Unit u1 = new Unit("length","Kilometer (km)",1000000.0);
                Unit u2 = new Unit("length","Decimeter (dm)",100.0);
                Unit u3 = new Unit("length","Meter (m)",1000.0);
                Unit u4 = new Unit("length","Centimeter(cm)",10.0);
                Unit u5 = new Unit("length","Millimeter(mm)",1.0);
                Unit u6 = new Unit("length","Inch (in)",25.4);
                Unit u7 = new Unit("length","Mile (mi)",1609344.0);
                Unit u8 = new Unit("length","Yard (yd)",914.4);
                Unit u9 = new Unit("length","Foot (ft)",304.8);
                unitFrom.add(u1);
                unitFrom.add(u2);
                unitFrom.add(u3);
                unitFrom.add(u4);
                unitFrom.add(u5);
                unitFrom.add(u6);
                unitFrom.add(u7);
                Intent intent = new Intent(ConverterMenuActivity.this, ConvertActivity.class);
                Bundle args = new Bundle();
                args.putSerializable("ARRAYLIST",(Serializable) unitFrom);
                intent.putExtra("FROM",args);
                intent.putExtra("TITLE","Length");
                startActivity(intent);
                } else if (position == 4) {
                    System.out.println("pressure");
                    unitFrom = new ArrayList<Unit>();
                Unit u1 = new Unit("pressure","pascal (Pa)",1.0);
                Unit u2 = new Unit("pressure","kilopascal (kPa)",1000.0);
                Unit u3 = new Unit("pressure","bar",100000.0);
                Unit u4 = new Unit("pressure","psi",6894.7572932);
                Unit u5 = new Unit("pressure","ksi",6894757.2932);
                Unit u6 = new Unit("pressure","Standard atmosphere (atm)",101325.0);
                unitFrom.add(u1);
                unitFrom.add(u2);
                unitFrom.add(u3);
                unitFrom.add(u4);
                unitFrom.add(u5);
                unitFrom.add(u6);
                Intent intent = new Intent(ConverterMenuActivity.this, ConvertActivity.class);
                Bundle args = new Bundle();
                args.putSerializable("ARRAYLIST",(Serializable) unitFrom);
                intent.putExtra("FROM",args);
                    intent.putExtra("TITLE","Pressure");
                startActivity(intent);
                } else if (position == 5) {
                    System.out.println("speed");
                    unitFrom = new ArrayList<Unit>();
                Unit u1 = new Unit("velocity","Meter/second (m/s)",3.6);
                Unit u2 = new Unit("velocity","Kilometer/hour (km/h)",1.0);
                Unit u3 = new Unit("velocity","Kilometer/second (km/s)",3600.0);
                Unit u4 = new Unit("velocity","Foot/hour (ft/h)",0.0003048);
                Unit u5 = new Unit("velocity","Foot/second (ft/s)",1.09728);
                Unit u6 = new Unit("velocity","Mile/hour (mi/h)",1.609344);
                Unit u7 = new Unit("velocity","Mile/second (mi/s)",5793.6384);
                Unit u8 = new Unit("velocity","Earth velocity",60012.0);
                unitFrom.add(u1);
                unitFrom.add(u2);
                unitFrom.add(u3);
                unitFrom.add(u4);
                unitFrom.add(u5);
                unitFrom.add(u6);
                unitFrom.add(u7);
                unitFrom.add(u8);
                Intent intent = new Intent(ConverterMenuActivity.this, ConvertActivity.class);
                Bundle args = new Bundle();
                args.putSerializable("ARRAYLIST",(Serializable) unitFrom);
                intent.putExtra("FROM",args);
                    intent.putExtra("TITLE","Speed");
                startActivity(intent);
                } else if (position == 6) {
                    System.out.println("time");
                    unitFrom = new ArrayList<Unit>();
                Unit u1 = new Unit("time","Second (s)",1.0);
                Unit u2 = new Unit("time","Millisecond (ms)",60.0);
                Unit u3 = new Unit("time","Minute (min)",60.0);
                Unit u4 = new Unit("time","Hour (h)",3600.0);
                Unit u5 = new Unit("time","Day",86400.0);
                Unit u6 = new Unit("time","Week",604800.0);
                Unit u7 = new Unit("time","Month",2628000.0);
                Unit u8 = new Unit("time","Year",31536000.0);
                Unit u9 = new Unit("time","Decade",315360000.0);
                Unit u10 = new Unit("time","Century",3153600000.0);
                unitFrom.add(u1);
                unitFrom.add(u2);
                unitFrom.add(u3);
                unitFrom.add(u4);
                unitFrom.add(u5);
                unitFrom.add(u6);
                unitFrom.add(u7);
                unitFrom.add(u8);
                unitFrom.add(u9);
                unitFrom.add(u10);
                Intent intent = new Intent(ConverterMenuActivity.this, ConvertActivity.class);
                Bundle args = new Bundle();
                args.putSerializable("ARRAYLIST",(Serializable) unitFrom);
                intent.putExtra("FROM",args);
                    intent.putExtra("TITLE","Time");
                startActivity(intent);
                } else if (position == 7) {
                    System.out.println("volume");
                    unitFrom = new ArrayList<Unit>();
                Unit u1 = new Unit("volume","Cubic Kilometer (km^3)",1000000000000000000.0);
                Unit u2 = new Unit("volume","Cubic Meter (m^3)",1000000000.0);
                Unit u3 = new Unit("volume","Cubic Centimeter(cm^3)",1000.0);
                Unit u4 = new Unit("volume","Cubic Millimeter(mm^3)",1.0);
                Unit u5 = new Unit("volume","Liter (l)",1000000.0);
                Unit u6 = new Unit("volume","Milliliter (ml)",1000.4);
                Unit u7 = new Unit("volume","Gallon (gal)",836127.36);
                Unit u8 = new Unit("volume","Quart (qt)",946352.946);
                Unit u9 = new Unit("volume","Pint (pt)",2589988110336.0);
                Unit u10 = new Unit("volume","Cubic Inch (in^3)",16387.064);
                Unit u11 = new Unit("volume","Cubic Mile (mi^3)",4168181825440539600.0);
                Unit u12 = new Unit("volume","Cubic Yard (yd^3)",764554857.98);
                Unit u13 = new Unit("volume","Cubic Foot (ft^3)",28316846.592);
                unitFrom.add(u1);
                unitFrom.add(u2);
                unitFrom.add(u3);
                unitFrom.add(u4);
                unitFrom.add(u5);
                unitFrom.add(u6);
                unitFrom.add(u7);
                unitFrom.add(u8);
                unitFrom.add(u9);
                unitFrom.add(u10);
                unitFrom.add(u11);
                unitFrom.add(u12);
                unitFrom.add(u13);
                Intent intent = new Intent(ConverterMenuActivity.this, ConvertActivity.class);
                Bundle args = new Bundle();
                args.putSerializable("ARRAYLIST",(Serializable) unitFrom);
                intent.putExtra("FROM",args);
                    intent.putExtra("TITLE","Volume");
                startActivity(intent);
                } else if (position == 8) {
                    unitFrom = new ArrayList<Unit>();
                    Unit u = new Unit("weight", "Kilogram (kg)", 1000.0);
                    Unit u2 = new Unit("weight", "Gram (g)", 1.0);
                    Unit u3 = new Unit("weight", "Pound (lbs)", 28.3495231);
                    Unit u4 = new Unit("weight", "Ounce(oz)", 453.59237);
                    Unit u5 = new Unit("weight", "Ton(t)", 1000000.0);
                    Unit u6 = new Unit("weight", "Carat(ct)", 0.2);
                    unitFrom.add(u);
                    unitFrom.add(u2);
                    unitFrom.add(u3);
                    unitFrom.add(u4);
                    unitFrom.add(u5);
                    unitFrom.add(u6);
                    Intent intent = new Intent(ConverterMenuActivity.this, ConvertActivity.class);
                    Bundle args = new Bundle();
                    args.putSerializable("ARRAYLIST", (Serializable) unitFrom);
                    intent.putExtra("FROM", args);
                    intent.putExtra("TITLE","Weight");
                    startActivity(intent);
                }

            }
        });
//        btn_weight = findViewById(R.id.btn_weight);
//        btn_currency = findViewById(R.id.btn_currency);
//        btn_length=findViewById(R.id.btn_length);
//        btn_area=findViewById(R.id.btn_area);
//        btn_pressure=findViewById(R.id.btn_pressure);
//        btn_velocity=findViewById(R.id.btn_velocity);
//        btn_volume=findViewById(R.id.btn_volume);
//        btn_time=findViewById(R.id.btn_time);
//        btn_base=findViewById(R.id.btn_base);
//        btn_weight.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                unitFrom = new ArrayList<Unit>();
//                Unit u = new Unit("weight","Kilogram (kg)",1000.0);
//                Unit u2 = new Unit("weight","Gram (g)",1.0);
//                Unit u3 = new Unit("weight","Pound (lbs)",28.3495231);
//                Unit u4 = new Unit("weight","Ounce(oz)",453.59237);
//                Unit u5 = new Unit("weight","Ton(t)",1000000.0);
//                Unit u6 = new Unit("weight","Carat(ct)",0.2);
//                unitFrom.add(u);
//                unitFrom.add(u2);
//                unitFrom.add(u3);
//                unitFrom.add(u4);
//                unitFrom.add(u5);
//                unitFrom.add(u6);
//                Intent intent = new Intent(ConverterMenuActivity.this, ConvertActivity.class);
//                Bundle args = new Bundle();
//                args.putSerializable("ARRAYLIST",(Serializable) unitFrom);
//                intent.putExtra("FROM",args);
//                startActivity(intent);
//            }
//        });
//
//        btn_currency.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                unitFrom = new ArrayList<Unit>();
//                Unit u = new Unit("currency","Vietnam Dong (VND)",1.0);
//                Unit u2 = new Unit("currency","US Dollar (USD)",23081.0);
//                Unit u3 = new Unit("currency","Euro (EUR)",27465.70);
//                Unit u4 = new Unit("currency","Korean Won(KRW)",20.44);
//                Unit u5 = new Unit("currency","Japanese Yen(JPY)",212.37);
//                Unit u6 = new Unit("currency","Chinese Yuan(RMB)",3545.80);
//                Unit u7 = new Unit("currency","Malaysian Ringgit(MYR)",5613.90);
//                unitFrom.add(u);
//                unitFrom.add(u2);
//                unitFrom.add(u3);
//                unitFrom.add(u4);
//                unitFrom.add(u5);
//                unitFrom.add(u6);
//                unitFrom.add(u7);
//                Intent intent = new Intent(ConverterMenuActivity.this, ConvertActivity.class);
//                Bundle args = new Bundle();
//                args.putSerializable("ARRAYLIST",(Serializable) unitFrom);
//                intent.putExtra("FROM",args);
//                startActivity(intent);
//            }
//        });
//
//        btn_length.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                unitFrom = new ArrayList<Unit>();
//                Unit u1 = new Unit("length","Kilometer (km)",1000000.0);
//                Unit u2 = new Unit("length","Decimeter (dm)",100.0);
//                Unit u3 = new Unit("length","Meter (m)",1000.0);
//                Unit u4 = new Unit("length","Centimeter(cm)",10.0);
//                Unit u5 = new Unit("length","Millimeter(mm)",1.0);
//                Unit u6 = new Unit("length","Inch (in)",25.4);
//                Unit u7 = new Unit("length","Mile (mi)",1609344.0);
//                Unit u8 = new Unit("length","Yard (yd)",914.4);
//                Unit u9 = new Unit("length","Foot (ft)",304.8);
//                unitFrom.add(u1);
//                unitFrom.add(u2);
//                unitFrom.add(u3);
//                unitFrom.add(u4);
//                unitFrom.add(u5);
//                unitFrom.add(u6);
//                unitFrom.add(u7);
//                Intent intent = new Intent(ConverterMenuActivity.this, ConvertActivity.class);
//                Bundle args = new Bundle();
//                args.putSerializable("ARRAYLIST",(Serializable) unitFrom);
//                intent.putExtra("FROM",args);
//                startActivity(intent);
//            }
//        });
//
//        btn_area.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                unitFrom = new ArrayList<Unit>();
//                Unit u1 = new Unit("area","Square Kilometer (km^2)",1000000000000.0);
//                Unit u2 = new Unit("area","Square Meter (m^2)",1000000.0);
//                Unit u3 = new Unit("area","Square Centimeter(cm^2)",100.0);
//                Unit u4 = new Unit("area","Square Millimeter(mm^2)",1.0);
//                Unit u5 = new Unit("area","Square Hectare (ha)",10000000000.0);
//                Unit u6 = new Unit("area","Square Arce (ac)",4046856422.4);
//                Unit u7 = new Unit("area","Square Yard (yd^2)",836127.36);
//                Unit u8 = new Unit("area","Square Foot (ft^2)",92903.04);
//                Unit u9 = new Unit("area","Square Mile (mi^2)",2589988110336.0);
//                Unit u10 = new Unit("area","Square Inch (in^2)",2589988110336.0);
//                unitFrom.add(u1);
//                unitFrom.add(u2);
//                unitFrom.add(u3);
//                unitFrom.add(u4);
//                unitFrom.add(u5);
//                unitFrom.add(u6);
//                unitFrom.add(u7);
//                Intent intent = new Intent(ConverterMenuActivity.this, ConvertActivity.class);
//                Bundle args = new Bundle();
//                args.putSerializable("ARRAYLIST",(Serializable) unitFrom);
//                intent.putExtra("FROM",args);
//                startActivity(intent);
//            }
//        });
//
//        btn_pressure.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                unitFrom = new ArrayList<Unit>();
//                Unit u1 = new Unit("pressure","pascal (Pa)",1.0);
//                Unit u2 = new Unit("pressure","kilopascal (kPa)",1000.0);
//                Unit u3 = new Unit("pressure","bar",100000.0);
//                Unit u4 = new Unit("pressure","psi",6894.7572932);
//                Unit u5 = new Unit("pressure","ksi",6894757.2932);
//                Unit u6 = new Unit("pressure","Standard atmosphere (atm)",101325.0);
//                unitFrom.add(u1);
//                unitFrom.add(u2);
//                unitFrom.add(u3);
//                unitFrom.add(u4);
//                unitFrom.add(u5);
//                unitFrom.add(u6);
//                Intent intent = new Intent(ConverterMenuActivity.this, ConvertActivity.class);
//                Bundle args = new Bundle();
//                args.putSerializable("ARRAYLIST",(Serializable) unitFrom);
//                intent.putExtra("FROM",args);
//                startActivity(intent);
//            }
//        });
//
//        btn_velocity.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                unitFrom = new ArrayList<Unit>();
//                Unit u1 = new Unit("velocity","Meter/second (m/s)",3.6);
//                Unit u2 = new Unit("velocity","Kilometer/hour (km/h)",1.0);
//                Unit u3 = new Unit("velocity","Kilometer/second (km/s)",3600.0);
//                Unit u4 = new Unit("velocity","Foot/hour (ft/h)",0.0003048);
//                Unit u5 = new Unit("velocity","Foot/second (ft/s)",1.09728);
//                Unit u6 = new Unit("velocity","Mile/hour (mi/h)",1.609344);
//                Unit u7 = new Unit("velocity","Mile/second (mi/s)",5793.6384);
//                Unit u8 = new Unit("velocity","Earth velocity",60012.0);
//                unitFrom.add(u1);
//                unitFrom.add(u2);
//                unitFrom.add(u3);
//                unitFrom.add(u4);
//                unitFrom.add(u5);
//                unitFrom.add(u6);
//                unitFrom.add(u7);
//                unitFrom.add(u8);
//                Intent intent = new Intent(ConverterMenuActivity.this, ConvertActivity.class);
//                Bundle args = new Bundle();
//                args.putSerializable("ARRAYLIST",(Serializable) unitFrom);
//                intent.putExtra("FROM",args);
//                startActivity(intent);
//            }
//        });
//
//        btn_volume.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                unitFrom = new ArrayList<Unit>();
//                Unit u1 = new Unit("volume","Cubic Kilometer (km^3)",1000000000000000000.0);
//                Unit u2 = new Unit("volume","Cubic Meter (m^3)",1000000000.0);
//                Unit u3 = new Unit("volume","Cubic Centimeter(cm^3)",1000.0);
//                Unit u4 = new Unit("volume","Cubic Millimeter(mm^3)",1.0);
//                Unit u5 = new Unit("volume","Liter (l)",1000000.0);
//                Unit u6 = new Unit("volume","Milliliter (ml)",1000.4);
//                Unit u7 = new Unit("volume","Gallon (gal)",836127.36);
//                Unit u8 = new Unit("volume","Quart (qt)",946352.946);
//                Unit u9 = new Unit("volume","Pint (pt)",2589988110336.0);
//                Unit u10 = new Unit("volume","Cubic Inch (in^3)",16387.064);
//                Unit u11 = new Unit("volume","Cubic Mile (mi^3)",4168181825440539600.0);
//                Unit u12 = new Unit("volume","Cubic Yard (yd^3)",764554857.98);
//                Unit u13 = new Unit("volume","Cubic Foot (ft^3)",28316846.592);
//                unitFrom.add(u1);
//                unitFrom.add(u2);
//                unitFrom.add(u3);
//                unitFrom.add(u4);
//                unitFrom.add(u5);
//                unitFrom.add(u6);
//                unitFrom.add(u7);
//                unitFrom.add(u8);
//                unitFrom.add(u9);
//                unitFrom.add(u10);
//                unitFrom.add(u11);
//                unitFrom.add(u12);
//                unitFrom.add(u13);
//                Intent intent = new Intent(ConverterMenuActivity.this, ConvertActivity.class);
//                Bundle args = new Bundle();
//                args.putSerializable("ARRAYLIST",(Serializable) unitFrom);
//                intent.putExtra("FROM",args);
//                startActivity(intent);
//            }
//        });
//
//        btn_time.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                unitFrom = new ArrayList<Unit>();
//                Unit u1 = new Unit("time","Second (s)",1.0);
//                Unit u2 = new Unit("time","Millisecond (ms)",60.0);
//                Unit u3 = new Unit("time","Minute (min)",60.0);
//                Unit u4 = new Unit("time","Hour (h)",3600.0);
//                Unit u5 = new Unit("time","Day",86400.0);
//                Unit u6 = new Unit("time","Week",604800.0);
//                Unit u7 = new Unit("time","Month",2628000.0);
//                Unit u8 = new Unit("time","Year",31536000.0);
//                Unit u9 = new Unit("time","Decade",315360000.0);
//                Unit u10 = new Unit("time","Century",3153600000.0);
//                unitFrom.add(u1);
//                unitFrom.add(u2);
//                unitFrom.add(u3);
//                unitFrom.add(u4);
//                unitFrom.add(u5);
//                unitFrom.add(u6);
//                unitFrom.add(u7);
//                unitFrom.add(u8);
//                unitFrom.add(u9);
//                unitFrom.add(u10);
//                Intent intent = new Intent(ConverterMenuActivity.this, ConvertActivity.class);
//                Bundle args = new Bundle();
//                args.putSerializable("ARRAYLIST",(Serializable) unitFrom);
//                intent.putExtra("FROM",args);
//                startActivity(intent);
//            }
//        });
//        btn_base.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                unitFrom = new ArrayList<Unit>();
//                Unit u = new Unit("String","Decimal (dec)",10.0);
//                Unit u2 = new Unit("String","HexaDecimal (hex)",6.0);
//                Unit u3 = new Unit("String","Binary (bin)",2.0);
//                Unit u4 = new Unit("String","Octal (oct)",8.0);
//                unitFrom.add(u);
//                unitFrom.add(u2);
//                unitFrom.add(u3);
//                unitFrom.add(u4);
//                Intent intent = new Intent(ConverterMenuActivity.this, ConvertCoefficientActivity.class);
//                Bundle args = new Bundle();
//                args.putSerializable("ARRAYLIST",(Serializable) unitFrom);
//                intent.putExtra("FROM",args);
//                startActivity(intent);
//            }
//        });
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