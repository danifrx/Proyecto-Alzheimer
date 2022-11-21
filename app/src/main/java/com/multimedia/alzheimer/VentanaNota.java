package com.multimedia.alzheimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class VentanaNota extends AppCompatActivity {

    private TextView textView_nota;
    private Button button_repetir;
    private Button button_cerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_nota);

        textView_nota = (TextView) findViewById(R.id.textView_nota);
        button_repetir = (Button) findViewById(R.id.button_repetir);
        button_cerrar = (Button) findViewById(R.id.button_cerrar);

        //Inicializo el textView de nota
        textView_nota.setText("");

        Intent i = getIntent();
        String nota = i.getStringExtra("nota");
        textView_nota.setText(nota);

        if (textView_nota.getText().toString().equalsIgnoreCase("")){
            textView_nota.setText("Text no realizado");
        }
    }
}