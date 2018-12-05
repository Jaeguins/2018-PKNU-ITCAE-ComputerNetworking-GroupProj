package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;

public class Client implements ClientInterface {
    Socket c_socket;
    int index; // client num
    boolean ing = true;
    ClientThread th;

    public class  ClientThread extends Thread{
        int FirstConnect = 0;
        byte[] data = new byte[100];
        InputStream in;
        OutputStream out;
        @Override
        public void run() {
            super.run();
            try{
                while (ing){
                    if(FirstConnect == 0){
                        th.in = c_socket.getInputStream();
                        th.in.read(th.data);
                        index = (int)th.data[0];
                        System.out.println("My client num: " + index);
                        FirstConnect = 1;
                        continue;
                    }
                    PullMsg();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void EnterRoom(String ip)throws IOException{
        c_socket = new Socket(ip, 8888);
        th = new ClientThread();
        th.start();
    }

    public void PushMsg(String msg){
        try{
            th.out = c_socket.getOutputStream();
            th.out.write(msg.getBytes());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void PullMsg(){
        Arrays.fill(th.data, (byte)0);
        try{
            th.in = c_socket.getInputStream();
            th.in.read(th.data);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        ByteToString();
    }

    public void ByteToString(){
        String msg = new String(th.data);
        System.out.println("Server: " + msg);
    }

    public void CtoSmsg(String msg){
        PushMsg(msg);
    }

    public void CloseClient()throws IOException{
        c_socket.close();
    }
}