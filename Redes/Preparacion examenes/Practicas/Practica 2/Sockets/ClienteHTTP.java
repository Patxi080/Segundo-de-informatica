import java.net.*;
import java.util.Scanner;
import java.io.*;
public class ClienteHTTP{
    public static void main(String[] args){
        final int PORT = 80;
        final String DIR = "www.upv.es";
        final String GET = "GET / HTTP/1.0\r\n\r\n";
        try{
            System.setProperty("line.spearator", "\r\n");
            InetAddress dirIP = InetAddress.getByName(DIR);
            Socket cliente = new Socket(dirIP, PORT);
            Scanner s = new Scanner(cliente.getInputStream());
            PrintWriter p = new PrintWriter(cliente.getOutputStream(),true);
            p.println(GET);
            System.out.println("Peticion GET enviada.");
            System.out.println("Mensaje recibido.");
            while (s.hasNextLine()) {
                System.out.println(s.nextLine());
            }
            
        }catch(Exception e){
            System.out.println("Error.");
        }
    }
}
