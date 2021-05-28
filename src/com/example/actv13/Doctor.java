package com.example.actv13;

import java.io.*;
import java.util.ArrayList;

public class Doctor extends  Usuario{
    public String especialidad;
    private final String path="C:\\Users\\lauro\\OneDrive - Universidad Tecmilenio\\tarea\\TECMILENIO\\6to SEMESTRE\\Computacion en Java\\EvidenciaFinal\\src\\db\\doctor.txt";

    public Doctor(String id, String nombre, String password, String especialidad) {
        super(id, nombre, password);
        this.especialidad = especialidad;
    }

    public Boolean altaDoctor() throws IOException, ClassNotFoundException {
        ArrayList<Doctor> doctors =new ArrayList<Doctor> () ;
        File archivo = new File(this.path);
        if (archivo.exists()) {
            ObjectInputStream leyendoFichero = new ObjectInputStream(new FileInputStream(this.path));
            doctors = (ArrayList<Doctor>) leyendoFichero.readObject();
            leyendoFichero.close();
        }


        if (doctors.add(new Doctor(this.id,this.nombre,this.password,this.especialidad))){
            ObjectOutputStream escribiendoFichero = new ObjectOutputStream(new FileOutputStream(this.path) );
            escribiendoFichero.writeObject(doctors);
            escribiendoFichero.close();
            return true;
        }

        return false;
    }
}
