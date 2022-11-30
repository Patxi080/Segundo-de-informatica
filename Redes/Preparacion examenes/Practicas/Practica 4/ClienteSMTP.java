import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ClienteSMTP {
    static void error(String cadena) {
        System.out.println(cadena);
        System.exit(0);
    }
        public static void main(String args[]) {
        try{
            System.setProperty ("line.separator","\r\n");
            Socket s=new Socket("serveis-rdc.redes.upv.es", 25);
            System.out.println("Conectado al servidor SMTP de serveis-rdc");
            PrintWriter salida = new PrintWriter(s.getOutputStream());
            Scanner entrada=new Scanner(s.getInputStream());
            String respuesta = entrada.nextLine();
            System.out.println(respuesta);
            if (!respuesta.startsWith("220")) {error(respuesta);}
    
                salida.println("HELO javier.goerlich@gmail.com");
                salida.flush();
                respuesta = entrada.nextLine();
                System.out.println(respuesta);
            if (!respuesta.startsWith("250")) {error(respuesta);}
    
                salida.println("MAIL FROM:<javier.goerlich@gmail.com>");
                salida.flush();
                respuesta = entrada.nextLine();
                System.out.println(respuesta);
            if (!respuesta.startsWith("250")) {error(respuesta);}
    
                salida.println("RCPT TO:<redes01@redes.upv.es>");
                salida.flush();
                respuesta = entrada.nextLine();
                System.out.println(respuesta);
            if (!respuesta.startsWith("250")) {error(respuesta);}
    
                salida.println("DATA");
                salida.flush();
                respuesta = entrada.nextLine();
                System.out.println(respuesta);
            if (!respuesta.startsWith("354")) {error(respuesta);}
    
            // **completar** 
            // Aqui van varios println con todo el correo 
            // electronico incluidas las cabeceras
                salida.println("Subject: hola mundo");
               // salida.flush();
                salida.println("From: javier.goerlich@gmail.com");
                //salida.flush();
                salida.println("To: redes01@redes.upv.es");
                //salida.flush();
                salida.println(".Hey, te envio esto desde un programa de java para ver si funciona.");
                //salida.println(".");
                salida.println("Ya me dices si esto ha funcionado.");
               // salida.flush();
                salida.println("Nos vemos mañana. Bss.");
                salida.println(".");
    
                salida.flush();
                respuesta = entrada.nextLine();
                System.out.println(respuesta);
            if (!respuesta.startsWith("250")) {error(respuesta);}
    
                salida.println("QUIT");
                salida.flush();
                respuesta = entrada.nextLine();
                System.out.println(respuesta);
            if (!respuesta.startsWith("221")) {error(respuesta);}
    
                s.close();
                System.out.println("Desconectado");
    
        } catch (UnknownHostException e) {
            System.out.println("Host desconocido");
            System.out.println(e);
        } catch (IOException e) {
            System.out.println("No se puede conectar");
            System.out.println(e);
        }
    }
}
