package com.example.mma;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {
    private double firstNumber;
    private double secondNumber;
    private boolean checkTurn = false;
    private String operator = "";
    private double result = 0;
    private double memory = 0;
    private TextView tv_screen;
    private Button btn_one;
    private Button btn_two;
    private Button btn_three;
    private Button btn_four;
    private Button btn_five;
    private Button btn_six;
    private Button btn_seven;
    private Button btn_eight;
    private Button btn_nine;
    private Button btn_zero;
    private Button btn_add;
    private Button btn_subtract;
    private Button btn_multiply;
    private Button btn_divide;
    private Button btn_dot;
    private Button btn_percent;
    private Button btn_reverse;
    private Button btn_inverse;
    private Button btn_sqrt;
    private Button btn_equal;
    private Button btn_del;
    private Button btn_ac;
    private Button btn_mc;
    private Button btn_mr;
    private Button btn_ms;
    private Button btn_madd;
    private Button btn_msub;
    private boolean isError = false;
    private boolean reset = false;
    private DecimalFormat dec = new DecimalFormat("#.########");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        //Back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Calculator");
        btn_one = findViewById(R.id.btn_one);
        btn_two = findViewById(R.id.btn_two);
        btn_three = findViewById(R.id.btn_three);
        btn_four = findViewById(R.id.btn_four);
        btn_five = findViewById(R.id.btn_five);
        btn_six = findViewById(R.id.btn_six);
        btn_seven = findViewById(R.id.btn_seven);
        btn_eight = findViewById(R.id.btn_eight);
        btn_nine = findViewById(R.id.btn_nine);
        btn_zero = findViewById(R.id.btn_zero);
        btn_add = findViewById(R.id.btn_add);
        btn_subtract = findViewById(R.id.btn_subtract);
        btn_multiply = findViewById(R.id.btn_multiply);
        btn_divide = findViewById(R.id.btn_divide);
        btn_dot = findViewById(R.id.btn_dot);
        btn_percent = findViewById(R.id.btn_percent);
        btn_reverse = findViewById(R.id.btn_reverse);
        btn_inverse = findViewById(R.id.btn_inverse);
        btn_sqrt = findViewById(R.id.btn_sqrt);
        btn_equal = findViewById(R.id.btn_equal);
        btn_del = findViewById(R.id.btn_del);
        btn_ac = findViewById(R.id.btn_ac);
        btn_mc = findViewById(R.id.btn_mc);
        btn_mr = findViewById(R.id.btn_mr);
        btn_ms = findViewById(R.id.btn_ms);
        btn_madd = findViewById(R.id.btn_madd);
        btn_msub = findViewById(R.id.btn_msub);
        tv_screen = findViewById(R.id.tv_screen);
        btn_one.setOnClickListener(this);
        btn_two.setOnClickListener(this);
        btn_three.setOnClickListener(this);
        btn_four.setOnClickListener(this);
        btn_five.setOnClickListener(this);
        btn_six.setOnClickListener(this);
        btn_seven.setOnClickListener(this);
        btn_eight.setOnClickListener(this);
        btn_nine.setOnClickListener(this);
        btn_zero.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        btn_subtract.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_dot.setOnClickListener(this);
        btn_percent.setOnClickListener(this);
        btn_reverse.setOnClickListener(this);
        btn_inverse.setOnClickListener(this);
        btn_sqrt.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_ac.setOnClickListener(this);
        btn_mc.setOnClickListener(this);
        btn_mr.setOnClickListener(this);
        btn_ms.setOnClickListener(this);
        btn_madd.setOnClickListener(this);
        btn_msub.setOnClickListener(this);
        tv_screen = findViewById(R.id.tv_screen);
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
    public void pressNumber(TextView text, Button btn) {

        if (!isError) {
            String value = btn.getText().toString();
            //when first number is pressed
            if (checkTurn) {
                text.setText("0");
                checkTurn = false;
            }
            String s = text.getText().toString();
            if (s.startsWith("0") && !s.startsWith("0.")) {
                s = s.substring(1);
            }
            text.setText(s + value);
            assignValue();
            reset = false;
        }
    }

    public void setOperator(String operator) {
        this.operator = operator;
        checkTurn = true;
    }

    public void assignValue() {
        if (operator.equals("")) {
            firstNumber = getValue();
        } else {
            secondNumber = getValue();
        }
    }

    public double getValue() {
        return Double.parseDouble(tv_screen.getText().toString());
    }

    public void pressDot() {
        if (!isError) {
            if (checkTurn) {
                tv_screen.setText("0");
                checkTurn = false;
            }
            if (!tv_screen.getText().toString().contains(".")) {
                tv_screen.setText(tv_screen.getText() + ".");
            }
        }
    }

    public void pressAllClear() {
        firstNumber = 0;
        secondNumber = 0;
        operator = "";
        memory = 0;
        isError = false;
        tv_screen.setText("0");
    }

    public void pressNeg(TextView txtScreen) {
        if (!isError && !txtScreen.getText().equals("0")) {
            String text = txtScreen.getText().toString();
            //Check number has negative or positive
            if (!text.contains("-")) {
                txtScreen.setText("-" + text);
                firstNumber = getValue();
            } else {
                txtScreen.setText(text.substring(1, text.length()));
                firstNumber = getValue();
            }

        }
    }

    public String validateResult(String value) {
        if (value.startsWith("0") && !value.startsWith("0.")) {
            value = value.substring(1, value.length());
        }
        if (value.endsWith(".0")) {
            value = value.substring(0, value.length() - 2);
        }
        while (value.contains(".") && value.endsWith("0")) {
            value = value.substring(0, value.length() - 1);
        }
        double m = Double.parseDouble(value);
        String s = dec.format(m);
        return s;
    }

    public void calculate() {
        if (!checkTurn) {
            switch (operator) {
                case "+":
                    firstNumber = firstNumber + (secondNumber);
                    break;

                case "-":
                    firstNumber = firstNumber - (secondNumber);
                    break;

                case "*":
                    firstNumber = firstNumber * (secondNumber);
                    break;

                case "/":
                    if (secondNumber == 0) {
                        isError = true;
                        tv_screen.setText("ERROR");
                        break;
                    }
                    firstNumber = firstNumber / (secondNumber);
                    break;
            }

            if (!isError) {
                String value = validateResult(firstNumber + "");
                tv_screen.setText(value);
                checkTurn = true;
            }
        }
    }

    public void printResult() {
        calculate();
        checkTurn = true;
        operator = "";
        reset = true;
    }

    public void pressPercent() {
        try {
            double value = getValue();
            tv_screen.setText(validateResult(value / 100 + ""));
            System.out.println(validateResult(value / 100 + ""));
            assignValue();

        } catch (Exception e) {
            tv_screen.setText("ERROR");
        }
        reset = true;
    }

    public void pressSqrt() {
        double value = Math.sqrt(getValue());
        String s = "" + value;
        if (s.equals("NaN")) {
            isError = true;
            tv_screen.setText("ERROR");
        } else {
            tv_screen.setText(validateResult(s));
            assignValue();
            checkTurn = true;
        }
        reset = true;
    }

    public void pressInverse() {
        try {
            tv_screen.setText(1 / getValue() + "");
            assignValue();
            checkTurn = true;
        } catch (Exception e) {
            tv_screen.setText("ERROR");
        }
        reset = true;
    }

    public void pressMC() {
        memory = 0;
        reset = true;
    }

    public void pressMS() {
        memory = getValue();
        checkTurn = true;
        reset = true;
    }

    public void pressMadd() {
        try {
            memory = memory + (getValue());
            checkTurn = true;
        } catch (Exception e) {
            tv_screen.setText("ERROR");
        }
        reset = true;
    }

    public void pressMsub() {
        try {
            memory = memory - (getValue());
            checkTurn = true;
        } catch (Exception e) {
            tv_screen.setText("ERROR");
        }
        reset = true;
    }

    public void pressMR() {
        tv_screen.setText(validateResult(memory + ""));
        assignValue();
        checkTurn = true;
        reset = true;
    }

    public void pressBack() {
        if (!reset && !checkTurn) {
            String value = tv_screen.getText().toString();
            if (value.length() == 2 && value.contains(".")) {
                tv_screen.setText("0");
            }
            if (value.length() > 2 || value.contains(".")) {
                tv_screen.setText(value.substring(0, value.length() - 1));
            }
            if (value.length() == 2 && value.startsWith("-")) {
                tv_screen.setText("0");
            } else {
                tv_screen.setText(value.substring(0, value.length() - 1));
            }
            if (value.length() == 1) {
                tv_screen.setText("0");
            }
            assignValue();
            checkTurn = false;
        }
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_one:
                pressNumber(tv_screen,(Button) v);
                break;
            case R.id.btn_two:
                pressNumber(tv_screen,(Button) v);
                break;
            case R.id.btn_three:
                pressNumber(tv_screen,(Button) v);
                break;
            case R.id.btn_four:
                pressNumber(tv_screen,(Button) v);
                break;
            case R.id.btn_five:
                pressNumber(tv_screen,(Button) v);
                break;
            case R.id.btn_six:
                pressNumber(tv_screen,(Button) v);
                break;
            case R.id.btn_seven:
                pressNumber(tv_screen,(Button) v);
                break;
            case R.id.btn_eight:
                pressNumber(tv_screen,(Button) v);
                break;
            case R.id.btn_nine:
                pressNumber(tv_screen,(Button) v);
                break;
            case R.id.btn_zero:
                pressNumber(tv_screen,(Button) v);
                break;
            case R.id.btn_del:
                pressBack();
                break;
            case R.id.btn_ac:
                pressAllClear();
                break;
            case R.id.btn_add:
                setOperator("+");
                break;
            case R.id.btn_subtract:
                setOperator("-");
                break;
            case R.id.btn_multiply:
                setOperator("*");
                break;
            case R.id.btn_divide:
                setOperator("/");
                break;
            case R.id.btn_equal:
                printResult();
                break;
            case R.id.btn_sqrt:
                pressSqrt();
                break;
            case R.id.btn_inverse:
                pressInverse();
                break;
            case R.id.btn_reverse:
                pressNeg(tv_screen);
                break;
            case R.id.btn_dot:
                pressDot();
                break;
            case R.id.btn_percent:
                pressPercent();
                break;
            case R.id.btn_ms:
                pressMS();
                break;
            case R.id.btn_mr:
                pressMR();
                break;
            case R.id.btn_mc:
                pressMC();
                break;
            case R.id.btn_madd:
                pressMR();
                break;
            case R.id.btn_msub:
                pressMR();
                break;
        }
    }
}