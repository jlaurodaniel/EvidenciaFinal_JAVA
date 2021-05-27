package com.example.actv13;

public class Doctor extends  Usuario{
    public Usuario usuario;
    public String especialidad;

    public Doctor(int id, String nombre, String password, Usuario usuario, String especialidad) {
        super(id, nombre, password);
        this.usuario = usuario;
        this.especialidad = especialidad;
    }
}
