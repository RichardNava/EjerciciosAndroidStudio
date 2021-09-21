package com.example.app10_intentparameters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityParameter2 extends AppCompatActivity {

    private TextView tvWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parameter2);


        tvWelcome = (TextView) findViewById(R.id.tv_welcome);

        // con el método getIntent() recuperamos datos guardados dentro de un objeto de tipo Intent.
        String data = getIntent().getStringExtra("data");
        tvWelcome.setText("¡HOLA "+ data.toUpperCase()+"!");
    }

    public void PrevActivity(View view){
        Intent prev = new Intent(this, MainActivity.class);
        startActivity(prev);
    }
}