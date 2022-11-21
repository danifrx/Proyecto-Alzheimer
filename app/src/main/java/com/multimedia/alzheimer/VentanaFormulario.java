package com.multimedia.alzheimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
    String nombre="";
    String apellidos="";
    String fecha="";
    String telefono="";
    String dni="";

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
        pulsar_button_Guardar ();
    }

    public void pulsar_button_Guardar () {
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
                    Intent i = new Intent(view.getContext(), Main.class);//falta por escribir a ventana a que vou enviar os datos
                    i.putExtra("Nombre",nombre);
                    i.putExtra("Apellidos",apellidos);
                    i.putExtra("Fecha",fecha);
                    i.putExtra("Telefono",telefono);
                    i.putExtra("Dni",dni);
                    startActivity(i);
                }

            }
        });
    }
}