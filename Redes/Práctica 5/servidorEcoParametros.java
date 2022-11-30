import java.net.*;
import java.util.Scanner;
import java.io.*;
/**
 * Ejercicio 2
 */
public class servidorEcoParametros {
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
                System.out.println("Parámetros del socketServer");
                System.out.println("---------------------------");
                System.out.println("Dirección IP local del servidor: " + s.getInetAddress());
                System.out.println("- Puerto local del servidor: " + s.getLocalPort());
                System.out.println("- Parámetros del Socket");
                System.out.println("---------------------------");
                System.out.println("- Dirección IP local del cliente " + s.getLocalAddress());
                System.out.println("- Puerto local del cliente: " + s.getLocalPort());
                System.out.println("- Dirección IP del servidor " + s.getInetAddress());
                System.out.println("- Puerto del servidor: " + s.getPort());
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
