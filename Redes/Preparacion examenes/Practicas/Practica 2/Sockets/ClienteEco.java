import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.io.PrintWriter;
/**
 * Write a description of class ClienteEco here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClienteEco{
    public static void main(String[] args){
        String hola = "¡¡Hola Mundo!!";
        try{
            InetAddress dirIp = InetAddress.getByName("zoltar.redes.upv.es");
            Socket cliente = new Socket(dirIp,7);
            System.out.println("Conectado");
            Scanner s = new Scanner(cliente.getInputStream());
            PrintWriter p = new PrintWriter(cliente.getOutputStream(), false);
            p.println(hola);
            System.out.println("Se envia el mensaje: " + hola);
            p.flush();
            System.out.print("Se recibe el mensaje:");
            while(s.hasNextLine()){
                System.out.println(s.nextLine());
            }
            p.close();
            s.close();
            cliente.close();
            System.out.println("Todos los sistemas finalizados.");
        }catch(UnknownHostException e){
            System.out.println("Error 1");
        }catch(IOException e2){
            System.out.println("Error 2.");
        }
    }
}
