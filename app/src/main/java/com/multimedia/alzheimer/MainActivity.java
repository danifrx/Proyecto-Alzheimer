package com.multimedia.alzheimer;

import androidx.appcompat.app.AppCompatActivity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_nombre = findViewById(R.id.editText_nombre);
        editText_dni = findViewById(R.id.editText_dni);
        button_iniciarsesion = findViewById(R.id.button_iniciarsesion);
        button_registrar = findViewById(R.id.button_registrar);
    }

    //Inicio de sesión de paciente en base de datos
    public void inicioSesion(View v){

        //Instancio la conexión con la base de datos
        AdminSQLiteOpenHelper adminHelper = new AdminSQLiteOpenHelper(this,"registro",null,1);
        //Abro la conexión de base de datos, con permisos de lectura.
        SQLiteDatabase db = adminHelper.getReadableDatabase();

        //Leo el nombre y el DNI introducido por el usuario
        String nombre = editText_nombre.getText().toString();
        String dni = editText_dni.getText().toString();

        //Si el campo del nombre o del DNI está vacío no puedo realizar la búsqueda.
        if(nombre.length()==0 || dni.length()==0){
            Toast.makeText(this, "Debe rellenar todos los campos para iniciar sesión", Toast.LENGTH_SHORT).show();
        } else {
            //Hacemos la búsqueda del paciente.

            //Array que incluye los campos/columnas de la tabla Paciente, sobre la que hacer la consulta.
            String[] columnas = {""};
        }
    }
}