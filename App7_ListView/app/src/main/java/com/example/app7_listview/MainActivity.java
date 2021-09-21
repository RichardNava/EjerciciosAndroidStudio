package com.example.app7_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tv_result;
    private ListView lv_country;
    private String [] arrCountry = {"España", "Rusia", "Francia", "Italia", "Alemania"};
    private String [] arrCapital = {"Madrid", "Moscu", "Paris", "Roma", "Berlin"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_result = (TextView) findViewById(R.id.tv_result);
        lv_country = (ListView) findViewById(R.id.lv_country);

        ArrayAdapter<String> arr_adapter = new ArrayAdapter<String>(this,R.layout.mi_listview,arrCountry);
        lv_country.setAdapter(arr_adapter);

        //Metodo de Clase anonima. La provee android. Se puede usar en el onCreate()
        lv_country.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tv_result.setText("El pais " + lv_country.getItemAtPosition(position).toString() + " tiene como capital "
                + arrCapital[position]);
            }
        });
    }
}