package com.example.actv13;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Paciente extends Usuario implements Serializable {
    public String padecimiento;

    public Paciente(String id, String nombre, String password, String padecimiento) {
        super(id, nombre, password);
        this.padecimiento = padecimiento;
    }


    public Boolean altaPaciente() throws IOException, ClassNotFoundException {

        ArrayList<Paciente> pacientes=new ArrayList<Paciente>();
        String path = "C:\\Users\\lauro\\OneDrive - Universidad Tecmilenio\\tarea\\TECMILENIO\\6to SEMESTRE\\Computacion en Java\\EvidenciaFinal\\src\\db\\paciente.txt";
        File archivo = new File(path);
        if (archivo.exists()) {
            ObjectInputStream leyendoFichero = new ObjectInputStream(new FileInputStream(path));
            pacientes = (ArrayList<Paciente>) leyendoFichero.readObject();
            leyendoFichero.close();
        }

        if (pacientes.add(new Paciente(this.id,this.nombre,this.password,this.padecimiento))){
            ObjectOutputStream escribiendoFichero = new ObjectOutputStream(new FileOutputStream(path) );
            escribiendoFichero.writeObject(pacientes);
            escribiendoFichero.close();
            return true;
        }

        return false;
    }
}
