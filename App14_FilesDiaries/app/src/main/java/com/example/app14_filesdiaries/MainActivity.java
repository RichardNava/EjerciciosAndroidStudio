package com.example.app14_filesdiaries;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;

public class MainActivity extends AppCompatActivity {

    private EditText etData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etData = (EditText) findViewById(R.id.txt_multi);

        // Necesitamos un Array del tipo String asignada al método Filelist()
        String [] data = fileList();

        if (FileCheck(data,"diaries.txt")){
            try { // Obligatorio el uso de try/catch para envolver excepciones que pueden surgir con el InputStreamReader y el BuffererReader
                // Creamos dos objetos, para leer y escribir en fichero
                InputStreamReader file = new InputStreamReader(openFileInput("diaries.txt"));
                BufferedReader br = new BufferedReader(file);
                // Usamos el método del Br readLine() para leer linea por linea
                String line = br.readLine();
                // Para ir concatenando el texto creamos una variable de tipo String
                String textComplete = "";

                // Creamos un bucle de tipo While (desconocemos el número de iteraciones) para ir completando el texto
                while (line != null){
                    textComplete += line; // textComplete = textComplete + line;
                    line = br.readLine();
                }

                br.close();
                file.close();
                etData.setText(textComplete);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public boolean FileCheck (String [] arrayText, String fileName){ // Función para comprobar que existe un archivo con el nombre indicado
        // Bucle que recorre el Array para encontrar coincidencias con el nombre del archivo
        for (int i = 0; i<arrayText.length;i++){
            if (fileName.equals(arrayText[i])){
                return true; // Devolvemos true cuando encontramos coincidencia
            }
        }
        return false; // Devolvemos false porque no hemos encontrado coincidencia
    }

    public void Save(View view){
        try {
            // Para escribir usamos la clase OutputStreamWriter y el método openFileOutput
            OutputStreamWriter file = new OutputStreamWriter(openFileOutput("diaries.txt", Activity.MODE_PRIVATE));
            // Método Write() para escribir la información recuperada de nuestro EditText Multiline
            file.write(etData.getText().toString());
            file.flush(); // Limpia los datos del buffer
            file.close(); // Cierra el archivo para liberar caché

        } catch (IOException e) {
            e.printStackTrace();
        }
        Toast.makeText(this, "Diario guardado", Toast.LENGTH_SHORT).show();
        finish(); // Cierra el Activity
    }

}