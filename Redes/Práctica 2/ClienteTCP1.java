import java.net.*;
import java.io.*;
public class ClienteTCP1 {
    public static void main(String[] args) throws IOException,UnknownHostException {
        String host = "www.upv.es";
        int port = 80;
        Socket client = new Socket(host,port);
        System.out.println("La conexión ha sido realizada con éxito.");
        client.close();
        System.out.println("Se ha cerrado el socket.");
    } 
}
