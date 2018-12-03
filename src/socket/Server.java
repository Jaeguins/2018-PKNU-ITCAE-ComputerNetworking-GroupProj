package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server implements ServerInterface{
    ServerSocket s_socket;
    Socket c_socket[] = new Socket[4];
    Socket sc_socket;
    byte[] b_send = new byte[100], b_rec = new byte[100];
    String send, rec;
    InputStream in;
    OutputStream out;
    int n_socket = 0;

    public class ServerThread extends Thread{
        int i = 0;
        @Override
        public void run() {
            super.run();
            while(true) {
                if (i < 2) {
                    FirstConnecct();
                    i++;
                    continue;
                }
                break;
            }
        }
    }

    public class ServerThread2 extends Thread{
        @Override
        public void run() {
            super.run();
            while(true){
                PullMsg();
                if(rec.equals("end"))
                    break;
            }
        }
    }

    public void OpenServer()throws IOException{
        s_socket = new ServerSocket(8888);
        ServerThread th = new ServerThread();
        th.start();
        ServerThread2 th2 = new ServerThread2();
        th2.start();
    }

    public void FirstConnecct(){
        try{
            System.out.println("유저 접속대기중...");
            c_socket[n_socket] = s_socket.accept();
            System.out.println("유저 " + (n_socket + 1) + " 접속완료!...");
            b_send[0] = (byte)n_socket;
            out = c_socket[n_socket].getOutputStream();
            out.write(b_send);
            n_socket++;
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void PushMsg(int index){
        try{
            out = c_socket[index].getOutputStream();
            out.write(send.getBytes());;
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void PullMsg(){
        Arrays.fill(b_rec, (byte)0);
        try{
            in = sc_socket.getInputStream();
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

    public void StoCmsg(int UserNum, String msg){
        send = msg;
        PushMsg(UserNum);
    }

    public void BroadCast(String msg){
        send = "서버 알림: " + msg;
        for(int i = 0; i < n_socket; i++)
            PushMsg(i);
    }

    public void CloseServer()throws IOException{
        s_socket.close();
    }
}