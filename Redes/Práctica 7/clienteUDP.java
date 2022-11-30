import java.net.*;
import java.io.*;
/*
 * 
 */
public class clienteUDP {
    public static void main(String[] args) {
        int port = 7777;
        String nombre = "Alsonso Quijano\n";
        try {
            System.out.println("Inicio.");
            DatagramSocket cliente = new DatagramSocket(); //Creamos el socket con el puerto por el que enviar el DatagramPacket.
            //Creamos el DatagramPacket con el contenido.
            DatagramPacket paquete = new DatagramPacket(nombre.getBytes(), nombre.getBytes().length, InetAddress.getByName("localhost"),port);
            cliente.send(paquete); //Enviamos el paquete
            System.out.println("Fin.");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Se ha producido un error.");
        }
    }
}
