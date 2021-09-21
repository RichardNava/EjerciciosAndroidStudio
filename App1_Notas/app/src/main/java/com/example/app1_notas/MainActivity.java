package com.example.app1_notas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Variables
    private EditText et_mate, et_fisi, et_leng; //EditTest es la clase de todos los textos que puedan editarse

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_mate = (EditText) findViewById(R.id.txt_mates);
        et_fisi = (EditText) findViewById(R.id.txt_fisica);
        et_leng = (EditText) findViewById(R.id.txt_lenguaje);

    }

    // Método para calcular la media de las notas que asignaremos al botón
    public void CalcularMedia(View view){
        int numMate = Integer.parseInt(et_mate.getText().toString());
        int numFisi = Integer.parseInt(et_fisi.getText().toString());
        int numLeng = Integer.parseInt(et_leng.getText().toString());

        int media = (numMate+numFisi+numLeng)/3;

        if(media >= 5){
            Toast.makeText(this, "Estas aprobado con una media de "+media, Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Estas suspendido con una media de "+media, Toast.LENGTH_SHORT).show();
        }
    }


}