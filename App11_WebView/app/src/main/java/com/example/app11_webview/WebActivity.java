package com.example.app11_webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {

    WebView wv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        wv1 = (WebView) findViewById(R.id.wv1);
        String URL = getIntent().getStringExtra("URL");
        wv1.setWebViewClient(new WebViewClient()); // Método para asignar un cliente (Vista web) dentro de la aplicación
        wv1.loadUrl(URL); //Método para asignar la URL a la que queremos acceder en nuestro WebView

    }

    public void Close (View view){
        finish();
    }
}