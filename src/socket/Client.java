package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        try{
            Socket mc_socket = new Socket("127.0.0.1", 8888);

            mc_socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}