package com.example.indicedemasacorporal2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import BaseDeDatos.DatosOpenHelper;

public class Introducción extends AppCompatActivity {

    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduccion);

        button = (Button) findViewById(R.id.imc);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Introducción.this, IMC.class);
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.FormulaIMC);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Introducción.this, FormulaIMC.class);
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.Promedios);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Introducción.this, PromedioPersonas.class);
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.Registro);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Introducción.this, Registro.class);
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.InfoApp);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Introducción.this, InformacionDeLaAplicacion.class);
                startActivity(intent);
            }
        });
    }
}