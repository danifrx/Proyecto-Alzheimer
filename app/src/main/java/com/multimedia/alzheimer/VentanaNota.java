package com.multimedia.alzheimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VentanaNota extends AppCompatActivity {

    private TextView textView_nota;
    private Button button_repetir;
    private Button button_cerrar;
    String nota;
    String doc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_nota);

        textView_nota = (TextView) findViewById(R.id.textView_nota);
        button_repetir = (Button) findViewById(R.id.button_repetir);
        button_cerrar = (Button) findViewById(R.id.button_cerrar);

        textView_nota.setText("");

        Intent i = getIntent();
        String nota = i.getStringExtra("Nota");
;
        int nota1 = Integer.parseInt(nota);
        if (nota1 < 2) {
            textView_nota.setText("Alzheimer");
        } else if (nota1 >= 2 && nota1 <= 4) {
            textView_nota.setText("Peligro de alzheimer");
        } else if (nota1 > 4 && nota1 <= 6) {
            textView_nota.setText("Buena salud mental");
        }

        cerrarSesion();
        repetirTest();
    }

    public void repetirTest() {
        button_repetir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),VentanaTest.class);
                startActivity(i);
            }
        });
    }

    public void cerrarSesion() {
        button_cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
}