package com.example.app22_scrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class OtherActivity extends AppCompatActivity {

    TextView textView;
    String factura = "";
    float precioTotal = 0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        textView = (TextView) findViewById(R.id.textView);

        Intent i = getIntent();
        ArrayList<Frutas> list = (ArrayList<Frutas>) i.getSerializableExtra("list");

        for (Frutas f: list) {
            factura += f.toString();
            precioTotal += f.getPrize();
        }

        textView.setText(factura+"Precio total: "+ precioTotal +" €");
    }
}