package com.multimedia.alzheimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VentanaNotaUR extends AppCompatActivity {

    private TextView textView_nota1;
    private Button button_repetir1;
    private Button button_cerrar1;
    String nota1;
    String doc1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_nota_ur);

        textView_nota1 = (TextView) findViewById(R.id.textView_nota2);
        button_repetir1 = (Button) findViewById(R.id.button_repetir2);
        button_cerrar1 = (Button) findViewById(R.id.button_cerrar2);

        textView_nota1.setText("");

        Intent i = getIntent();
        String nota1 = i.getStringExtra("Nota");

        int nota2 = Integer.parseInt(nota1);
        if (nota2 < 2) {
            textView_nota1.setText("Alzheimer");
        } else if (nota2 >= 2 && nota2 <= 4) {
            textView_nota1.setText("Peligro de alzheimer");
        } else if (nota2 > 4 && nota2 <= 6) {
            textView_nota1.setText("Buena salud mental");
        }


        /*Intent b = getIntent();
        String notaanterior = b.getStringExtra("nota");

        int notaanterior1 = Integer.parseInt(notaanterior);
        if (notaanterior1 < 2) {
            textView_nota.setText("Alzheimer");
        } else if (notaanterior1 >= 2 && notaanterior1 <= 4) {
            textView_nota.setText("Peligro de alzheimer");
        } else if (notaanterior1 > 4 && notaanterior1 <= 6) {
            textView_nota.setText("Buena salud mental");
        }*/
            //.

        cerrarSesion1();
        repetirTest1();
    }

    public void repetirTest1() {
        button_repetir1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),VentanaTest.class);
                startActivity(i);
            }
        });
    }

    public void cerrarSesion1() {
        button_cerrar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
}