package com.example.actv13;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    private String path;
public static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("--------------------------------------------");
        System.out.println("- Bienvenido ADMIN a la clinica 'El Tecmi'");
        System.out.println("--------------------------------------------");
        System.out.println("- Escribe tu nombre de usuario: ");
        String user=sc.nextLine();
        System.out.println("- Escribe tu nombre contraseña: ");
        String pass=sc.nextLine();
        System.out.println("--------------------------------------------");
    }
    //Paciente paciente=new Paciente();

    public  void Login(String pass, String user) throws IOException, ClassNotFoundException {
        Administrador UsuarioSession;
        boolean valid=false;
        boolean menu=true;

        ArrayList<Administrador> administradors= new ArrayList<Administrador>();
        ObjectInputStream leyendoFichero = new ObjectInputStream( new FileInputStream(path) );
        administradors = ( ArrayList <Administrador> )leyendoFichero.readObject();
        leyendoFichero.close();

        for (int i=0;i<administradors.size();i++){
            if (administradors.get(i).nombre.equals(user) & administradors.get(i).password.equals(pass)){
                 UsuarioSession=administradors.get(i);
                 valid=true;
            }
        }

        if (valid){
            System.out.println("---- Usuario y contraseña correctos  ------");
            while (menu){
                System.out.println("Escribe 1 para registrar un doctor" +
                        "Escribe 2 para registrar paciente\n" +
                        "Escribe 3 para registrar una cita\n" +
                        "Escribe 4 para eliminar una cita\n" +
                        "Escribe 5 para cerrar el programa");

                int answer=sc.nextInt();
                switch (answer){
                    case 1:
                        System.out.println("| * -------------------------------------------- * |");
                        System.out.println("| *     ********  Nuevo Doctor  *********        * |");
                        System.out.println("| * -------------------------------------------- * |");
                        System.out.println("| *     Escribe tu nombre o usuario :            * |");
                        String Dnombre=sc.nextLine();
                        System.out.println("| *  Escribe la contraseña para "+Dnombre+" :    * |");
                        String Dpassword=sc.nextLine();
                        System.out.println("| *  Que especialidad tiene?:                    * |");
                        String Despecialidad=sc.nextLine();
                        System.out.println("| *--------------------------------------------  * |");

                        UUID Duuid = UUID.randomUUID();
                        String Did = Duuid.toString();

                            Doctor doctor=new Doctor(Did,Dnombre,Dpassword,Despecialidad);
                        if (doctor.altaDoctor()){
                            System.out.println("*****  Doctor registrado satisfactoriamente   ****");
                        }else {
                            System.out.println("Ocurrio un problema al registrar el doctor, intente de nuevo");
                        }
                        break;
                    case 2:
                        System.out.println("| * -------------------------------------------- * |");
                        System.out.println("| *     ********  Nuevo Paciente  *********      * |");
                        System.out.println("| * -------------------------------------------- * |");
                        System.out.println("| *     Escribe tu nombre o usuario :            * |");
                        String nombre=sc.nextLine();
                        System.out.println("| *  Escribe la contraseña para "+nombre+" :     * |");
                        String password=sc.nextLine();
                        System.out.println("| *  Que padecimiento presenta actualmente?:     * |");
                        String padecimiento=sc.nextLine();
                        System.out.println("| *--------------------------------------------  * |");

                        UUID uuid = UUID.randomUUID();
                        String id = uuid.toString();

                        Paciente paciente=new Paciente(id,nombre,password,padecimiento);
                        if (paciente.altaPaciente()){
                            System.out.println("*****  Paciente registrado satisfactoriamente   ****");
                        }else {
                            System.out.println("Ocurrio un problema al registrar el paciente, intente de nuevo");
                        }
                        break;
                    case 3:
                        Doctor objDoctor = null;
                        Paciente objPaciente = null;
                        
                        System.out.println("| * -------------------------------------------- * |");
                        System.out.println("| *     ********  Nueva cita  *********      * |");
                        System.out.println("| * -------------------------------------------- * |");
                        System.out.println("| *     Escribe la fecha de la cita :            * |");
                        String fecha=sc.nextLine();
                        System.out.println("| *     Escribe el motivo de la cita:            * |");
                        String motivo=sc.nextLine();
                        System.out.println("| *--------------------------------------------  * |");                        

                        //Mostrando los doctores disponible para una cita
                        File archivo = new File(this.path);
                        if (archivo.exists()) {
                            ObjectInputStream leerFichero = new ObjectInputStream(new FileInputStream(this.path));
                            ArrayList<Doctor> doctors =  (ArrayList<Doctor>) leerFichero.readObject();
                            leyendoFichero.close();
                            System.out.println("****   doctores disponible para una cita   ****");
                            for (int i = 0; i < doctors.size(); i++) {
                                System.out.println("Doctor :"+doctors.get(i).nombre);
                            }
                            System.out.println("| *     Escribe el nombre del doctor que atendera la cita:            * |");
                            String nombreDoctor=sc.nextLine();

                            for (int i = 0; i < doctors.size(); i++) {
                                if (doctors.get(i).nombre.equals(nombreDoctor)) {
                                    objDoctor=doctors.get(i);
                                }
                            }
                        }

                        //Mostrando los pacientes disponible para una cita
                        File archivo2 = new File(this.path);
                        if (archivo2.exists()) {
                            ObjectInputStream leerFichero = new ObjectInputStream(new FileInputStream(this.path));
                            ArrayList<Paciente> pacientes  = (ArrayList<Paciente>) leerFichero.readObject();
                            leyendoFichero.close();
                            System.out.println("****   Pacientes disponible para una cita   ****");
                            for (int i = 0; i < pacientes.size(); i++) {
                                System.out.println("Paciente :"+pacientes.get(i).nombre);
                            }
                            System.out.println("| *     Escribe el nombre del doctor que atendera la cita:            * |");
                            String nombreDoctor=sc.nextLine();

                            for (int i = 0; i < pacientes.size(); i++) {
                                if (pacientes.get(i).nombre.equals(nombreDoctor)) {
                                     objPaciente=pacientes.get(i);
                                }
                            }
                        }
                        UUID Cuuid = UUID.randomUUID();
                        String Cid = Cuuid.toString();
                        Cita cita =new Cita(Cid,fecha,motivo,objPaciente,objDoctor);
                        if (cita.altaCita()){
                            System.out.println("**********  Cita creada con exito  *********");
                        }
                        break;
                    case 4:
                        //Mostrando los doctores disponible para una cita
                        File archivo3 = new File(this.path);
                        if (archivo3.exists()) {
                            ObjectInputStream leerFichero = new ObjectInputStream(new FileInputStream(this.path));
                            ArrayList<Cita> citas =  (ArrayList<Cita>) leerFichero.readObject();
                            leyendoFichero.close();
                            System.out.println("****   Citas existentes   ****");
                            for (int i = 0; i < citas.size(); i++) {
                                System.out.println("Id :"+citas.get(i).id+"\n" +
                                        "Fecha :"+citas.get(i).fecha+"\n" +
                                        "Doctor :"+citas.get(i).doctor.nombre+"\n" +
                                        "Paciente :"+citas.get(i).paciente.nombre+"\n");
                            }
                            System.out.println("| *     Escribe el Id de la cita que deas eliminar:       * |");
                            String idCita=sc.nextLine();

                            for (int i = 0; i < citas.size(); i++) {
                                if (citas.get(i).id.equals(idCita)) {
                                    citas.remove(i);
                                }
                            }
                        }
                        break;
                    case 5:
                        menu=false;
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
