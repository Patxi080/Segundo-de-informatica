import java.util.Scanner;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/*Escribe un programa en java, llamado “ClienteEco”, que conecte al puerto 7 
(servicio de eco) del servidor “zoltar.redes.upv.es”, transmita la línea de 
texto “¡¡Hola, Mundo!!”, lea la primera línea de texto que devuelve el servidor 
y la imprima por pantalla, de forma similar al ejercicio 4. */

public class ClienteEco {
    public static void main(String[] args){
        //Parámetros
        int port = 7;
        String host = "zoltar.redes.upv.es";
        String enviar = "!!Hola mundo¡¡";
        //Socket
        try {
            Socket s = new Socket(host,port);
            PrintWriter p = new PrintWriter(s.getOutputStream(),false);
            p.println(enviar);
            p.flush();
            System.out.println("Mensaje enviado.");
            Scanner scan = new Scanner(s.getInputStream());
            System.out.println("Recibiendo respuesta:");
            System.out.println(scan.nextLine());
            
        } catch (UnknownHostException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
    }
}
