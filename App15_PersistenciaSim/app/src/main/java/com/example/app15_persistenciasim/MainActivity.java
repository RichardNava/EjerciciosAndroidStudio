package com.example.app15_persistenciasim;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    // Hay que añadir permisos en el Manifest
    private EditText etData, etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.txt_name);
        etData = (EditText) findViewById(R.id.txt_data);
    }

    public void Save(View view){
        String fileName = etName.getText().toString();
        String fileData = etData.getText().toString();

        try {
            // Creamos un objeto de tipo File para guardar la ruta donde se encuentra la tarjeta SD
            // gracias a la información ofrecida por la clase Enviroment
            File sdCard = Environment.getExternalStorageDirectory();
            Toast.makeText(this, sdCard.getPath(), Toast.LENGTH_SHORT).show();
            File filePath = new File(sdCard.getPath(),fileName);

            OutputStreamWriter createFile = new OutputStreamWriter(openFileOutput(fileName, Activity.MODE_PRIVATE));
            createFile.write(fileData);
            createFile.flush();
            createFile.close();

            Toast.makeText(this, "Archivo guardado correctamente", Toast.LENGTH_SHORT).show();
            etName.setText("");
            etData.setText("");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Find( View view){
        String fileName = etName.getText().toString();

        try {
            File sdCard = Environment.getExternalStorageDirectory();
            File filePath = new File(sdCard.getPath(),fileName);

            InputStreamReader openFile = new InputStreamReader(openFileInput(fileName));
            BufferedReader fileReader = new BufferedReader(openFile);

            String line = fileReader.readLine();
            String text = "";

            while (line != null){
                text += line + "\n";
                line = fileReader.readLine();
            }

            fileReader.close();
            openFile.close();
            etData.setText(text);

        }  catch (IOException e) {
            e.printStackTrace();
        }

    }
}