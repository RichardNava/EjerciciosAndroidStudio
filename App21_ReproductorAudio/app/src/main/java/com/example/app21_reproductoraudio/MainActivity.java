package com.example.app21_reproductoraudio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ImageView ivPort;
    private Button playPause, btnRepeat;
    MediaPlayer mp;
    SoundPool sp;
    int repeat= 2, pos= 0, repSound;

    MediaPlayer [] arrayMp = new MediaPlayer[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivPort = (ImageView) findViewById(R.id.iv_port);
        playPause = (Button) findViewById(R.id.btn_Play);
        btnRepeat = (Button) findViewById(R.id.btn_repeat);

        arrayMp[0] = MediaPlayer.create(this,R.raw.acdc_thunderstruck);
        arrayMp[1] = MediaPlayer.create(this,R.raw.alice_francis_shoot_him_down);
        arrayMp[2] = MediaPlayer.create(this,R.raw.conga_gloria_estefan);
        arrayMp[3] = MediaPlayer.create(this,R.raw.talco_danza_dellautunno_rosa);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            sp = new SoundPool.Builder().setMaxStreams(1).build();
        }
        else {
            sp = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);
        }
        repSound = sp.load(this, R.raw.sound_short,1);

    }

    public void playPause(View view){
        sp.play(repSound,1,1,1,0,0);

        if(arrayMp[pos].isPlaying()){
            arrayMp[pos].pause();
            playPause.setBackgroundResource(R.drawable.reproducir);
            Toast.makeText(this, "Pausa", Toast.LENGTH_SHORT).show();
        }
        else{
            if(pos == 0){
                ivPort.setImageResource(R.drawable.port_acdc);
            }
            arrayMp[pos].start();
            playPause.setBackgroundResource(R.drawable.pausa);
            Toast.makeText(this, "Reproducir", Toast.LENGTH_SHORT).show();
        }
    }

    public void stop(View view){
        sp.play(repSound,1,1,1,0,0);

        if(arrayMp[pos]!=null){
            arrayMp[pos].stop();

            arrayMp[0] = MediaPlayer.create(this,R.raw.acdc_thunderstruck);
            arrayMp[1] = MediaPlayer.create(this,R.raw.alice_francis_shoot_him_down);
            arrayMp[2] = MediaPlayer.create(this,R.raw.conga_gloria_estefan);
            arrayMp[3] = MediaPlayer.create(this,R.raw.talco_danza_dellautunno_rosa);
            pos = 0;
            playPause.setBackgroundResource(R.drawable.reproducir);
            ivPort.setImageResource(R.drawable.portada1);
            Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();

        }
    }

    public void repeat(View view){
        sp.play(repSound,1,1,1,0,0);
        if(repeat == 1){
            btnRepeat.setBackgroundResource(R.drawable.no_repetir);
            Toast.makeText(this, "No repetir", Toast.LENGTH_SHORT).show();
            arrayMp[pos].setLooping(false);
            repeat = 2;
        }
        else{
            btnRepeat.setBackgroundResource(R.drawable.repetir);
            Toast.makeText(this, "Repetir", Toast.LENGTH_SHORT).show();
            arrayMp[pos].setLooping(true);
            repeat = 1;
        }

    }

    public void next(View view){
        sp.play(repSound,1,1,1,0,0);

        if(pos < arrayMp.length -1) {
            if (arrayMp[pos].isPlaying()) {
                arrayMp[pos].stop();
                pos++;
                arrayMp[pos].start();

                switch (pos) {
                    case 0:
                        ivPort.setImageResource(R.drawable.port_acdc);
                        break;
                    case 1:
                        ivPort.setImageResource(R.drawable.port_alice);
                        break;
                    case 2:
                        ivPort.setImageResource(R.drawable.port_conga);
                        break;
                    case 3:
                        ivPort.setImageResource(R.drawable.port_talco);
                        break;
                }
            }
            else{
                pos++;
                switch (pos) {
                    case 0:
                        ivPort.setImageResource(R.drawable.port_acdc);
                        break;
                    case 1:
                        ivPort.setImageResource(R.drawable.port_alice);
                        break;
                    case 2:
                        ivPort.setImageResource(R.drawable.port_conga);
                        break;
                    case 3:
                        ivPort.setImageResource(R.drawable.port_talco);
                        break;
                }
            }
        }
        else{
            Toast.makeText(this, "No existen más canciones", Toast.LENGTH_SHORT).show();
        }

    }

    public void prev (View view){
        sp.play(repSound,1,1,1,0,0);

        if(pos >= 1) {
            if (arrayMp[pos].isPlaying()) {
                arrayMp[pos].stop();
                arrayMp[0] = MediaPlayer.create(this,R.raw.acdc_thunderstruck);
                arrayMp[1] = MediaPlayer.create(this,R.raw.alice_francis_shoot_him_down);
                arrayMp[2] = MediaPlayer.create(this,R.raw.conga_gloria_estefan);
                arrayMp[3] = MediaPlayer.create(this,R.raw.talco_danza_dellautunno_rosa);
                pos--;
                arrayMp[pos].start();

                switch (pos) {
                    case 0:
                        ivPort.setImageResource(R.drawable.port_acdc);
                        break;
                    case 1:
                        ivPort.setImageResource(R.drawable.port_alice);
                        break;
                    case 2:
                        ivPort.setImageResource(R.drawable.port_conga);
                        break;
                    case 3:
                        ivPort.setImageResource(R.drawable.port_talco);
                        break;
                }
            }
            else{
                pos--;
                switch (pos) {
                    case 0:
                        ivPort.setImageResource(R.drawable.port_acdc);
                        break;
                    case 1:
                        ivPort.setImageResource(R.drawable.port_alice);
                        break;
                    case 2:
                        ivPort.setImageResource(R.drawable.port_conga);
                        break;
                    case 3:
                        ivPort.setImageResource(R.drawable.port_talco);
                        break;
                }
            }
        }
        else{
            Toast.makeText(this, "Estas en la primera", Toast.LENGTH_SHORT).show();
        }
    }
}