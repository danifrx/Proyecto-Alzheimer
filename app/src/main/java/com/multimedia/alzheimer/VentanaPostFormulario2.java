package com.multimedia.alzheimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class VentanaPostFormulario2 extends AppCompatActivity {

    private TextView textView_nombre;
    private Button button_realizarTest;
    private Button button_cerrarSesion;
    private String nombre1;
    String dni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_post_formulario2);

        textView_nombre = (TextView) findViewById(R.id.textView_nombre);
        button_realizarTest = (Button) findViewById(R.id.button_realizarTest1);
        button_cerrarSesion = (Button) findViewById(R.id.button_cerrarSesion1);

        Intent i = getIntent();
        String nombre = i.getStringExtra("Nombre");
        dni = i.getStringExtra("Dni");
        textView_nombre.setText(nombre);

        realizarTest();
        cerrarSesion();
    }

    public void realizarTest() {
        button_realizarTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),VentanaTest.class);
                i.putExtra("DocumentoIdentidad", dni);
                startActivity(i);
            }
        });
    }

    public void cerrarSesion() {
        button_cerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }

}