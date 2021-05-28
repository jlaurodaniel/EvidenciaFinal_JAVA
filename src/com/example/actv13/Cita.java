package com.example.actv13;

import java.io.*;
import java.util.ArrayList;

public class Cita {
    private final String path="C:\\Users\\lauro\\OneDrive - Universidad Tecmilenio\\tarea\\TECMILENIO\\6to SEMESTRE\\Computacion en Java\\EvidenciaFinal\\src\\db\\cita.txt";
    public String id;
    public  String fecha;
    public String motivo;
    public Paciente paciente;
    public Doctor doctor;

    public Cita(String id, String fecha, String motivo, Paciente paciente, Doctor doctor) {
        this.id = id;
        this.fecha = fecha;
        this.motivo = motivo;
        this.paciente = paciente;
        this.doctor = doctor;
    }

    public Boolean altaCita() throws IOException, ClassNotFoundException {
        ArrayList<Cita> citas;
        ObjectInputStream leyendoFichero = new ObjectInputStream( new FileInputStream(this.path) );
        citas = ( ArrayList <Cita> )leyendoFichero.readObject();
        leyendoFichero.close();

        if (citas.add(new Cita(this.id,this.fecha,this.motivo,this.paciente,this.doctor))){
            ObjectOutputStream escribiendoFichero = new ObjectOutputStream(new FileOutputStream(this.path) );
            escribiendoFichero.writeObject(citas);
            escribiendoFichero.close();
            return true;
        }
        return false;
    }

    public Boolean eliminarCita(String uuid) throws IOException, ClassNotFoundException {
        File archivo = new File(this.path);
        if (archivo.exists()){
            ArrayList<Cita> citas;
            ObjectInputStream leyendoFichero = new ObjectInputStream( new FileInputStream(this.path) );
            citas = ( ArrayList <Cita> )leyendoFichero.readObject();
            leyendoFichero.close();

            for (int i=0;i<citas.size();i++){
                if (citas.get(i).id.equals(uuid)){
                    citas.remove(i);
                    //guardar fichero de nuevo
                    ObjectOutputStream escribiendoFichero = new ObjectOutputStream(new FileOutputStream(this.path) );
                    escribiendoFichero.writeObject(citas);
                    escribiendoFichero.close();
                    return true;
                }
            }
        }

        return false;
    }
}
