package com.example.app13_sharedpreferencesagenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.txt_name);
        etData = (EditText) findViewById(R.id.txt_multi);

    }

    // Método para guardar la información en el SharedPreference
    public void Save (View view){
        String name = etName.getText().toString();
        String data = etData.getText().toString();

        SharedPreferences preferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor = preferences.edit();

        obj_editor.putString(name,data);
        obj_editor.commit();

        Toast.makeText(this, "Datos almacenados con éxito", Toast.LENGTH_SHORT).show();
    }

    // Método para buscar la información en el SharedPreference
    public void Find(View view){
        String name = etName.getText().toString();

        SharedPreferences preferences = getSharedPreferences("data", Context.MODE_PRIVATE);

        String data = preferences.getString(name,"");

        if (data.length() != 0){
            etData.setText(data);
        }
        else{
            Toast.makeText(this, "No se han encontrado datos con el nombre indicado", Toast.LENGTH_SHORT).show();
        }

    }
}