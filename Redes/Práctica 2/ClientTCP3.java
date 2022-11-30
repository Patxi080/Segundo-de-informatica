import java.net.*;
import java.io.*;
public class ClientTCP3 {
    public static void main(String[] args) {
        String host = "www.upv.es";
        int port = 8;
        try {
            Socket client = new Socket(host,port);
            System.out.println("¡Conectado de nuevo!");
            client.close();
            System.out.println("Se ha cerrado el socket.");
        } catch(UnknownHostException e1) {
            System.out.println("Nombre del servidor desconocido.");
        }catch(NoRouteToHostException  e2){
            System.out.println("No es posible realizar la conexión.");
        }catch(IOException e3){
            System.out.println("No se ha podido establecer conexión con el servidor debido a un error en el puerto.");

        }
    } 
}
