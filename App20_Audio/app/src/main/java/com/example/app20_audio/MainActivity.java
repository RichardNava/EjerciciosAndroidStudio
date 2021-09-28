package com.example.app20_audio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button playSound;
    SoundPool sp;
    int repSound;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playSound = (Button) findViewById(R.id.btn_playSound);

        // Estructura de control para ver la versión del dispositivo y su numeración de API
        // En caso de estar por debajo de 21 (LOLLIPOP) usaremos la forma antigua (Obsoleta) de instanciar la clase
        // En caso de reproducirse en dispositivos más actuales >21 API usaremos la forma actual de instanciar la clase
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            sp = new SoundPool.Builder().setMaxStreams(1).build();
        }
        else {
            sp = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);
        }
        repSound = sp.load(this, R.raw.sound_short,1);

    }


    public void AudioSoundPool(View view){
        // Parametros del método play
        // 1- Identificador de pista
        // 2- Volumen canal izq
        // 3- Volumen canal der
        // 4- Prioridad
        // 5- Bucle (-1= Se repite bucle, 0= No se repite, 1= Suena dos veces, se repite una)
        // 6- Rate - Velocidad de reproducción
        sp.play(repSound,1,1,1,0,0);
    }

    public void AudioMediaPlayer(View view){
        MediaPlayer mp = MediaPlayer.create(this, R.raw.acdc_thunderstruck);
        mp.start();
    }
}