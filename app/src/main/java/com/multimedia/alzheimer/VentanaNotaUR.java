package com.multimedia.alzheimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VentanaNotaUR extends AppCompatActivity {

    private TextView textView_nota2;
    private Button button_repetir2;
    private Button button_cerrar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_nota_ur);

        textView_nota2 = (TextView) findViewById(R.id.textView_nota2);
        button_repetir2 = (Button) findViewById(R.id.button_repetir2);
        button_cerrar2 = (Button) findViewById(R.id.button_cerrar2);

        textView_nota2.setText("");


        Intent b = getIntent();
        String notaUR = b.getStringExtra("NotaUR");

        textView_nota2.setText(notaUR);


        cerrarSesion2();
        repetirTest2();
    }

    public void repetirTest2() {
        button_repetir2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),VentanaTestUR.class);
                startActivity(i);
            }
        });
    }

    public void cerrarSesion2() {
        button_cerrar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
}