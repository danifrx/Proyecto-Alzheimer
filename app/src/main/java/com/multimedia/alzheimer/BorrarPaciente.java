package com.multimedia.alzheimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BorrarPaciente extends AppCompatActivity {

    private EditText editText_borrarPaciente;
    private Button button_borrar, button_volver;
    private String dni, dniComprobar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrar_paciente);

        editText_borrarPaciente = (EditText) findViewById(R.id.editText_borrarPaciente);
        button_borrar = (Button) findViewById(R.id.button_borrar);
        button_volver = (Button) findViewById(R.id.button_volver);

        borrar();
        volver();

    }

    private void volver() {
        button_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }

    public void borrarPaciente() {
        AdminSQLiteOpenHelper adminHelper = new AdminSQLiteOpenHelper(this, "registro", null, 1);
        SQLiteDatabase db = adminHelper.getWritableDatabase();

        String seleccion = "dni" + " = ?";
        String[] condicion = {dni};

        db.delete("Paciente",seleccion,condicion);

        db.close();
    }

    public void borrarTest() {
        AdminSQLiteOpenHelper adminHelper1 = new AdminSQLiteOpenHelper(this, "registro", null, 1);
        SQLiteDatabase db1 = adminHelper1.getWritableDatabase();

        String seleccion = "dni" + " = ?";
        String[] condicion = {dni};

        db1.delete("Test",seleccion,condicion);

        db1.close();
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

    public void borrar() {
        button_borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dni = editText_borrarPaciente.getText().toString();
                if(dni.length()==0){
                    Toast.makeText(v.getContext(), "Rellene el campo del dni para realizar la baja", Toast.LENGTH_SHORT).show();
                } else {
                    boolean comprobar = validarNif(dni);
                    if(!comprobar) {
                        Toast.makeText(v.getContext(), "Formato dni incorrecto", Toast.LENGTH_SHORT).show();
                    }
                    leerDatosPaciente();
                    if (dniComprobar == null) {
                        Toast.makeText(v.getContext(), "Paciente no encontrado", Toast.LENGTH_SHORT).show();
                    } else {
                        borrarTest();
                        borrarPaciente();
                        Toast.makeText(v.getContext(), "Paciente eliminado", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(v.getContext(), MainActivity.class);
                        startActivity(i);
                    }
                }


            }
        });
    }
    public boolean validarNif(String nif) {
        return nif.matches(("^[0-9]{8}[A-Z]{1}$"));
    }
}