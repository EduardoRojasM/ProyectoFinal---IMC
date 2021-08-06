package com.example.indicedemasacorporal2021;

import androidx.appcompat.app.AppCompatActivity;
//import androidx.navigation.ui.AppBarConfiguration;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;
import Utilidades.Utilidades;

import BaseDeDatos.DatosOpenHelper;

public class Registro extends AppCompatActivity {

    EditText campoId,campoNombre,campoApellido,campoEdad,campoAltura,
        campoPeso,campoAnio,campoMes,campoDia;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        campoId=(EditText) findViewById(R.id.editId);
        campoNombre=(EditText) findViewById(R.id.editNombre);
        campoApellido=(EditText) findViewById(R.id.editApellido);
        campoEdad=(EditText) findViewById(R.id.editEdad);
        campoAltura=(EditText) findViewById(R.id.editAltura);
        campoPeso=(EditText) findViewById(R.id.editPeso);
        campoAnio=(EditText) findViewById(R.id.editAnio);
        campoMes=(EditText) findViewById(R.id.editMes);
        campoDia=(EditText) findViewById(R.id.editDia);

        //Boton cancelar
        button = (Button) findViewById(R.id.cancelar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent( Registro.this, Introducción.class);
                startActivity(intent);
            }
        });
        //Boton cancelar
        }

        public void onClick(View view) {
            registrarUsuarios();
        }

        private void registrarUsuarios() {
            DatosOpenHelper conn=new DatosOpenHelper(this,"bd_usuarios",null, 1);

            SQLiteDatabase db=conn.getWritableDatabase();

            ContentValues values=new ContentValues();
            values.put(Utilidades.CAMPO_ID,campoId.getText().toString());
            values.put(Utilidades.CAMPO_NOMBRE,campoNombre.getText().toString());
            values.put(Utilidades.CAMPO_APELLIDO,campoApellido.getText().toString());
            values.put(Utilidades.CAMPO_EDAD,campoEdad.getText().toString());
            values.put(Utilidades.CAMPO_ALTURA,campoAltura.getText().toString());
            values.put(Utilidades.CAMPO_PESO,campoPeso.getText().toString());
            values.put(Utilidades.CAMPO_ANIO,campoAnio.getText().toString());
            values.put(Utilidades.CAMPO_MES,campoMes.getText().toString());
            values.put(Utilidades.CAMPO_DIA,campoDia.getText().toString());

            Long idResultante=db.insert(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_ID,values);

            Toast.makeText(getApplicationContext(),"Id(Telefono): "+idResultante,Toast.LENGTH_SHORT).show();
            db.close();
    }
}