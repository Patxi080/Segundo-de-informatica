import java.net.*;
import java.util.Scanner;
import java.io.*;
public class ClienteSMTP{
    public static void main(String[] args){
        final int port = 25;
        final String IP = "smtp.upv.es";
        final String peticion = "HELO rdcXX.redes.upv.es";
        try{
            InetAddress dirIp = InetAddress.getByName(IP);
            Socket cliente = new Socket(dirIp, port);
            System.out.println("Sistemas en linea.");
            Scanner s = new Scanner(cliente.getInputStream());
            System.out.print("Mensaje leido: ");
          //while(s.hasNextLine()){
                System.out.println(s.nextLine());
          //}
            System.out.println("Enviamos el mensaje: " + peticion);
            PrintWriter p = new PrintWriter(cliente.getOutputStream(), true);
            p.println(peticion);
            System.out.print("Mensaje leido: ");
            //while(s.hasNextLine()){
                System.out.println(s.nextLine());
            //}
            cliente.close();
            p.close();
            s.close();
            System.out.println("Sistemas offline.");
        }
        catch (Exception uhe){
            System.out.println("Error.");
        }
    }
}
