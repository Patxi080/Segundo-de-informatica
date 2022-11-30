import java.net.*;
import java.io.*;
public class ClienteTCP1 {
    public static void main(String[] args)throws UnknownHostException,IOException{
        Socket cliente = new Socket("www.upv.es",80);
        System.out.println("Conectado");
        cliente.close();
        System.out.println("Fin de la conexión.");
    }
}
