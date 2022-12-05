package com.multimedia.alzheimer;

import java.util.Date;

public class Test {
    private String dni;
    private String resultado;

    public Test() {

    }

    public Test(String dni, String resultado) {
        this.dni = dni;
        this.resultado = resultado;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
