package com.example.app17_framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView iv_photo;
    private Button btn_photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_photo = (ImageView) findViewById(R.id.ib_avatar);
        btn_photo = (Button) findViewById(R.id.btn_avatar);
    }

    public void Hide (View view){
        btn_photo.setVisibility(View.INVISIBLE);
        iv_photo.setVisibility(View.VISIBLE);
    }
}