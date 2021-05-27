package com.example.actv13;

public class Cita {
    public int id;
    public  String fecha;
    public String motivo;
    public Paciente paciente;
    public Doctor doctor;

    public Cita(int id, String fecha, String motivo, Paciente paciente, Doctor doctor) {
        this.id = id;
        this.fecha = fecha;
        this.motivo = motivo;
        this.paciente = paciente;
        this.doctor = doctor;
    }
}
