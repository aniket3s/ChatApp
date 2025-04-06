import java.net.*;
import java.io.*;

class Server
{
    ServerSocket server;
    Socket socket;
    BufferedReader br ;
    PrintWriter out ;


    // Constructor 

    public Server()
    {
       try {
        server = new ServerSocket(777);
        System.out.println("server is ready to accept connection ");
        System.out.println("waiting ...");
        socket = server.accept();

        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        out = new PrintWriter(socket.getOutputStream());

        startReading();
        startWriting();

       } catch (Exception e) {
         // to handle exception 
         e.printStackTrace();
       }

    }

    public void startReading()
    {
        // give the data after read

        Runnable r1 = () ->{
            System.out.println("reader started ..");

            while (true) {
                String msg = br.readLine();
                if (msg.equals("exit"))
                {
                  System.out.println("client terminated the chat ");
                  break;   
                }
                System.out.println("Client "+msg);
                
            }
        };
    }
    public void startWriting()
    {
        // Thread : user take thte data and send to the client 
        Runnable r2 = () -> {

        };
    }
    public static void main(String[] args) {
        System.out.println("this is server... going to start Server");

        new Server();
    }
}