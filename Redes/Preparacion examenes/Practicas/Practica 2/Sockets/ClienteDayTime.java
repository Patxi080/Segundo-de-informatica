import java.net.*;
import java.util.Scanner;
import java.io.*;
/**
 * Write a description of class ClienteDayTime here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClienteDayTime
{
  public static void main(String[] args){
        try{
            InetAddress dirIp =  InetAddress.getByName("zoltar.redes.upv.es");
            Socket cliente = new Socket(dirIp, 13);
            Scanner p = new Scanner(cliente.getInputStream());
            while(p.hasNextLine()){
                System.out.println(p.nextLine());
            }
            cliente.close();
            p.close();
        }catch(UnknownHostException e1){
            System.out.println("Error1. No se ha podido contactar con el servidor.");
        }catch(IOException e2){
            System.out.println("Error2. I/O exception.");
        }
  }
}
