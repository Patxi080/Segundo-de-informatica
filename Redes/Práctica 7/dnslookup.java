import java.net.*;
import java.io.*;
import java.util.Scanner;
/*
 * El ejercicio pide devolver la dirección IP de un dominio dado por la entrada estandar
 */
public class dnslookup {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca el nombre del dominio:");
        String dirección = teclado.nextLine(); //Pedimos la dirección
        try {//Todo el código relacionado con el InetAddress va en un try-catch
            InetAddress server = InetAddress.getByName(dirección);
            System.out.print("Dominio          ");
            System.out.println("Dirección IP");
            System.out.println("------------------------------");
            System.out.print(dirección + "        ");
            System.out.println(server.toString());
        } catch (Exception e) {//En caso de que no se resuelva la dirección.
            // TODO: handle exception
            System.out.println("Se ha producido un error.");
        }
        
    }
    
}