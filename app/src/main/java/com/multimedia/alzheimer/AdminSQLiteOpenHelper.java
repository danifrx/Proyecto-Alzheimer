package com.multimedia.alzheimer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;



public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    private static final String crear_tabla_paciente = "CREATE TABLE Paciente (numPaciente INTEGER PRIMARY KEY AUTOINCREMENT, nombre varchar(20), apellidos varchar(30), resultadoAnterior INTEGER, fecha DATE, telefono char(9), dni char(9))";

   // private static final String crear_tabla_paciente = "CREATE TABLE Paciente (numPaciente INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, apellidos TEXT, resultadoAnterior INTEGER, fecha DATE, telefono TEXT, dni TEXT)";

 /*private static final String crear_tabla_paciente =
                "CREATE TABLE Paciente (" +
                        "numPaciente integer primary key autoincrement, " +
                        "nombre char(20), " +
                        "apellidos char(50), " +
                        "resultadoAnterior tinyint, " +
                        "fecha date, " +
                        "telefono char(9), " +
                        "dni char(9))";
 */

    public AdminSQLiteOpenHelper (View.OnClickListener context, String nombreDB, SQLiteDatabase.CursorFactory factory, int version) {
        super ((Context) context, nombreDB, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      /*  final String crear_tabla_paciente =
                "CREATE TABLE Paciente (" +
                        "numPaciente integer primary key autoincrement, " +
                        "nombre char(20), " +
                        "apellidos char(50), " +
                        "resultadoAnterior tinyint, " +
                        "fecha date, " +
                        "telefono char(9), " +
                        "dni char(9))";*/

        db.execSQL(crear_tabla_paciente);

       /* final String crear_tabla_test =
                "CREATE TABLE Test (" +
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
        db.execSQL(crear_tabla_test);*/
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
