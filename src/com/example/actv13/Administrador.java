package com.example.actv13;

public class Administrador extends Usuario{
    public Usuario usuario;
    public String rol;

    public Administrador(int id, String nombre, String password, Usuario usuario, String rol) {
        super(id, nombre, password);
        this.usuario = usuario;
        this.rol = rol;
    }
}
