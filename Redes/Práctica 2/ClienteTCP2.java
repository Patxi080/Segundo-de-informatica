import java.net.*;
import java.io.*;

public class ClienteTCP2 {
    public static void main(String[] args) {
        String host = "www.upv.es";
        int port = 80;
        try {
            Socket client = new Socket(host,port);
            System.out.println("La conexión ha sido realizada con éxito.");
            client.close();
            System.out.println("Se ha cerrado el socket.");
        } catch(UnknownHostException e1) {
            System.out.println("No se ha podido establecer la conexión debido a una dirección errónea.");
        }catch(IOException e2){
            System.out.println("No se ha podido establecer conexión con el servidor debido a un error en el puerto.");
        }
    } 
}
