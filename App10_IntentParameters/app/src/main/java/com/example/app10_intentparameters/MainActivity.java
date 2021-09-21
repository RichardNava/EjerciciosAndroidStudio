package com.example.app10_intentparameters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etName = (EditText) findViewById(R.id.txt_name);
    }

    // Método para enviar el nombre
    public void SendName(View view){
        Intent nextData = new Intent(this, ActivityParameter2.class);
        // putExtra() nos sirve para guardar información entre Activitys
        nextData.putExtra("data", etName.getText().toString());
        startActivity(nextData);
    }
}