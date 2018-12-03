package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class Client implements ClientInterface {
    Scanner sc = new Scanner(System.in);
    Socket c_socket;
    byte[] b_send = new byte[100], b_rec = new byte[100];
    String send, rec;
    InputStream in;
    OutputStream out;
    int index; // 클라이언트 번호

    public class ClientThread extends Thread{
        @Override
        public void run() {
            super.run();
            while(true){
                PullMsg();
            }
        }
    }

    public void EnterMyself()throws IOException{
        c_socket = new Socket("127.0.0.1", 8888);
        try{
            in = c_socket.getInputStream();
            in.read(b_rec);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        index = (int)b_rec[0];
        System.out.println("클라이언트번호: " + index);
        ClientThread th = new ClientThread();
        th.start();
    }

    public void EnterRoom(String ip, int port)throws IOException{
        c_socket = new Socket(ip, port);
    }

    public void PushMsg(){
        try{
            out = c_socket.getOutputStream();
            out.write(send.getBytes());;
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void PullMsg(){
        Arrays.fill(b_rec, (byte)0);
        try{
            in = c_socket.getInputStream();
            in.read(b_rec);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        ByteToString();
    }

    public void ByteToString(){
        rec = new String(b_rec);
        System.out.println(rec);
    }

    public void CloseClinet()throws IOException{
        c_socket.close();
    }
}