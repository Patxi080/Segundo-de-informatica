import java.net.*;
import java.io.*;
public class ClienteTCP2 {
    public static void main(String[] args)throws UnknownHostException,IOException{
        Socket cliente = new Socket("wwwupv.es",81);
        System.out.println("Conectado");
        cliente.close();
        System.out.println("Fin de la conexión.");
    }
}
