package com.example.indicedemasacorporal2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IMC extends AppCompatActivity {

    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);
        button = (Button) findViewById(R.id.RegresarIMC);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( IMC.this, Introducción.class);
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.Siguiente);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( IMC.this, IMCTabla.class);
                startActivity(intent);
            }
        });
    }
}