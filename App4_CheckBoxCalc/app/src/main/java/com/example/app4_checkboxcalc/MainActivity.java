package com.example.app4_checkboxcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etNum1,etNum2;
    private TextView tvResult;
    private CheckBox cbSum, cbSub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = (EditText) findViewById(R.id.txt_num1);
        etNum2 = (EditText) findViewById(R.id.txt_num2);
        tvResult = (TextView) findViewById(R.id.tv_result);
        cbSum = (CheckBox) findViewById(R.id.cb_sum);
        cbSub = (CheckBox) findViewById(R.id.cb_subtract);
    }

    // Método para calcular con las distintas opciones que tenemos debido a los CheckBox
    public void Calculate(View view){
        double value1 = Double.parseDouble(etNum1.getText().toString());
        double value2 = Double.parseDouble(etNum2.getText().toString());

        String result = "";

        if (cbSum.isChecked() && cbSub.isChecked()){
            result = "Suma= " + (value1+value2) + " / Resta= " + (value1-value2);
        }
        else if (cbSum.isChecked()){
            result = "Suma= " + (value1+value2);
        }
        else if (cbSub.isChecked()){
            result = "Resta= " + (value1-value2);
        }

        tvResult.setText(result);
    }

}