import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
public class Ejercicio_8 {
    public static void main(String[] args) {
        int port = 25;
        String host = "smtp.upv.es";
        String mensaje = "Hello ordenadorDespacho.redes.upv.es";
        System.setProperty("line.separator", "\r\n");
        try {
            Socket s = new Socket(host, port);
            Scanner scan = new Scanner(s.getInputStream());
            System.out.println("El puerto devuelve:");
            System.out.println(scan.nextLine()); 
            PrintWriter p = new PrintWriter(s.getOutputStream(), true);
            System.out.println("Enviamos el mensaje: " + mensaje);
            p.println(mensaje);
            System.out.println("Recibimos el mensaje:" + scan.nextLine());
            
            
        } catch (UnknownHostException e) {
            e.getMessage();
        }catch(IOException  e2){
            e2.getMessage();
        }
    }
}
