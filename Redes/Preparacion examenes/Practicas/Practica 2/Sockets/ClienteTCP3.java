import java.net.*;
import java.io.*;
public class ClienteTCP3 {
    public static void main(String[] args)throws UnknownHostException,IOException{
        try{
            Socket cliente = new Socket("www.upv.es",80);
            System.out.println("¡Conectado de nuevo!");
            cliente.close();
            System.out.println("Fin de la conexión.");
        }catch(UnknownHostException e1){
            System.out.println("Error 1. Nombre de servidor desconocido");    
        }catch(IOException e2){
            System.out.println("Error 2. No es posible realizar conexión");
        }
    }
}
