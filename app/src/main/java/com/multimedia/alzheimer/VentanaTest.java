package com.multimedia.alzheimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class VentanaTest extends AppCompatActivity {

    private Button button_enviarRespuestas;
    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;
    private Spinner spinner4;
    private Spinner spinner5;
    private Spinner spinner6;
    private String[] opciones1 = {"", "Circulo", "Triángulo", "Estrella", "Cuadrado"};
    private String[] opciones2 = {"", "1.5", "6.55", "7.24", "9.58"};
    private String[] opciones3 = {"", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
    private String[] opciones4 = {"", "2", "5", "3", "4"};
    private String[] opciones5 = {"", "Son frutas", "Son verduras", "Son productos cárnicos", "Son vehículos"};
    private String[] opciones6 = {"", "Hacia arriba", "Hacia la derecha", "Hacia abajo", "Hacia la izquierda"};

    String datoSpinner1;
    String datoSpinner2;
    String datoSpinner3;
    String datoSpinner4;
    String datoSpinner5;
    String datoSpinner6;
    String resultado;

    int ct = 0;
    String dni, dniComprobante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_test);

        Intent i = getIntent();
        dni = i.getStringExtra("DocumentoIdentidad");

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        spinner4 = (Spinner) findViewById(R.id.spinner4);
        spinner5 = (Spinner) findViewById(R.id.spinner5);
        spinner6 = (Spinner) findViewById(R.id.spinner6);
        button_enviarRespuestas = (Button) findViewById(R.id.button_enviarRespuestas1);

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


        pulsarSpinner1();
        pulsarSpinner2();
        pulsarSpinner3();
        pulsarSpinner4();
        pulsarSpinner5();
        pulsarSpinner6();


        pulsar();

    }

    public void insertarDatos() {
        //Instancio la conexión con la BBDD
        AdminSQLiteOpenHelper adminHelper = new AdminSQLiteOpenHelper(this, "registro", null, 1);
        //Abro la conexión de base de datos, con permisos de escritura para realizar las altas
        SQLiteDatabase db = adminHelper.getWritableDatabase();

        ContentValues valores = new ContentValues();

        valores.put("dni", dni);
        valores.put("resultado", resultado);
        //Incremento de la del num del paciente.
        db.insert("Test", null, valores);
        db.close();
    }


        public void pulsarSpinner1() {
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                datoSpinner1 = spinner1.getSelectedItem().toString();
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
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                datoSpinner2 = spinner2.getSelectedItem().toString();
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
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                datoSpinner3 = spinner3.getSelectedItem().toString();
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
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                datoSpinner4 = spinner4.getSelectedItem().toString();
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
        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                datoSpinner5 = spinner5.getSelectedItem().toString();
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
        spinner6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                datoSpinner6 = spinner6.getSelectedItem().toString();
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

    public void pulsar() {
        button_enviarRespuestas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ct <= 2) {
                    resultado = "Riesgo alto";
                } else if (ct > 2 && ct <= 4) {
                    resultado = "Peligro moderado";
                } else if (ct > 4 && ct <= 6) {
                    resultado = "Riesgo alto";
                }
                insertarDatos();
                /*Intent i = new Intent(v.getContext(),VentanaNota.class);
                String nota = String.valueOf(ct);
                i.putExtra("Nota", nota);
                startActivity(i);*/
                Intent i = new Intent(v.getContext(),VentanaNota.class);
                i.putExtra("Nota", resultado);
                startActivity(i);
            }
        });
    }
}