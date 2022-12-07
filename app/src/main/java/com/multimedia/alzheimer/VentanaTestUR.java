package com.multimedia.alzheimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class VentanaTestUR extends AppCompatActivity {

    private Button button_er;
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
        setContentView(R.layout.activity_ventana_test_ur);

        spinner11 = (Spinner) findViewById(R.id.spinner11);
        spinner21 = (Spinner) findViewById(R.id.spinner21);
        spinner31 = (Spinner) findViewById(R.id.spinner31);
        spinner41 = (Spinner) findViewById(R.id.spinner41);
        spinner51 = (Spinner) findViewById(R.id.spinner51);
        spinner61 = (Spinner) findViewById(R.id.spinner61);
        button_er = (Button) findViewById(R.id.button_er);

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

        Intent a = getIntent();
        dniUR = a.getStringExtra("DniUR");

        pulsarSpinner1();
        pulsarSpinner2();
        pulsarSpinner3();
        pulsarSpinner4();
        pulsarSpinner5();
        pulsarSpinner6();
        actualizarDB();
        pulsar();
    }

    public void pulsarSpinner1() {
        spinner11.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                datoSpinner1 = spinner11.getSelectedItem().toString();
                Toast.makeText(view.getContext(), datoSpinner1, Toast.LENGTH_SHORT).show();
                if (datoSpinner1.equals("Estrella")) {
                    ct++;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void pulsarSpinner2() {
        spinner21.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                datoSpinner2 = spinner21.getSelectedItem().toString();
                Toast.makeText(view.getContext(), datoSpinner2, Toast.LENGTH_SHORT).show();
                if (datoSpinner2.equals("6.55")) {
                    ct++;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void pulsarSpinner3() {
        spinner31.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                datoSpinner3 = spinner31.getSelectedItem().toString();
                Toast.makeText(view.getContext(), datoSpinner3, Toast.LENGTH_SHORT).show();
                if (datoSpinner3.equals("Lunes")) {
                    ct++;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void pulsarSpinner4() {
        spinner41.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                datoSpinner4 = spinner41.getSelectedItem().toString();
                Toast.makeText(view.getContext(), datoSpinner4, Toast.LENGTH_SHORT).show();
                if (datoSpinner4.equals("4")) {
                    ct++;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void pulsarSpinner5() {
        spinner51.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                datoSpinner5 = spinner51.getSelectedItem().toString();
                Toast.makeText(view.getContext(), datoSpinner5, Toast.LENGTH_SHORT).show();
                if (datoSpinner5.equals("Son frutas")) {
                    ct++;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void pulsarSpinner6() {
        spinner61.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                datoSpinner6 = spinner61.getSelectedItem().toString();
                Toast.makeText(view.getContext(), datoSpinner6, Toast.LENGTH_SHORT).show();
                if (datoSpinner6.equals("Hacia la derecha")) {
                    ct++;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
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
        button_er.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ct <= 2) {
                    resultadoUR = "Alzheimer";
                } else if (ct > 2 && ct <= 4) {
                    resultadoUR = "Peligro de alzheimer";
                } else if (ct > 4 && ct <= 6) {
                    resultadoUR = "Buena salud mental";
                }
                Intent i = new Intent(v.getContext(),VentanaNotaUR.class);
                i.putExtra("NotaUR", resultadoUR);
                startActivity(i);
            }
        });
    }
}