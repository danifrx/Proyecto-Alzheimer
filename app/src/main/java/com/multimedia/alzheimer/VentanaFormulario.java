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
    private EditText editTextPhone;
    private EditText editTextText_Dni;
    private Button button_GuardarDatos, button_volverdelformulario;
    private String nombre, dni, dniComprobar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_formulario);

        editTextText_Nombre = (EditText) findViewById(R.id.editTextText_Nombre);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        editTextText_Dni = (EditText) findViewById(R.id.editTextText_Dni);
        button_GuardarDatos = (Button) findViewById(R.id.button_GuardarDatos);
        button_volverdelformulario = (Button) findViewById(R.id.button_volverdelformulario);

        alta();
        volver();
    }

    private void volver() {
        button_volverdelformulario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }

    //Alta de paciente en base de datos
    public void alta(){
        button_GuardarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Instancio la conexión con la BBDD
                AdminSQLiteOpenHelper adminHelper = new AdminSQLiteOpenHelper(v.getContext(),"registro", null, 1);
                //Abro la conexión de base de datos, con permisos de escritura para realizar las altas
                SQLiteDatabase db = adminHelper.getWritableDatabase();

                //Recogemos la información que el usuario rellenó en los campos del formulario
                nombre = editTextText_Nombre.getText().toString();
                String tlf = editTextPhone.getText().toString();
                dni = editTextText_Dni.getText().toString();



                //Si no rellenó todos los valores del formulario error y no se genera alta de paciente.
                if(nombre.length()==0 || tlf.length()==0 || dni.length()==0){
                    Toast.makeText(v.getContext(), "Debes rellenar todos los datos para el registro", Toast.LENGTH_SHORT).show();
                } else {

                    boolean comprobarDni = validarNif(dni);
                    boolean comprobarTlf = validarTelefono(tlf);

                    if(!comprobarDni) {
                        Toast.makeText(VentanaFormulario.this, "Formato dni incorrecto", Toast.LENGTH_SHORT).show();
                    } else if (!comprobarTlf) {
                        Toast.makeText(VentanaFormulario.this, "Formato teléfono incorrecto", Toast.LENGTH_SHORT).show();
                    } else {
                        //leerDatosPaciente();



                            //Todos los datos están cubiertos para dar de alta un paciente.

                            //Preparar la información anterior en un array de valores para incluirlos en la consulta de insert
                            ContentValues valores = new ContentValues();

                            valores.put("nombre",nombre);
                            valores.put("telefono",tlf);
                            valores.put("dni",dni);
                            //Incremento de la del num del paciente.
                            db.insert("Paciente",null,valores);

                            //Vacío campos del formulario.
                            editTextText_Nombre.setText("");
                            editTextPhone.setText("");
                            editTextText_Dni.setText("");

                            //Mensaje informativo
                            Toast.makeText(v.getContext(), "Paciente dado de alta", Toast.LENGTH_SHORT).show();
                            cambio(v);


                    }

                }

                //Cierro conexión con BBDD.
                db.close();
            }
        });

    }

    public void leerDatosPaciente() {
        AdminSQLiteOpenHelper adminHelper1 = new AdminSQLiteOpenHelper(this,"registro",null,1);
        SQLiteDatabase db1 = adminHelper1.getReadableDatabase();
        String[] columnas = {"nombre", "telefono", "dni"};
        String seleccion = "dni" + " = ?";
        String[] condicion= {dni};
        Cursor c1 = db1.query("Paciente",columnas,seleccion,condicion,null,null,null);
        while(c1.moveToNext()) {
            dniComprobar = c1.getString(c1.getColumnIndexOrThrow("dni"));
        }
        c1.close();
        db1.close();
    }

    public boolean validarNif(String nif) {
        return nif.matches(("^[0-9]{8}[A-Z]{1}$"));
    }

    public boolean validarTelefono(String telefono) {
        return telefono.matches("^(9|8|7|6){1}[0-9]{8}$");
    }

    public void cambio (View v) {
        //Mando al usuario a la activity de VentanaPostFormulario2
        Intent i = new Intent(v.getContext(),VentanaPostFormulario2.class);
        i.putExtra("Nombre", nombre);
        i.putExtra("Dni", dni);
        startActivity(i);
    }

}