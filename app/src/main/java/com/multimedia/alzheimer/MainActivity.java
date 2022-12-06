package com.multimedia.alzheimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView textView_titulo;
    private TextView textView_subtitulo;
    private EditText editText_nombre;
    private EditText editText_dni;
    private Button button_iniciarsesion;
    private Button button_registrar, button_borrado;
    private String notaanterior;
    String nombre, dni, tlf, nombre1, dni1, resultado = "";
    String nombre2, dni2, tlf2;
    ArrayList<Paciente> pacientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_nombre = (EditText) findViewById(R.id.editText_nombre);
        editText_dni = (EditText) findViewById(R.id.editText_dni);
        button_iniciarsesion = (Button) findViewById(R.id.button_iniciarsesion);
        button_registrar = (Button) findViewById(R.id.button_registrar);
        button_borrado = (Button) findViewById(R.id.button_borrado);

        pulsarInicioSesion();
        registrarse();
    }


    //Inicio de sesión de paciente en base de datos
    public void pulsarInicioSesion(){
        button_iniciarsesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Leo el nombre y el DNI introducido por el usuario
                nombre = editText_nombre.getText().toString();
                dni = editText_dni.getText().toString();

                //Si el campo del nombre o del DNI está vacío no puedo realizar la búsqueda.
                if(nombre.length()==0 || dni.length()==0) {
                    Toast.makeText(MainActivity.this, "Debe introducir todos los campos con anterioridad", Toast.LENGTH_SHORT).show();
                    //Vacío de nuevo los campos.
                    editText_nombre.setText("");
                    editText_dni.setText("");
                } else {

                    boolean comprobar = validarNif(dni);

                    if(!comprobar) {
                        Toast.makeText(MainActivity.this, "Formato dni incorrecto", Toast.LENGTH_SHORT).show();
                    }

                   // Toast.makeText(MainActivity.this, tlf, Toast.LENGTH_SHORT).show();
                    leerDatosPaciente();
                    leerDatosTest();

                   if (pacientes.size() > 0) {
                        Toast.makeText(MainActivity.this, "Se ha encontrado al paciente", Toast.LENGTH_SHORT).show();
                       //Paso la nota anterior del text realizado por el usuario a la activity de activity_ventana_nota.xml
                       Intent i = new Intent(v.getContext(),VentanaPostFormularioUR.class);
                       i.putExtra("nombre",nombre1);
                       i.putExtra("tlf",tlf);
                       i.putExtra("dni",dni1);
                       i.putExtra("res", resultado);
                       startActivity(i);
                    } else {
                        Toast.makeText(MainActivity.this, "No se ha encontrado al paciente", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }

    public void leerDatosPaciente() {
        //Instancio la conexión con la base de datos
        AdminSQLiteOpenHelper adminHelper = new AdminSQLiteOpenHelper(this,"registro",null,1);
        //Abro la conexión de base de datos, con permisos de lectura.
        SQLiteDatabase db = adminHelper.getReadableDatabase();

        //Hacemos la búsqueda del paciente.

        //Array que incluye los campos/columnas de la tabla Paciente, sobre la que hacer la consulta.
        String[] columnas = {"nombre","telefono","dni"};

        //Filtros de la consulta para aplicar en la cláusula WHERE "nombre" = nombre and "dni" = dni.
        String seleccion = "dni" + " = ?";
        String[] condicion = {dni};

        //El resultado de la consulta de select se guarda en el Cursor
        Cursor c = db.query("Paciente",columnas,seleccion,condicion,null,null,null);
        //Recorrer el array de resultados (cursor) para mostrar al usario la informacion
        //obtenida dentro de los campos del formulario.
        pacientes = new ArrayList<>();
        while(c.moveToNext()) {
            nombre1 = c.getString(c.getColumnIndexOrThrow("nombre"));
            tlf = c.getString(c.getColumnIndexOrThrow("telefono"));
            dni1 = c.getString(c.getColumnIndexOrThrow("dni"));
            Paciente paciente = new Paciente(nombre1,tlf,dni1);
            pacientes.add(paciente);
        }
        c.close();
        db.close();
    }

    public boolean validarNif(String nif) {
        return nif.matches(("^[0-9]{8}[A-Z]{1}$"));
    }

    public void leerDatosTest() {
        AdminSQLiteOpenHelper adminHelper1 = new AdminSQLiteOpenHelper(this,"registro",null,1);
        SQLiteDatabase db1 = adminHelper1.getReadableDatabase();
        String[] columnas1 = {"dni", "resultado"};
        String seleccion1 = "dni" + " = ?";
        String[] condicion1= {dni};
        Cursor c1 = db1.query("Test",columnas1,seleccion1,condicion1,null,null,null);
        while(c1.moveToNext()) {
            resultado = c1.getString(c1.getColumnIndexOrThrow("resultado"));
        }
        c1.close();
        db1.close();
    }

    public void registrarse() {
        button_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),VentanaFormulario.class);
                startActivity(i);
            }
        });
    }



    public void borrar() {
        button_borrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),BorrarPaciente.class);
                startActivity(i);
            }
        });
    }

}