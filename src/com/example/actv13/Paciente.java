package com.example.actv13;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Paciente extends Usuario {
    public String padecimiento;
    private final String path="C:\\Users\\lauro\\OneDrive - Universidad Tecmilenio\\tarea\\TECMILENIO\\6to SEMESTRE\\Computacion en Java\\EvidenciaFinal\\src\\db\\paciente.txt";
    private final Scanner sc= new Scanner(System.in);

    public Paciente(String id, String nombre, String password, String padecimiento) {
        super(id, nombre, password);
        this.padecimiento = padecimiento;
    }


    public Boolean altaPaciente() throws IOException, ClassNotFoundException {

        ArrayList<Paciente> pacientes=new ArrayList<Paciente>();
        File archivo = new File(this.path);
        if (archivo.exists()) {
            ObjectInputStream leyendoFichero = new ObjectInputStream(new FileInputStream(this.path));
            pacientes = (ArrayList<Paciente>) leyendoFichero.readObject();
            leyendoFichero.close();
        }

        if (pacientes.add(new Paciente(this.id,this.nombre,this.password,this.padecimiento))){
            ObjectOutputStream escribiendoFichero = new ObjectOutputStream(new FileOutputStream(this.path) );
            escribiendoFichero.writeObject(pacientes);
            escribiendoFichero.close();
            return true;
        }

        return false;
    }
}
