package com.multimedia.alzheimer;

import java.util.Date;

public class Paciente {
        private int nunPaciente;
        private String nombre;
        private String apellidos;
        private int resultadoAnterior;
        private Date fecha;
        private String telefono;
        private String dni;

        public Paciente() {
        }

        public Paciente(int nunPaciente, String nombre, String apellidos, int resultadoAnterior, Date fecha, String telefono, String dni) {
                this.nunPaciente = nunPaciente;
                this.nombre = nombre;
                this.apellidos = apellidos;
                this.resultadoAnterior = resultadoAnterior;
                this.fecha = fecha;
                this.telefono = telefono;
                this.dni = dni;
        }

        public Paciente(int nunPaciente, String nombre, String apellidos, Date fecha, String telefono, String dni) {
                this.nunPaciente = nunPaciente;
                this.nombre = nombre;
                this.apellidos = apellidos;
                this.fecha = fecha;
                this.telefono = telefono;
                this.dni = dni;
        }

        public Paciente(int resultadoAnterior) {
                this.resultadoAnterior = resultadoAnterior;
        }

        public int getNunPaciente() {
                return nunPaciente;
        }

        public void setNunPaciente(int nunPaciente) {
                this.nunPaciente = nunPaciente;
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

        public Date getFecha() {
                return fecha;
        }

        public void setFecha(Date fecha) {
                this.fecha = fecha;
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
