package com.multimedia.alzheimer;

import java.util.Date;

public class Paciente {
        private long numPaciente;
        private String nombre;
        private String apellidos;
        private int resultadoAnterior;
        private String telefono;
        private String dni;

        public Paciente() {
        }

        public Paciente(long numPaciente, String nombre, String apellidos, int resultadoAnterior, String telefono, String dni) {
                this.numPaciente = numPaciente;
                this.nombre = nombre;
                this.apellidos = apellidos;
                this.resultadoAnterior = resultadoAnterior;
                this.telefono = telefono;
                this.dni = dni;
        }

        public Paciente(long numPaciente, String nombre, String apellidos, String fecha, String telefono, String dni) {
                this.numPaciente = numPaciente;
                this.nombre = nombre;
                this.apellidos = apellidos;
                this.telefono = telefono;
                this.dni = dni;
        }

        public Paciente(int resultadoAnterior) {
                this.resultadoAnterior = resultadoAnterior;
        }

        public long numPaciente() {
                return numPaciente;
        }

        public void numPaciente(long numPaciente) {
                this.numPaciente = numPaciente;
        }

        public String getNombre() {
                return nombre;
        }

        public void setNombre(String nombre) {
                this.nombre = nombre;
        }

        public String getApellidos() {
                return apellidos;
        }

        public void setApellidos(String apellidos) {
                this.apellidos = apellidos;
        }

        public int getResultadoAnterior() {
                return resultadoAnterior;
        }

        public void setResultadoAnterior(int resultadoAnterior) {
                this.resultadoAnterior = resultadoAnterior;
        }

        public String getTelefono() {
                return telefono;
        }

        public void setTelefono(String telefono) {
                this.telefono = telefono;
        }

        public String getDni() {
                return dni;
        }

        public void setDni(String dni) {
                this.dni = dni;
        }
}
