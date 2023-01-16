package com.multimedia.alzheimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VentanaNota extends AppCompatActivity {

    private TextView textView_nota;
    //private Button button_repetir;
    private Button button_cerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_nota);

        textView_nota = (TextView) findViewById(R.id.textView_nota1);
        button_cerrar = (Button) findViewById(R.id.button_cerrar1);

        textView_nota.setText("");

        Intent i = getIntent();
        String nota = i.getStringExtra("Nota");

        textView_nota.setText(nota);


        cerrarSesion();

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