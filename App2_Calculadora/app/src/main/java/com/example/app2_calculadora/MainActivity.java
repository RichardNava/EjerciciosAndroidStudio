package com.example.app2_calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private EditText etNum1, etNum2;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = (EditText) findViewById(R.id.txt_num1);
        etNum2 = (EditText) findViewById(R.id.txt_num2);
        tvResult = (TextView) findViewById(R.id.tv_result);
    }

    // Método para Sumar
    public void Sum(View view){
        double value1 = Double.parseDouble(etNum1.getText().toString());
        double value2 = Double.parseDouble(etNum2.getText().toString());

        double sum = value1+value2; // Realizamos la operación
        String result = String.valueOf(sum); // Convertimos el dato númerico (Double) a String
        tvResult.setText(result); // Utilizamos el setText() de nuestro componente albergado en la variable para pasarle el texto

    }

    // Método para Restar
    public void Subtract(View view){
        double value1 = Double.parseDouble(etNum1.getText().toString());
        double value2 = Double.parseDouble(etNum2.getText().toString());

        double sub = value1-value2;
        String result = String.valueOf(sub);
        tvResult.setText(result);
    }

    public void Multiply(View view){
        double value1 = Double.parseDouble(etNum1.getText().toString());
        double value2 = Double.parseDouble(etNum2.getText().toString());

        double sub = value1*value2;
        String result = String.valueOf(sub);
        tvResult.setText(result);
    }

    public void Divide(View view){
        double value1 = Double.parseDouble(etNum1.getText().toString());
        double value2 = Double.parseDouble(etNum2.getText().toString());

        if (value2 != 0){
            double sub = value1/value2;
            String result = String.valueOf(sub);
            tvResult.setText(result);
        }
        else{
            Toast.makeText(this, "No se puede dividir entre 0", Toast.LENGTH_SHORT).show();
        }


    }

}