package com.multimedia.alzheimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class VentanaFormulario extends AppCompatActivity {
    private EditText editTextText_Nombre;
    private EditText editTextText_Apellidos;
    private EditText editTextText_Fecha;
    private EditText editTextText_Telefono;
    private EditText editTextText_Dni;
    private Button button_GuardarDatos;
    private String nombre="";
    private String apellidos="";
    private String fecha="";
    private String telefono="";
    private String dni="";
    private String notaanterior;

    //Pruebas
    private String nombre1;
    private String apellido1;
    private String fecha1;
    private String telefono1;
    private String dni1;
    private Button button_db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_formulario);

        editTextText_Nombre = (EditText) findViewById(R.id.editTextText_Nombre);
        editTextText_Apellidos = (EditText) findViewById(R.id.editTextText_Apellidos);
        editTextText_Fecha = (EditText) findViewById(R.id.editTextText_Fecha);
        editTextText_Telefono = (EditText) findViewById(R.id.editTextText_Telefono);
        editTextText_Dni = (EditText) findViewById(R.id.editTextText_Dni);
        button_GuardarDatos= (Button) findViewById(R.id.button_GuardarDatos);

        pulsar_button_Guardar();

        //pruebas
        button_db = (Button)  findViewById(R.id.button_bd);
        pulsarBotonPruebas();
    }

    public void pulsar_button_Guardar() {
        button_GuardarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre=editTextText_Nombre.getText().toString();
                apellidos=editTextText_Apellidos.getText().toString();
                fecha=editTextText_Fecha.getText().toString();
                telefono=editTextText_Telefono.getText().toString();
                dni=editTextText_Dni.getText().toString();

                if(nombre.isEmpty() || apellidos.isEmpty() || fecha.isEmpty() ||telefono.isEmpty()||dni.isEmpty()){
                    Toast toast1= Toast.makeText(getApplicationContext(),"Rellene todos los datos",Toast.LENGTH_LONG);
                    toast1.show();
                }else{
                  //  Intent i = new Intent(view.getContext(), Main.class);//falta por escribir a ventana a que vou enviar os datos
                   // i.putExtra("Nombre",nombre);
                    //i.putExtra("Apellidos",apellidos);
                    //i.putExtra("Fecha",fecha);
                    //i.putExtra("Telefono",telefono);
                    //i.putExtra("Dni",dni);
                    //startActivity(i);

                    AdminSQLiteOpenHelper dbHelper = new AdminSQLiteOpenHelper(this,"registro",null,1);
                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                    /*if (db != null) {
                        String sentencia = ("insert into Paciente (nombre, apellidos, fecha, telefono, dni) values ('" + nombre + "','" + apellidos + "','" +
                                fecha + "','" + telefono + "','" + dni + "')");
                        db.execSQL(sentencia);

                        db.close();


                    }*/


                       // outra forma de añadir datos:
                        ContentValues cv = new ContentValues();
                        cv.put("nombre", nombre);
                        cv.put("apellidos", apellidos);
                        cv.put("fecha", fecha);
                        cv.put("telefono", telefono);
                        cv.put("dni", dni);
                        db.insert("Paciente", null, cv);

                    db.close();

                    //Apartir de aqui son pruebas!!!!
                    AdminSQLiteOpenHelper dbHelper1 = new AdminSQLiteOpenHelper(this,"registro",null,1);
                    SQLiteDatabase db1 = dbHelper1.getReadableDatabase();


                    Cursor c = db1.rawQuery("SELECT nombre, apellidos, fecha, telefono, dni FROM Paciente", null);

                    if ( c.moveToFirst())  {

                        do {
                            // int numPaciente = c.getInt(c.getColumnIndex("numPaciente"));
                            nombre1 = c.getString(1);
                            apellido1 = c.getString(2);
                            fecha1 = c.getString(4);
                            telefono1 = c.getString(5);
                            dni1 = c.getString(6);
                        } while (c.moveToNext());
                    }
                    c.close();
                    db1.close();

                }



            }
        });
    }

    public void pulsarBotonPruebas() {
        button_db.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast2= Toast.makeText(getApplicationContext(),nombre1,Toast.LENGTH_LONG);
                toast2.show();
                //Abrimos o activity de pruebas que imprimir os datos da bd pa ver que funciona
                Intent i = new Intent(v.getContext(),PruebasImprimirBD.class);
                i.putExtra("nombre", nombre1);
                i.putExtra("apellidos", apellido1);
                i.putExtra("fecha", fecha1);
                i.putExtra("telefono", telefono1);
                i.putExtra("dni", dni1);
                startActivity(i);
            }
        });
    }


}