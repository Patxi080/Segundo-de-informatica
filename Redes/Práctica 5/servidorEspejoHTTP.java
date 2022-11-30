import java.net.*;
import java.util.Scanner;
import java.io.*;
/**
 * 
 */
public class servidorEspejoHTTP{
    public static void main(String[] args){
        int port = 8080;
        try{
            ServerSocket ss = new ServerSocket(port);
            while(true){
                Socket server = ss.accept();
                System.out.println("Comunicaciones online.");
                Scanner leer = new Scanner(server.getInputStream());
                String linea = leer.nextLine();
                PrintWriter enviar = new PrintWriter(server.getOutputStream(),true);
                enviar.printf("HTTP/1.0 200 OK \r\n");
               // enviar.printf("Content-Type: text/html \r\n");
               enviar.printf("Content-Type: text \r\n");
                //enviar.printf("\r\n<html><body><h1>");
                enviar.printf("\r\n");
                while(linea.length()!= 0){
                    //enviar.println(linea + "<br>");
                    enviar.println(linea);
                    linea = leer.nextLine();
                }
                System.out.println("Fin de la conexion");
                server.close();
                leer.close();
                enviar.close();
            }
        }catch(Exception e){
            System.out.println("Se ha producido un error.");
        }
    }
}
