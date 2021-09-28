package com.example.app18_iconactionbar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    final ActionBar actionBar = getActionBar();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Para que se vea siempre el Icono en el ActionBar
        actionBar.setDisplayShowTitleEnabled(false);
        //getSupportActionBar().setIcon(R.mipmap.ic_launcher);
    }
}