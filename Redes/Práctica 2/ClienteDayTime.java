import java.util.Scanner;
import java.net.*;
import java.io.*;

public class ClienteDayTime {
    public static void main(String[] args){

        int port = 13;
        String direction = "zoltar.redes.upv.es";

        try {

            Socket p = new Socket(direction,port);
            Scanner leer = new Scanner(p.getInputStream());
            System.out.println("Empezamos a leer:");
            System.out.println(leer.nextLine());
            System.out.println("Fin de la lectura, cerramos Scanner y socket");
            leer.close();
            System.out.println("Scanner cerrado");
            p.close();;
            System.out.println("Socket cerrado.");

        } catch (Exception e) {

            System.out.println("¡UPS, algo ha salido mal!");
        }   
        
    }
}
