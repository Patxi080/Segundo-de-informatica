import java.net.*;
import java.io.*;
import java.util.Scanner;
public class ecoTCP extends Thread {
    Socket id;
    String message;
    public static int numServidores = 0;
    public ecoTCP(Socket s){
        this.id = s;
        this.message = "";
    }
    public void run(){
        try{
            Scanner leer = new Scanner(this.id.getInputStream());
            PrintWriter enviar = new PrintWriter(this.id.getOutputStream(),true);
            while(leer.hasNextLine()){
                this.message = leer.nextLine();
                if(this.message.equalsIgnoreCase("FIN")){break;}
                enviar.println(this.message);
            }
            numServidores--;
            System.out.println("Servidor cerrado.Hay " + numServidores + " servidores restantes.");
            id.close();
        }catch(Exception e){
            System.out.println("Producido un error se ha" + e);
        }
    }
    public static void main(String[] args) throws IOException{
        int port = 7777;
        System.out.println("Encendido.");
        ServerSocket server = new ServerSocket(port); //Crear el servidor
        while(true){
            try{
                Socket s = server.accept(); //Espera a un cliente
                numServidores++;
                System.out.println("Servidor creado.Hay " + numServidores + " servidores");
                ecoTCP t = new ecoTCP(s);
                t.start();
            }catch(Exception e){
                System.out.println("Se ha producido un error." + e);
            }
        }
    }
}
