import java.net.*;
import java.util.Scanner;
import java.io.*;

public class chat extends Thread{
    Socket id;
    String message = "";
    
    public chat(Socket s){
        this.id = s;
    }
    public void run(){
        
    }
    public static void main(String[] args){
        int port = 7777;
        try{
            System.out.println("Encendido");
            ServerSocket server = new ServerSocket(port);
            Scanner leer;
            while(true){
                  Socket d = server.accept();
                  System.out.println("Servidor conectado.");
                  chat t = new chat(d);
                  t.start();
                  leer = new Scanner(d.getInputStream());
            }
            
        }catch(Exception e){
            System.out.println("Se ha producido un error." + e);
        }
    }
}
