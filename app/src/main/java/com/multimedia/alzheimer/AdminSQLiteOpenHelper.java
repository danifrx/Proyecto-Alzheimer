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
                        "numPaciente integer PRIMARY KEY AUTOINCREMENT, " +
                        "nombre CHAR(20), " +
                        "apellidos CHAR(50), " +
                        "resultadoAnterior TINYINT, " +
                        "fecha DATE, " +
                        "telefono CHAR(9), " +
                        "dni CHAR(9))";

        db.execSQL(crear_tabla_paciente);

       final String crear_tabla_test =
                "CREATE TABLE Test (" +
                        "numText INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "numPaciente INTEGER, " +
                        "fecha DATE, " +
                        "r1 CHAR(20), " +
                        "r2 CHAR(20), " +
                        "r3 CHAR(20), " +
                        "r4 CHAR(20), " +
                        "r5 CHAR(20), " +
                        "r6 CHAR(20), " +
                        "FOREIGN KEY (numPaciente) REFERENCES Paciente(numPaciente))";
        db.execSQL(crear_tabla_test);
    }

    //Método para hacer cambio de versión de base de datos
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //gestion de cache online y cambio de version de base de datos
        // -> de momento no nos interesa realizar acciones en este caso
        //non sei que significa esto chavales, non teño a tecnología suficiente por ahora
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        //db.execSQL("DROP TABLE IF EXISTS Paciente");
        //onCreate(db);

    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}
