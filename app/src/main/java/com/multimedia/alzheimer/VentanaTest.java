package com.multimedia.alzheimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class VentanaTest extends AppCompatActivity {

    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;
    private Spinner spinner4;
    private Spinner spinner5;
    private Spinner spinner6;
    private String[] opciones1 = {"", "Circulo", "Triángulo", "Estrella", "Cuadrado"};
    private String[] opciones2 = {"", "-10", "6.55", "7.24", "9.58"};
    private String[] opciones3 = {"", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
    private String[] opciones4 = {"", "2", "5", "3", "4"};
    private String[] opciones5 = {"", "Son frutas", "Son verduras", "Son productos cárnicos", "Son vehículos"};
    private String[] opciones6 = {"", "Hacia arriba", "Hacia la derecha", "Hacia abajo", "Hacia la izquierda"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_test);

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        spinner4 = (Spinner) findViewById(R.id.spinner4);
        spinner5 = (Spinner) findViewById(R.id.spinner5);
        spinner6 = (Spinner) findViewById(R.id.spinner6);

        ArrayAdapter<String> adaptador1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones1);
        spinner1.setAdapter(adaptador1);

        ArrayAdapter<String> adaptador2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones2);
        spinner2.setAdapter(adaptador2);

        ArrayAdapter<String> adaptador3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones3);
        spinner3.setAdapter(adaptador3);

        ArrayAdapter<String> adaptador4 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones4);
        spinner4.setAdapter(adaptador4);

        ArrayAdapter<String> adaptador5 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones5);
        spinner5.setAdapter(adaptador5);

        ArrayAdapter<String> adaptador6 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones6);
        spinner6.setAdapter(adaptador6);
        //


    }
}