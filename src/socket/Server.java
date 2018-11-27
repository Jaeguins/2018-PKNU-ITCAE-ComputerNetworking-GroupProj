package socket;

import game.test;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args)
    {
        try{
            ServerSocket ms_socket = new ServerSocket(8888);
            System.out.println("네트워크 접속대기중...\n");
            Socket mc_socket = ms_socket.accept();
            System.out.println("연결 완료!\n");

            InputStream in = mc_socket.getInputStream();
            OutputStream out = mc_socket.getOutputStream();

            String send = "어서오세요 지뢰매스터에!";
            out.write(send.getBytes());;
            byte[] rec_b = new byte[100];
            String rec;
            int a, b;

            do{
                in.read(rec_b);
                rec = new String(rec_b);
                String moon[] = rec.split("/");
                if(moon[0].equals("add")){
                    send =  test.gob(1, 1);
                }
            }

            ms_socket.close();
            mc_socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}