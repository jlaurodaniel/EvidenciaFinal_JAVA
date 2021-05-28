package com.example.actv13;

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
                        break;
                    case 4:
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
