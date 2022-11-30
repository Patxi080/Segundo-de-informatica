import java.net.*;
import java.io.*;
import java.util.*;
public class daytime {
    public static void main(String[] args) {
        int port = 7777;    
        try {
            DatagramSocket server = new DatagramSocket(port);
            byte[] buffer = new byte[1000];
            DatagramPacket paquete = new DatagramPacket(buffer, 1000);
            System.out.println("Esperando paquete.");
            server.receive(paquete);
            System.out.println("Se ha recibido un paquete.");
            System.out.println("Enviando respuesta.");
            //Código para enviar el mensaje
            int clienPort = paquete.getPort();
            InetAddress address = paquete.getAddress();
                //Obtenemos la hora
            Date now = new Date();
            String now_string = now.toString() + "\r\n";
                //Cambiamos los atributos del paquete recibido
            paquete.setData(now_string.getBytes());
            paquete.setLength(now_string.length());
                //Enviamos el paquete
            server.send(paquete);
            System.out.println("Respuesta enviada.");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Se ha producido un error.");
        } 
    }
    
}
