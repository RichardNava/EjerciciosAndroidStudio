package com.example.app16_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etId, etDesc, etPrice;
    // Creamos el administrador de BBDD
    AdminSQLiteOpenHelper databaseAdmin;
    // Creamos la BBDD
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etId = (EditText) findViewById(R.id.txt_id);
        etDesc = (EditText) findViewById(R.id.txt_description);
        etPrice = (EditText) findViewById(R.id.txt_price);
        databaseAdmin = new AdminSQLiteOpenHelper(this, "admin", null, 1);
        database = databaseAdmin.getWritableDatabase();
    }

    // Método para crear el articulo de nuestra tabla articulos de la BBDD
    public void Create(View view){

        String id = etId.getText().toString();
        String description = etDesc.getText().toString();
        String price = etPrice.getText().toString();

        if (!id.isEmpty() && !description.isEmpty() && !price.isEmpty()){
            ContentValues register = new ContentValues();
            register.put("id", id);
            register.put("descripcion", description);
            register.put("precio", price);

            // insert into articulos (description, precio) values ('camisa', 18,50);
            database.insert("articulos", null, register);
            //database.close();

            etId.setText("");
            etDesc.setText("");
            etPrice.setText("");

            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(this, "Debes llenar los campos descripción y precio", Toast.LENGTH_SHORT).show();
        }

    }

    public void Update(View view){

        String id = etId.getText().toString();
        String description = etDesc.getText().toString();
        String price =  etPrice.getText().toString();

        if (!id.isEmpty() && !description.isEmpty() && !price.isEmpty()){
            ContentValues register = new ContentValues();
            register.put("id", id);
            register.put("descripcion", description);
            register.put("precio", price);

            // Update articulos set descripcion = "pantalon", precio = 20.50 where id = 11;
            int qty = database.update("articulos", register, "id="+id, null);

            if(qty==1){
                Toast.makeText(this, "Articulo modificado", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "No existe un articulo con ese ID", Toast.LENGTH_SHORT).show();
            }

        }
        else{
            Toast.makeText(this, "Debe rellenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    public void Search(View view){
        String id = etId.getText().toString();

        if (!id.isEmpty()){
            // El método rawQuery pide como argumento una query de SQL y me devuelve un objeto de tipo cursor
            Cursor file = database.rawQuery("select descripcion, precio from articulos where id="+id,null);

            if (file.moveToFirst()){ // Compruebo con el método booleano moveToFirst() que existan registros en mi BBDD
                 etDesc.setText(file.getString(0)); // 0 representa la primera posición en el iterable
                 etPrice.setText(file.getString(1)); // la siguiente posición (1) corresponde al precio
                 //database.close();
            }
            else{
                Toast.makeText(this, "No existe el articulo con ese ID", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this, "Debe introducir un ID", Toast.LENGTH_SHORT).show();
        }
    }

    public void Delete(View view){
        String id = etId.getText().toString();

        if(!id.isEmpty()){

            // Delete from "tableName" where "campo" = "dato"
            int qty = database.delete("articulos", "id="+id,null);
            //database.close();

            etId.setText("");
            etDesc.setText("");
            etPrice.setText("");
            Toast.makeText(this, "Registro"+id+"elimnado con éxito", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "No se han encontrado registros con el id "+id, Toast.LENGTH_SHORT).show();
        }

    }
}