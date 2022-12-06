package com.multimedia.alzheimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BorrarPaciente extends AppCompatActivity {

    private EditText editText_borrarPaciente;
    private Button button_borrar;
    private String dni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrar_paciente);

        editText_borrarPaciente = (EditText) findViewById(R.id.editText_borrarPaciente);
        button_borrar = (Button) findViewById(R.id.button_borrar);

        borrar();

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

    public void borrar() {
        button_borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dni = editText_borrarPaciente.getText().toString();
                if(dni.length()==0){
                    Toast.makeText(v.getContext(), "Rellene el campo código para realizar la baja", Toast.LENGTH_SHORT).show();
                } else {
                    borrarTest();
                    borrarPaciente();
                    Toast.makeText(v.getContext(), "Paciente eliminado", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(v.getContext(),MainActivity.class);
                    startActivity(i);
                }


            }
        });
    }
}