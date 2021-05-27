package com.example.actv13;

import java.io.*;
import java.util.ArrayList;

public class Administrador extends Usuario{
    public String rol;
    private final String path="C:\\Users\\lauro\\OneDrive - Universidad Tecmilenio\\tarea\\TECMILENIO\\6to SEMESTRE\\Computacion en Java\\EvidenciaFinal\\src\\db\\admin.txt";

    public Administrador(String id, String nombre, String password,  String rol) {
        super(id, nombre, password);
        this.rol = rol;
    }

    public Boolean altaAdministrador() throws IOException, ClassNotFoundException {

        ArrayList<Administrador> administradors;
        ObjectInputStream leyendoFichero = new ObjectInputStream( new FileInputStream(this.path) );
        administradors = ( ArrayList <Administrador> )leyendoFichero.readObject();
        leyendoFichero.close();


        if (administradors.add(new Administrador(this.id,this.nombre,this.password,this.rol))){
            ObjectOutputStream escribiendoFichero = new ObjectOutputStream(new FileOutputStream(this.path) );
            escribiendoFichero.writeObject(administradors);
            escribiendoFichero.close();
            return true;
        }

        return false;
    }

    public Boolean ModificarDoctor(String user,String password,String especialidad) throws IOException, ClassNotFoundException {

        ArrayList<Doctor> doctors;
        ObjectInputStream leyendoFichero = new ObjectInputStream( new FileInputStream(this.path) );
        doctors = ( ArrayList <Doctor> )leyendoFichero.readObject();
        leyendoFichero.close();

        for (int i=0;i<doctors.size();i++){
            if (doctors.get(i).nombre.equals(user) & doctors.get(i).password.equals(password)){
                doctors.set(i,new Doctor(doctors.get(i).id,user,password,especialidad));
                return true;
            }
        }

            ObjectOutputStream escribiendoFichero = new ObjectOutputStream(new FileOutputStream(this.path) );
            escribiendoFichero.writeObject(doctors);
            escribiendoFichero.close();

            return false;
    }
}
