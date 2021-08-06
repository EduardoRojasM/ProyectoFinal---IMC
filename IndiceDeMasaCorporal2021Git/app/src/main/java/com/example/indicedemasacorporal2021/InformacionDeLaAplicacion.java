package com.example.indicedemasacorporal2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InformacionDeLaAplicacion extends AppCompatActivity {

    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_de_la_aplicacion);


        button = (Button) findViewById(R.id.Volver);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( InformacionDeLaAplicacion.this, Introducción.class);
                startActivity(intent);
            }
        });
    }
}