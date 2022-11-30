import java.net.*;
import java.io.*;
public class Ejercicio_9 {
    public static void main(String[] args) {
        String host = "www.upv.es";
        int port = 80;
        try {
            Socket client = new Socket(host,port);
            System.out.println("Conexion establecida.");
            System.out.println("Direccion IP del host: " + client.getInetAddress());
            System.out.println("Puerto al que el cliente esta conectado: " + client.getPort());
            System.out.println("Direccion IP local: " + client.getLocalAddress());
            System.out.println("Puerto del cliente: " + client.getLocalPort());
            client.close();
            System.out.println("Se ha cerrado el socket.");
        } catch(UnknownHostException e1) {
            System.out.println("Nombre del servidor desconocido.");
        }catch(NoRouteToHostException  e2){
            System.out.println("No es posible realizar la conexion.");
        }catch(IOException e3){
            System.out.println("No se ha podido establecer conexion con el servidor debido a un error en el puerto.");
        }
    } 
}
