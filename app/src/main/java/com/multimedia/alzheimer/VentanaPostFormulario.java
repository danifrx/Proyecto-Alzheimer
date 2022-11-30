package com.multimedia.alzheimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class VentanaPostFormulario extends AppCompatActivity {

    private TextView textView_nombre;
    private Button button_realizarTest;
    private Button button_cerrarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_post_formulario);

        textView_nombre = (TextView) findViewById(R.id.textView_nombre);
        button_realizarTest = (Button) findViewById(R.id.button_realizarTest);
        button_cerrarSesion = (Button) findViewById(R.id.button_cerrarSesion);

        Intent i = getIntent();
        String nombre = i.getStringExtra("nombre");
        textView_nombre.setText(nombre);
    }

    /*
    public void recogida_datos(){
        //Instancio de la conexión con la Base de datos
        AdminSQLiteOpenHelper adminHelper = new AdminSQLiteOpenHelper(this, "pacientes", null, 1);

        //Abro la conexión de base de datos, con permisos de escritura para realizar las altas
        SQLiteDatabase db = adminHelper.getReadableDatabase();

        //Array que incluye los campos/columnas de la tabla pacientes, sobre la que hacer la consulta
        String[] columnas = {"numPaciente","nombre","apellidos","fecha","telefono","dni"};

        //El resultado de la consulta de select se guarda en el Cursor
        Cursor cursor = db.query("pacientes",columnas,null,null,null,null,null);

        //Recorrer el array de resultados (cursor) para mostrar al usario la informacion
        //obtenida dentro de los campos del formulario.
        ArrayList<Paciente> pacientes = new ArrayList<>();
        while(cursor.moveToNext()){
            long numpaciente = cursor.getLong(cursor.getColumnIndex("numPaciente")+1);
            String nombre = cursor.getString(cursor.getColumnIndex("nombre")+1);
            String apellidos = cursor.getString(cursor.getColumnIndex("apellidos")+1);
            String fecha = cursor.getString(cursor.getColumnIndex("fecha")+1);
            String tlf = cursor.getString(cursor.getColumnIndex("telefono")+1);
            String dni = cursor.getString(cursor.getColumnIndex("dni")+1);

            Paciente paciente = new Paciente(numpaciente,nombre,apellidos,fecha,tlf,dni);
            pacientes.add(paciente);
        }
        cursor.close();
        db.close();
        //TODO Aquí recollín todos os pacientes no arraylist pacientes
    }*/
}