package com.multimedia.alzheimer;

import java.util.Date;

public class Test {
    private String dni;
    private int resultado;

    public Test() {

    }

    public Test(String dni, int resultado) {
        this.dni = dni;
        this.resultado = resultado;
    }

    public Test(String dni) {
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
}
