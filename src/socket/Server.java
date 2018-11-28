package socket;

import game.test;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements ServerInterface{
    ServerSocket s_socket;
    Socket c_socket;
    InputStream in;
    OutputStream out;

    public void OpenServer() throws IOException{
        s_socket = new ServerSocket(8888);
    }

    public void ServerAccept(){
        try{
            System.out.println("네트워크 접속대기중...");
            c_socket = s_socket.accept();
            System.out.println("연결 완료!");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        ServerSocket s_socket;
        Socket[] c_socket;

        try{
            ServerSocket ms_socket = new ServerSocket(8888);
            System.out.println("네트워크 접속대기중...");
            Socket mc_socket = ms_socket.accept();
            System.out.println("연결 완료!");

            InputStream in = mc_socket.getInputStream();
            OutputStream out = mc_socket.getOutputStream();

            String send = "어서오세요 지뢰매스터에!";
            out.write(send.getBytes());
            out.flush();
            byte[] rec_b = new byte[100];
            String rec;

            while(true){
                in.read(rec_b);
                rec = new String(rec_b);
                String[] moon = rec.split("/");
                if(moon[0].equals("add")){
                    send = test.gob(Integer.parseInt(moon[1]), Integer.parseInt(moon[2])) + "";
                }
                else if(moon[0].equals("exit")){
                    break;
                }
                else{
                    send = "잘못된 입력입니다!";
                }
                out.write(send.getBytes());;
            }

            byte[] end = {0};
            out.write(end);
            System.out.println("연결 종료!");
            ms_socket.close();
            mc_socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}