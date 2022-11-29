package com.multimedia.alzheimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class VentanaFormulario extends AppCompatActivity {
    private EditText editTextText_Nombre;
    private EditText editTextText_Apellidos;
    private EditText editTextText_Fecha;
    private EditText editTextText_Telefono;
    private EditText editTextText_Dni;
    private Button button_GuardarDatos;
    private String nombre = "";
    private String apellidos = "";
    private String fecha = "";
    private String telefono = "";
    private String dni = "";
    private String notaanterior;

    //Pruebas
    private String nombre1;
    private String apellido1;
    private String fecha1;
    private String telefono1;
    private String dni1;
    private Button button_db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_formulario);

        editTextText_Nombre = (EditText) findViewById(R.id.editTextText_Nombre);
        editTextText_Apellidos = (EditText) findViewById(R.id.editTextText_Apellidos);
        editTextText_Fecha = (EditText) findViewById(R.id.editTextText_Fecha);
        editTextText_Telefono = (EditText) findViewById(R.id.editTextText_Telefono);
        editTextText_Dni = (EditText) findViewById(R.id.editTextText_Dni);
        button_GuardarDatos = (Button) findViewById(R.id.button_GuardarDatos);



    }

}