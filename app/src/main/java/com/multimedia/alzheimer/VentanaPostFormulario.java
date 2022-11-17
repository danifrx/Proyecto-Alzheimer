package com.multimedia.alzheimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class VentanaPostFormulario extends AppCompatActivity {

    private EditText editTextNombre;
    private Button button_realizarTest;
    private Button button_cerrarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_post_formulario);

        editTextNombre = (EditText) findViewById(R.id.editTextNombre);
        button_realizarTest = (Button) findViewById(R.id.button_realizarTest);
        button_cerrarSesion = (Button) findViewById(R.id.button_cerrarSesion);
    }
}