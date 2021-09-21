package com.example.app3_radiocalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etNum1, etNum2;
    private TextView tvResult;
    private RadioButton rbSum,rbSub,rbMult,rbDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = (EditText) findViewById(R.id.txt_num1);
        etNum2 = (EditText) findViewById(R.id.txt_num2);
        tvResult = (TextView) findViewById(R.id.tv_result);
        rbSum = (RadioButton) findViewById(R.id.rb_sum);
        rbSub = (RadioButton) findViewById(R.id.rb_subtract);
        rbMult = (RadioButton) findViewById(R.id.rb_multiply);
        rbDiv = (RadioButton) findViewById(R.id.rb_divide);
    }

    // Método para calcular (En función de la eleccion del usuario en los botones de tipo radio)
    public void Calculate(View view){
        double value1 = Double.parseDouble(etNum1.getText().toString());
        double value2 = Double.parseDouble(etNum2.getText().toString());

        if (rbSum.isChecked()){ // El método isChecked() de RadiButton nos devuelve true/false en función de si la opción ha sido seleccionada o no
            tvResult.setText(String.valueOf(value1+value2));
        }
        else if(rbSub.isChecked()){
            tvResult.setText(String.valueOf(value1-value2));
        }
        else if(rbMult.isChecked()){
            tvResult.setText(String.valueOf(value1*value2));
        }
        else if(rbDiv.isChecked()){
            if (value2 != 0){
                tvResult.setText(String.valueOf(value1/value2));
            }
            else{
                Toast.makeText(this, "No se puede dividir entre 0. Introduzca otro número.", Toast.LENGTH_LONG).show();
            }
        }
    }
}