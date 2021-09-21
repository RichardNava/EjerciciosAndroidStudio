package com.example.app6_imagebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageButton i_bt_tea,i_bt_coffe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        i_bt_tea = (ImageButton) findViewById(R.id.i_bt_tea);
        i_bt_coffe = (ImageButton) findViewById(R.id.i_bt_coffe);
    }

    public void seeTea(View view){
        Toast.makeText(this, "Quieres un te???", Toast.LENGTH_SHORT).show();
    }

    public void seeCoffe(View view){
        Toast.makeText(this, "Quieres un cafe???", Toast.LENGTH_SHORT).show();
    }
}