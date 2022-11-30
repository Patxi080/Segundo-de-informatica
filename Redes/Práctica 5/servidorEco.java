import java.net.*;
import java.util.Scanner;
import java.io.*;
/**
 * Ejercicio 1 
 */
public class servidorEco {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(7777);
            System.out.println("Escuchando: ");
            while (true) {
                Socket s = server.accept();
                System.out.println("Se ha conectado un cliente al servidor.");
                Scanner leer = new Scanner(s.getInputStream());
                String linea = leer.nextLine();
                PrintWriter enviar = new PrintWriter(s.getOutputStream(),true);
                enviar.println(linea);
                s.close();
                leer.close();
                enviar.close();
                System.out.println("Se ha finalizado la conexión correctamente.");
            }
            
        } catch (Exception e) {
            System.out.println("Se ha producido un error.");
        }
    }
    
}