import java.net.*;
import java.io.*;
import java.util.Scanner;


import java.io.PrintWriter;
public class ClienteHTTP {
    public static void main(String[] args) {
        int port = 80;
        String host = "www.upv.es";
        System.setProperty("line.separator", "\r\n");
        String mensaje = "GET / HTTP/1.0\r\n\r\n";
        try {
            Socket client = new Socket(host,port);
            Scanner scan = new Scanner(client.getInputStream());
            PrintWriter enviar = new PrintWriter(client.getOutputStream(),true);
            System.out.println("Socket, scanner y printwriter online.");
            enviar.println(mensaje);
            System.out.println("Mensaje enviado.");
            System.out.println("Mensaje recibido: " + scan.nextLine());
            client.close();
            scan.close();
            enviar.close();
            System.out.println("Socket, scanner y printwriter offline.");
            
        } catch (UnknownHostException e) {
            System.out.println("El host no existe.");
        }catch(NoRouteToHostException e2){
            System.out.println("No se encuentra el puerto o no está disponible.");
        }catch(IOException e3){
            System.out.println("Hau una excepción I/O desconocida.");
        }
    }
}
