package com.example.app5_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et_num1, et_num2;
    private Button button;
    private TextView tv_result;
    private Spinner sp_ops;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_num1 = (EditText) findViewById(R.id.et_num1);
        et_num2 = (EditText) findViewById(R.id.et_num2);
        tv_result = (TextView) findViewById(R.id.tv_result);
        sp_ops = (Spinner) findViewById(R.id.sp_ops);

        String  options [] = {"suma", "resta", "dividir", "multiplicar"};

        // Objeto de la clase ArrayAdapter para manejar array
        //ArrayAdapter <String> ArrAdapt = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, options);
        ArrayAdapter <String> ArrAdapt = new ArrayAdapter<String>(this, R.layout.mi_spinner, options);
        sp_ops.setAdapter(ArrAdapt);
    }

    public void Calc (View view){
        double num1 = Double.parseDouble(et_num1.getText().toString());
        double num2 = Double.parseDouble(et_num2.getText().toString());
        String result = "";

        String select = sp_ops.getSelectedItem().toString();

        if(select.isEmpty()){
            result = result + "Seleccione una opcion";
        }else{
            if(select.equals("suma")){
                result = result + "Suma: "+String.valueOf(num1+num2);
            }else if(select.equals("resta")){
                result = result + "Resta: "+String.valueOf(num1-num2);
            }else if(select.equals("dividir")){
                result = result + "Division: "+String.valueOf(num1/num2);
            }else if(select.equals("multiplicar")){
                result = result + "Multiplicacion: "+String.valueOf(num1*num2);
            }
        }
        tv_result.setText(result);
    }

}