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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class VentanaTest extends AppCompatActivity {

    private Button button_enviarRespuestas;
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

    String datoSpinner1;
    String datoSpinner2;
    String datoSpinner3;
    String datoSpinner4;
    String datoSpinner5;
    String datoSpinner6;

    int ct = 0;
    String dni;

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
        button_enviarRespuestas = (Button) findViewById(R.id.button_enviarRespuestas);

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

        pulsar();
    }


    public void puntuacion() {
        datoSpinner1 = spinner1.getSelectedItem().toString();
        datoSpinner2 = spinner2.getSelectedItem().toString();
        datoSpinner3 = spinner3.getSelectedItem().toString();
        datoSpinner4 = spinner4.getSelectedItem().toString();
        datoSpinner5 = spinner5.getSelectedItem().toString();
        datoSpinner6 = spinner6.getSelectedItem().toString();

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

 /*
        AdminSQLiteOpenHelper adminHelper = new AdminSQLiteOpenHelper(this,"pacientes", null, 1);
        SQLiteDatabase db = adminHelper.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT dni FROM Pacientes", null);

        if (c != null) {
            c.moveToFirst();
            do {
                //Asignamos el valor en nuestras variables para usarlos en lo que necesitemos
                dni = c.getString(c.getColumnIndex("dni") + 1);
            } while (c.moveToNext());
        }

        //Cerramos el cursor y la conexion con la base de datos
        c.close();
        db.close();

  */
        Intent i = getIntent();
        dni = i.getStringExtra("DocumentoIdentidad");

        AdminSQLiteOpenHelper adminHelper1 = new AdminSQLiteOpenHelper(this,"pacientes", null, 1);
        SQLiteDatabase db1 = adminHelper1.getWritableDatabase();

        String strSQL = "UPDATE Paciente SET resultadoAnterior = " + ct + " WHERE dni = " + dni;

        db1.execSQL(strSQL);



    }

    public void pulsar() {
        button_enviarRespuestas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                puntuacion();
                Intent i = new Intent(v.getContext(),VentanaNota.class);
                String nota = String.valueOf(ct);
                i.putExtra("Nota", nota);
                startActivity(i);
            }
        });
    }
}