package com.example.app9_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Creamos método para ir al Activity 2
    public void NextActivity(View view){
        // this = Origen / Activity2.class = Destino
        Intent next = new Intent(this, Activity2.class);
        startActivity(next);
    }
}