package com.multimedia.alzheimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VentanaPostFormularioUR extends AppCompatActivity {

    private TextView textView_NombreBD, textView_ResultadoBD, textView_TlfBD, textView_DniBD;
    private Button button_realizarTest1, button_cerrarSesion1;

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

        realizarTest();
        cerrarSesion();
    }

    public void realizarTest() {
        button_realizarTest1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),VentanaTest.class);
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
}