package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;

public class Client implements ClientInterface {
    Socket c_socket;
    byte[] data = new byte[100];
    String c_msg;
    InputStream in;
    OutputStream out;
    int index; // client num

    public void EnterRoom(String ip)throws IOException{
        c_socket = new Socket(ip, 8888);
        PullMsg();
        index = (int)data[0];
        System.out.println("client num: " + index);
    }

    public void PushMsg(){
        try{
            out = c_socket.getOutputStream();
            out.write(c_msg.getBytes());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void PullMsg(){
        Arrays.fill(data, (byte)0);
        try{
            in = c_socket.getInputStream();
            in.read(data);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        ByteToString();
    }

    public void ByteToString(){
        c_msg = new String(data);
        System.out.println(c_msg);
    }

    public void CtoSmsg(String msg){
        c_msg = msg;
        PushMsg();
    }

    public void CloseClient()throws IOException{
        c_socket.close();
    }
}