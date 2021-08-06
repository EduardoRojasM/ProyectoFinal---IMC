package com.example.indicedemasacorporal2021;

import java.text.DecimalFormat;
import android.os.Bundle;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;

import BaseDeDatos.DatosOpenHelper;
import Entidades.Usuario;
import Utilidades.Utilidades;

public class PromedioPersonas extends AppCompatActivity {

    ListView listViewPersonas;
    ArrayList<String> listaInformacion;
    ArrayList<Usuario> listaUsuarios;

    DatosOpenHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promedio_personas);

        conn = new DatosOpenHelper(getApplicationContext(),"bd_usuarios",null,1);

        listViewPersonas = (ListView) findViewById(R.id.PrimeraLista);

        consultarListaPersonas();

        ArrayAdapter adaptador=new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaInformacion);

        listViewPersonas.setAdapter(adaptador);

        listViewPersonas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
            }
        });
    }

    private void consultarListaPersonas() {
        SQLiteDatabase db=conn.getReadableDatabase();

        Usuario usuario=null;
        listaUsuarios=new ArrayList<Usuario>();
        //select * from usuarios
        Cursor cursor=db.rawQuery("SELECT * FROM "+Utilidades.TABLA_USUARIO,null);

        while (cursor.moveToNext()){
            usuario=new Usuario();
            usuario.setId(cursor.getInt(0));
            usuario.setNombre(cursor.getString(1));
            usuario.setApellido(cursor.getString(2));
            usuario.setEdad(cursor.getInt(3));
            usuario.setAltura(cursor.getInt(4));
            usuario.setPeso(cursor.getInt(5));
            usuario.setAnio(cursor.getInt(6));
            usuario.setMes(cursor.getInt(7));
            usuario.setDia(cursor.getInt(8));

            listaUsuarios.add(usuario);
        }
        obtenerLista();
    }

    private void obtenerLista() {
        listaInformacion=new ArrayList<String>();
        listaInformacion.add("Bienvenido "+listaUsuarios.get(1).getNombre()+" "+listaUsuarios.get(1).getApellido()+"!");
        listaInformacion.add("ID"+"  /  "+" Nombre "+"  /  "+" Fecha "+"  /  "+"Peso"+"  /  "+"Altura"+"  /  "+"IMC");
        for (int i=0; i<listaUsuarios.size();i++){
            double kg = listaUsuarios.get(i).getPeso();
            double cm = listaUsuarios.get(i).getAltura();
            double m = cm/100;
            double imc = (kg/(m*m));
            DecimalFormat df = new DecimalFormat("#.00");
            listaInformacion.add((i+1)+"  -  "
                    +listaUsuarios.get(i).getNombre()+"  -  "+listaUsuarios.get(i).getDia()+"/"
                    +listaUsuarios.get(i).getMes()+"/"+listaUsuarios.get(i).getAnio()+"  -  "
                    +kg+"  -  "+m+"  -  "+df.format(imc));
        }

    }
}

