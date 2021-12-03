package cliente;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
public class CapitalizeClient {
    public static void main(String[] args) throws Exception {
     if(args.length!=1){
         System.err.println("Debes informar la IP del servidor para conectarte");
         return;
     }
     try(Socket socket=new Socket(args[0],59898)){
         System.out.println("Ingresa texto y pulsa enter para pasar a mayusculas.Para salir escribì exit.");
         Scanner scanner=new Scanner(System.in);
         Scanner in=new Scanner(socket.getInputStream());
         PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
         while (scanner.hasNextLine()){
             String text=scanner.nextLine();
             if(text.equals("exit")){break;}
             out.println(text);
             System.out.println(in.nextLine());
         }
     }
    }
}
     