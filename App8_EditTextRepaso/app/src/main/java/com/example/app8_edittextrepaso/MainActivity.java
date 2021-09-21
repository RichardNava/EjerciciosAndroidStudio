package com.example.app8_edittextrepaso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.txt_name);
        etPassword = (EditText) findViewById(R.id.txt_password);

    }

    // Método para dar una acciuón al botón gracias al onClick()
    public void Login(View view){
        String name = etName.getText().toString();
        String password = etPassword.getText().toString();

        if (name.length()==0){
            Toast.makeText(this, "Debe introducir un nombre", Toast.LENGTH_SHORT).show();
        }
        if (password.length()==0){
            Toast.makeText(this, "Debe introducir un password", Toast.LENGTH_SHORT).show();
        }
        if (name.length() !=0 && password.length() !=0){
            Toast.makeText(this, "Registro en proceso", Toast.LENGTH_SHORT).show();
        }
    }
}