package com.example.app22_scrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Frutas banana = new Frutas ("Banana",1.2f);
    Frutas cereza = new Frutas ("Cereza",1.5f);
    Frutas frambuesa = new Frutas ("Frambuesa",3.5f);
    Frutas fresa = new Frutas ("Fresa",2.0f);
    Frutas kiwi = new Frutas ("Kiwi",2.5f);
    Frutas mango = new Frutas ("Mango",2.8f);
    Frutas manzana = new Frutas ("Manzana",0.9f);
    Frutas melon = new Frutas ("Melón",4.5f);
    Frutas naranja = new Frutas ("Naranja",1.2f);
    Frutas pera = new Frutas ("Pera",1.0f);
    Frutas pina = new Frutas ("Piña",2.3f);
    Frutas sandia = new Frutas ("Sandia",4.0f);
    Frutas uva = new Frutas ("Uva",3.2f);
    Frutas mora = new Frutas ("Mora",3.8f);
    ArrayList<Frutas> carrito = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void SelectItem(View view){
        switch (view.getId()){
            case R.id.ib_banana:
                carrito.add(banana);
                Toast.makeText(this, "Bananas añadidas al carrito", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ib_cereza:
                carrito.add(cereza);
                Toast.makeText(this, "Cerezas añadidas al carrito", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ib_frambuesa:
                carrito.add(frambuesa);
                Toast.makeText(this, "Frambuesas añadidas al carrito", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ib_fresas:
                carrito.add(fresa);
                Toast.makeText(this, "Fresas añadidas al carrito", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ib_kiwi:
                carrito.add(kiwi);
                Toast.makeText(this, "Kiwis añadidas al carrito", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ib_mango:
                carrito.add(mango);
                Toast.makeText(this, "Mangos añadidas al carrito", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ib_manzana:
                carrito.add(manzana);
                Toast.makeText(this, "Manzanas añadidas al carrito", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ib_melon:
                carrito.add(melon);
                Toast.makeText(this, "Melón añadidas al carrito", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ib_naranja:
                carrito.add(naranja);
                Toast.makeText(this, "Naranjas añadidas al carrito", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ib_pera:
                carrito.add(pera);
                Toast.makeText(this, "Peras añadidas al carrito", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ib_pina:
                carrito.add(pina);
                Toast.makeText(this, "Piña añadidas al carrito", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ib_sandia:
                carrito.add(sandia);
                Toast.makeText(this, "Sandia añadidas al carrito", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ib_uva:
                carrito.add(uva);
                Toast.makeText(this, "Uvas añadidas al carrito", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ib_mora:
                carrito.add(mora);
                Toast.makeText(this, "Moras añadidas al carrito", Toast.LENGTH_SHORT).show();
                break;

        }
    }

    public void Continuar(View view){
        Intent i = new Intent(this, OtherActivity.class);
        i.putParcelableArrayListExtra("list",carrito);
        startActivity(i);
    }

}
