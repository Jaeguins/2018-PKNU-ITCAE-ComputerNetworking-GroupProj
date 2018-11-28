package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server implements ServerInterface{
    ServerSocket s_socket;
    Socket c_socket;
    byte[] b_send = new byte[100], b_rec = new byte[100];
    String send, rec;
    InputStream in;
    OutputStream out;

    public void OpenServer() throws IOException{
        s_socket = new ServerSocket(8888);
        ServerAccept();
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
        send = "어서오세요! 지뢰매스터에";
        PushMsg();
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
        try{
            in = c_socket.getInputStream();
            in.read(b_rec);;
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void ByteToString(){
        rec = new String(b_rec);
        Arrays.fill(b_rec, (byte)0);
    }
}