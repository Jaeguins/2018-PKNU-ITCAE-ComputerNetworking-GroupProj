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
    byte[] data = new byte[100];
    String s_msg;
    InputStream in;
    OutputStream out;
    int n_socket = 0;

    public void OpenServer()throws IOException{
        s_socket = new ServerSocket(8888);
        FirstConnecct();
    }

    public void FirstConnecct(){
        try{
            System.out.println("user standby...");
            c_socket[n_socket] = s_socket.accept();
            System.out.println("user " + (n_socket) + " connected!...");
            data[0] = (byte)n_socket;
            out = c_socket[n_socket].getOutputStream();
            out.write(data);
            n_socket++;
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void PushMsg(int index){
        try{
            out = c_socket[index].getOutputStream();
            out.write(s_msg.getBytes());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void PullMsg(){
        Arrays.fill(data, (byte)0);
        try{
            in = c_socket[0].getInputStream();
            in.read(data);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        ByteToString();
    }

    public void ByteToString(){
        s_msg = new String(data);
        System.out.println(s_msg);
    }

    public void StoCmsg(int UserNum, String msg){
        s_msg = msg;
        PushMsg(UserNum);
    }

    public void BroadCast(String msg){
        s_msg = msg;
        for(int i = 0; i < n_socket; i++)
            PushMsg(i);
    }

    public void CloseServer()throws IOException{
        s_socket.close();
    }
}