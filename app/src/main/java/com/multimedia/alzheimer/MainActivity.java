package com.multimedia.alzheimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView_titulo;
    private TextView textView_subtitulo;
    private EditText editText_nombre;
    private EditText editText_dni;
    private Button button_iniciarsesion;
    private Button button_registrar;
    private String notaanterior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_nombre = (EditText) findViewById(R.id.editText_nombre);
        editText_dni = (EditText) findViewById(R.id.editText_dni);
        button_iniciarsesion = (Button) findViewById(R.id.button_iniciarsesion);
        button_registrar = (Button) findViewById(R.id.button_registrar);

        pulsarInicioSesion();
    }

    //Inicio de sesión de paciente en base de datos
    public void pulsarInicioSesion(){
        button_iniciarsesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Instancio la conexión con la base de datos
                AdminSQLiteOpenHelper adminHelper = new AdminSQLiteOpenHelper(this,"registro",null,1);
                //Abro la conexión de base de datos, con permisos de lectura.
                SQLiteDatabase db = adminHelper.getReadableDatabase();

                //Leo el nombre y el DNI introducido por el usuario
                String nombre = editText_nombre.getText().toString();
                String dni = editText_dni.getText().toString();

                //Si el campo del nombre o del DNI está vacío no puedo realizar la búsqueda.
                if(nombre.length()==0 || dni.length()==0){
                    Toast.makeText(MainActivity.this, "Debe introducir todos los campos con anterioridad", Toast.LENGTH_SHORT).show();
                    //Vacío de nuevo los campos.
                    editText_nombre.setText("");
                    editText_dni.setText("");
                } else {
                    //Hacemos la búsqueda del paciente.

                    //Array que incluye los campos/columnas de la tabla Paciente, sobre la que hacer la consulta.
                    String[] columnas = {"numPaciente","nombre","apellidos","resultado","fechaNacimiento","tlf","dni"};

                    //Filtros de la consulta para aplicar en la cláusula WHERE "nombre" = nombre and "dni" = dni.
                    String seleccion = "dni" + " = ?";
                    String[] condicion = {dni};

                    //El resultado de la consulta de select se guarda en el Cursor
                    Cursor sesioniniciada = db.query("paciente",columnas, seleccion, condicion, null, null, null);

                    while(sesioniniciada.moveToNext()){
                        notaanterior = Integer.toString(sesioniniciada.getInt(3));
                    }
                    sesioniniciada.close();

                    //Paso la nota anterior del text realizado por el usuario a la activity de activity_ventana_nota.xml
                    Intent i = new Intent(v.getContext(),VentanaNota.class);
                    i.putExtra("nota",notaanterior);
                    startActivity(i);
                }
                db.close();

            }
        });
    }

}