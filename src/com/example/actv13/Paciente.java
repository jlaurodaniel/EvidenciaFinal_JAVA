package com.example.actv13;

public class Paciente extends Usuario {
    public Usuario usuario ;
    public String padecimiento;

    public Paciente(int id, String nombre, String password, Usuario usuario, String padecimiento) {
        super(id, nombre, password);
        this.usuario = usuario;
        this.padecimiento = padecimiento;
    }
}
