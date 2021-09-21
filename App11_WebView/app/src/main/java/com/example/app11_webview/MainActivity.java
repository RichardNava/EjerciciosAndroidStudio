package com.example.app11_webview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etURL = (EditText) findViewById(R.id.txt_url);

    }
    // Método botón "IR A"
    public void WebFind(View view){
        Intent webInt = new Intent(this,WebActivity.class);
        webInt.putExtra("URL", etURL.getText().toString());
        startActivity(webInt);
    }
}