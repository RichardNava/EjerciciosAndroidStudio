package com.example.app12_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = (EditText) findViewById(R.id.txt_email);

        // SharedPreferences es una clase que nos permite guardar datos con persistencia en la información
        // getSharedPreferences nos pide dos argumentos; Nombre (Del lugar en memoria quue vamos a guardar la información) y el Modo de Acceso
        SharedPreferences preferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        //
        etEmail.setText(preferences.getString("email", ""));
    }

    public void Save(View view){
        SharedPreferences pref = getSharedPreferences("data", Context.MODE_PRIVATE);
        // Para editar la información dentro del objeto de la clase SharedPreferences utilizamos el método edit() del Editor de SharedPreferences
        SharedPreferences.Editor obj_editor = pref.edit();
        // Para guardar la información usamos el método putString basado en par clave/valor
        obj_editor.putString("email", etEmail.getText().toString());
        // Para empujar (push) la información y confirmarla.
        obj_editor.commit();
        finish();

    }

}