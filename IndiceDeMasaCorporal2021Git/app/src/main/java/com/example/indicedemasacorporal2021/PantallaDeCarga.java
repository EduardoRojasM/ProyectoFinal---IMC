package com.example.indicedemasacorporal2021;

import android.content.Intent;
import java.util.Timer;
import java.util.TimerTask;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class PantallaDeCarga extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalladecarga);

        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent( PantallaDeCarga.this, Introducción.class);
                startActivity(intent);
                finish();
            }
        };
        Timer tiempo = new Timer();
        tiempo.schedule(tarea, 2000);
    }
}
