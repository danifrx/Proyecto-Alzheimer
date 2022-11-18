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
                        "numPaciente integer primary key, " +
                        "nombre char(20), " +
                        "apellidos char(50), " +
                        "resultadoAnterior tinyint, " +
                        "fecha date, " +
                        "telefono char(9), " +
                        "dni char(9))";
        db.execSQL(crear_tabla_paciente);

        final String crear_tabla_text =
                "CREATE TABLE Text (" +
                        "numText integer primary key autoincrement, " +
                        "numPaciente integer, " +
                        "fecha date, " +
                        "r1 char(20), " +
                        "r2 char(20), " +
                        "r3 char(20), " +
                        "r4 char(20), " +
                        "r5 char(20), " +
                        "r6 char(20), " +
                        "foreign key (numPaciente) references Paciente(numPaciente))";
        db.execSQL(crear_tabla_text);
    }

    //Método para hacer cambio de versión de base de datos
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //gestion de cache online y cambio de version de base de datos
        // -> de momento no nos interesa realizar acciones en este caso
        //non sei que significa esto chavales, non teño a tecnología suficiente por ahora
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}
