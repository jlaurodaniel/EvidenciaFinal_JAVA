package com.example.actv13;

import java.io.Serializable;

public class Usuario implements Serializable {
    public Usuario(String id, String nombre, String password) {
        this.id = id;
        this.nombre = nombre;
        this.password = password;
    }

    public String id;
    public String nombre;
    public String password;
}
