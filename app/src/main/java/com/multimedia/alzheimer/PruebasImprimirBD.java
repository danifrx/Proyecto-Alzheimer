package com.multimedia.alzheimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PruebasImprimirBD extends AppCompatActivity {

    private Button button_inicio10;
    private TextView tv_nombre, tv_apellidos, tv_fecha, tv_telefono, tv_dni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pruebas_imprimir_bd);

        button_inicio10 = (Button) findViewById(R.id.button_inicio10);
        tv_nombre = (TextView) findViewById(R.id.tv_nombre);
        tv_apellidos = (TextView) findViewById(R.id.tv_apellidos);
        tv_fecha = (TextView) findViewById(R.id.tv_fecha);
        tv_telefono = (TextView) findViewById(R.id.tv_telefono);
        tv_dni = (TextView) findViewById(R.id.tv_dni);


        Intent a = getIntent();
        String nombre = a.getStringExtra("nombre");
        String apellidos = a.getStringExtra("apellidos");
        String fecha = a.getStringExtra("fecha");
        String telefono = a.getStringExtra("telefono");
        String dni = a.getStringExtra("dni");

        tv_nombre.setText(nombre);
        tv_apellidos.setText(apellidos);
        tv_fecha.setText(fecha);
        tv_telefono.setText(telefono);
        tv_dni.setText(dni);

        pulsar();
    }

   public void pulsar() {
        button_inicio10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),MainActivity.class);
                startActivity(i);
            }
        });
   }

}