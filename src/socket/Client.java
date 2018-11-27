package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class Client {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        try{
            Socket mc_socket = new Socket("127.0.0.1", 8888);

            InputStream in = mc_socket.getInputStream();
            OutputStream out = mc_socket.getOutputStream();

            byte[] rec_b = new byte[100];
            in.read(rec_b);
            String rec = new String(rec_b);
            System.out.println(rec);
            Arrays.fill(rec_b, (byte)0);
            String send;

            while(true){
                System.out.println("Value(연산/값/값/) : ");
                send = sc.nextLine();
                out.write(send.getBytes());;
                in.read(rec_b);
                if(rec_b[0] == (byte)0){
                    break;
                }
                rec = new String(rec_b);
                System.out.println(rec);
            }

            mc_socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}