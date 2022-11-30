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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_formulario);

        editTextText_Nombre = (EditText) findViewById(R.id.editTextText_Nombre);
        editTextText_Apellidos = (EditText) findViewById(R.id.editTextText_Apellidos);
        editTextText_Fecha = (EditText) findViewById(R.id.editTextText_Fecha);
        editTextText_Telefono = (EditText) findViewById(R.id.editTextText_Telefono);
        editTextText_Dni = (EditText) findViewById(R.id.editTextText_Dni);
        button_GuardarDatos = (Button) findViewById(R.id.button_GuardarDatos);

        alta();
    }

    //Alta de paciente en base de datos
    public void alta(){
        button_GuardarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Instancio la conexión con la BBDD
                AdminSQLiteOpenHelper adminHelper = new AdminSQLiteOpenHelper(v.getContext(),"pacientes", null, 1);
                //Abro la conexión de base de datos, con permisos de escritura para realizar las altas
                SQLiteDatabase db = adminHelper.getWritableDatabase();

                //Recogemos la información que el usuario rellenó en los campos del formulario
                String nombre = editTextText_Nombre.getText().toString();
                String apellidos = editTextText_Apellidos.getText().toString();
                String fecha = editTextText_Fecha.getText().toString();
                String tlf = editTextText_Telefono.getText().toString();
                String dni = editTextText_Dni.getText().toString();

                //Si no rellenó todos los valores del formulario error y no se genera alta de paciente.
                if(nombre.length()==0 || apellidos.length()==0 || fecha.length()==0 || tlf.length()==0 || dni.length()==0){
                    Toast.makeText(v.getContext(), "Debes rellenar todos los datos para el registro", Toast.LENGTH_SHORT).show();
                } else {
                    //Todos los datos están cubiertos para dar de alta un paciente.

                    //Preparar la información anterior en un array de valores para incluirlos en la consulta de insert
                    ContentValues valores = new ContentValues();

                    valores.put("nombre",nombre);
                    valores.put("apellidos",apellidos);
                    valores.put("fecha",fecha);
                    valores.put("telefono",tlf);
                    valores.put("dni",dni);
                    //Incremento de la del num del paciente.
                    db.insert("Paciente",null,valores);

                    //Vacío campos del formulario.
                    editTextText_Nombre.setText("");
                    editTextText_Apellidos.setText("");
                    editTextText_Fecha.setText("");
                    editTextText_Telefono.setText("");
                    editTextText_Dni.setText("");

                    //Mensaje informativo
                    Toast.makeText(v.getContext(), "Paciente dado de alta", Toast.LENGTH_SHORT).show();
                    cambio(v);
                }



                //Cierro conexión con BBDD.
                db.close();
            }
        });



    }

    public void cambio (View v) {
        //Mando al usuario a la activity de VentanaPostFormulario
        Intent i = new Intent(v.getContext(),VentanaPostFormulario.class);
        startActivity(i);
    }

}