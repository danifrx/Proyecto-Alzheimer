package com.multimedia.alzheimer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelper (Context context, String nombreDB, SQLiteDatabase.CursorFactory factory, int version) {
        super (context, nombreDB, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        final String crear_tabla_paciente =
                "CREATE TABLE Paciente (" +
                        "nombre CHAR(20), " +
                        "telefono CHAR(9), " +
                        "dni CHAR(9) primary key)";

        db.execSQL(crear_tabla_paciente);

       final String crear_tabla_test =
               "CREATE TABLE Test (" +
                       "resultado INTEGER, " +
                       "dni CHAR(9) primary key, " +
                       "FOREIGN KEY (dni) REFERENCES Paciente(dni))";
        db.execSQL(crear_tabla_test);
    }

    //Método para hacer cambio de versión de base de datos
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}
