package com.multimedia.alzheimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class VentanaTextUR extends AppCompatActivity {

    private Button button_enviarRespuestas1;
    private Spinner spinner11;
    private Spinner spinner21;
    private Spinner spinner31;
    private Spinner spinner41;
    private Spinner spinner51;
    private Spinner spinner61;
    private String[] opciones1 = {"", "Circulo", "Triángulo", "Estrella", "Cuadrado"};
    private String[] opciones2 = {"", "1.5", "6.55", "7.24", "9.58"};
    private String[] opciones3 = {"", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
    private String[] opciones4 = {"", "2", "5", "3", "4"};
    private String[] opciones5 = {"", "Son frutas", "Son verduras", "Son productos cárnicos", "Son vehículos"};
    private String[] opciones6 = {"", "Hacia arriba", "Hacia la derecha", "Hacia abajo", "Hacia la izquierda"};

    int ct = 0;

    String datoSpinner1;
    String datoSpinner2;
    String datoSpinner3;
    String datoSpinner4;
    String datoSpinner5;
    String datoSpinner6;
    String resultadoUR;
    String dniUR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_text_ur);

        spinner11 = (Spinner) findViewById(R.id.spinner11);
        spinner21 = (Spinner) findViewById(R.id.spinner21);
        spinner31 = (Spinner) findViewById(R.id.spinner31);
        spinner41 = (Spinner) findViewById(R.id.spinner41);
        spinner51 = (Spinner) findViewById(R.id.spinner51);
        spinner61 = (Spinner) findViewById(R.id.spinner61);
        button_enviarRespuestas1 = (Button) findViewById(R.id.button_enviarRespuestas1);

        ArrayAdapter<String> adaptador1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones1);
        spinner11.setAdapter(adaptador1);

        ArrayAdapter<String> adaptador2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones2);
        spinner21.setAdapter(adaptador2);

        ArrayAdapter<String> adaptador3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones3);
        spinner31.setAdapter(adaptador3);

        ArrayAdapter<String> adaptador4 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones4);
        spinner41.setAdapter(adaptador4);

        ArrayAdapter<String> adaptador5 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones5);
        spinner51.setAdapter(adaptador5);

        ArrayAdapter<String> adaptador6 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones6);
        spinner61.setAdapter(adaptador6);

        Intent b = getIntent();
        dniUR = b.getStringExtra("DniUR");

        puntuacion();
       // actualizarDB();
        pulsar();
    }

    public void puntuacion() {
        datoSpinner1 = spinner11.getSelectedItem().toString();
        datoSpinner2 = spinner21.getSelectedItem().toString();
        datoSpinner3 = spinner31.getSelectedItem().toString();
        datoSpinner4 = spinner41.getSelectedItem().toString();
        datoSpinner5 = spinner51.getSelectedItem().toString();
        datoSpinner6 = spinner61.getSelectedItem().toString();

        ct = 0;

        if (datoSpinner1.equals("Estrella")) {
            ct++;
        }
        if (datoSpinner2.equals("6.55")) {
            ct++;
        }
        if (datoSpinner3.equals("Lunes")) {
            ct++;
        }
        if (datoSpinner4.equals("4")) {
            ct++;
        }
        if (datoSpinner5.equals("Son frutas")) {
            ct++;
        }
        if (datoSpinner6.equals("Hacia la derecha")) {
            ct++;
        }

        if (ct <= 2) {
            resultadoUR = "Alzheimer";
        } else if (ct > 2 && ct <= 4) {
            resultadoUR = "Peligro de alzheimer";
        } else if (ct > 4 && ct <= 6) {
            resultadoUR = "Buena salud mental";
        }

        //resultadoUR = dniUR;


    }

    public void actualizarDB() {
        AdminSQLiteOpenHelper adminHelper = new AdminSQLiteOpenHelper(this, "registro", null, 1);
        SQLiteDatabase db = adminHelper.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("dni", dniUR);
        valores.put("resultado", resultadoUR);
        String seleccion = "dni" + " = ?";
        String[] condicion = {dniUR};
        db.update("Test",valores,seleccion,condicion);

        db.close();
    }

    public void pulsar() {
        button_enviarRespuestas1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),VentanaNotaUR.class);
                i.putExtra("NotaUR", resultadoUR);
                startActivity(i);
            }
        });
    }
}