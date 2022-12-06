package com.multimedia.alzheimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VentanaPostFormularioUR extends AppCompatActivity {

    private TextView textView_NombreBD, textView_ResultadoBD, textView_TlfBD, textView_DniBD;
    private Button button_realizarTest1, button_cerrarSesion1, button_borrado;
    String dni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_post_formulario_ur);

        textView_NombreBD = (TextView) findViewById(R.id.textView_NombreBD);
        textView_ResultadoBD = (TextView) findViewById(R.id.textView_ResultadoBD);
        textView_TlfBD = (TextView) findViewById(R.id.textView_TlfBD);
        textView_DniBD = (TextView) findViewById(R.id.textView_DniBD);
        button_realizarTest1 = (Button) findViewById(R.id.button_realizarTest1);
        button_cerrarSesion1 = (Button) findViewById(R.id.button_cerrarSesion1);
        button_borrado = (Button) findViewById(R.id.button_borrado);

        Intent i = getIntent();
        String nombre = i.getStringExtra("nombre");
        String tlf = i.getStringExtra("tlf");
        dni = i.getStringExtra("dni");
        String resultado = i.getStringExtra("res");

        textView_NombreBD.setText(nombre);
        textView_DniBD.setText(dni);
        textView_TlfBD.setText(tlf);
        textView_ResultadoBD.setText(resultado);

        realizarTest();
        cerrarSesion();
        borrar();
    }

    public void realizarTest() {
        button_realizarTest1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),VentanaTestUR.class);
                i.putExtra("DniUR", dni);
                startActivity(i);
            }
        });
    }

    public void cerrarSesion() {
        button_cerrarSesion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }

    public void borrar() {
        button_borrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),BorrarPaciente.class);
                startActivity(i);
            }
        });
    }
}