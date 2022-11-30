import java.net.*;
import java.io.*;
/*
 * El ejercicio pide crear un socket UDP cliente y ver cómo el SO le asigna un puerto diferente con cada ejecución.
 */
public class ejercicio2 {
    public static void main(String[] args) {
        try {
            for(int i = 0; i < 10 ; i++){
                DatagramSocket ds = new DatagramSocket();
                System.out.println("El puerto es: " + ds.getLocalPort() );
                ds.close();
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Se ha producido un error.");
        }
    }
}
