import java.net.*;
import java.io.*;
public class ClienteTCP4 {
    public static void main(String[] args)throws UnknownHostException,IOException{
        final int PORT = 80;
        final String IP = "www.upv.es"; 
        try{
            for(int i = 0; i < 4; i++){
                InetAddress dirIP = InetAddress.getByName(IP);
                Socket cliente = new Socket(dirIP,PORT);
                System.out.println("Sistemas online.");
                System.out.println("Estadísticas: ");
                System.out.println("- Puerto remoto: " + cliente.getPort());
                System.out.println("- Dirección IP remota: " + cliente.getInetAddress());
                System.out.println("- Puerto local: " + cliente.getLocalPort());
                System.out.println("- Dirección IP local: " + cliente.getLocalAddress());
                cliente.close();
                System.out.println("Fin de la conexión.");
                System.out.println();
            }
        }catch(UnknownHostException e1){
            System.out.println("Error 1. Nombre de servidor desconocido");    
        }catch(IOException e2){
            System.out.println("Error 2. No es posible realizar conexión");
        }
    }
}
