package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import Main.Main;

public class Server implements ServerInterface{
    Main Ju_Server = Main.Instance;
    ServerSocket s_socket;
    Socket c_socket[] = new Socket[2];
    ServerThread[] th = new ServerThread[2];
    int n_socket = 0;
    boolean ing = true;

    public class ServerThread extends Thread{
        int FirstConnect = 0;
        int index = n_socket;
        byte[] data = new byte[100];
        InputStream in;
        OutputStream out;
        @Override
        public void run() {
            super.run();
            try{
                while(ing){
                    if(FirstConnect == 0){
                        data[0] = (byte)index;
                        th[index].out = c_socket[index].getOutputStream();
                        th[index].out.write(data);
                        FirstConnect = 1;
                        continue;
                    }
                    PullMsg(index);
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void OpenServer()throws IOException{
        s_socket = new ServerSocket(8888);
        new Thread(){
            @Override
            public void run() {
                for(int i = 0; i < 2; i++) Connect();
            }
        }.start();
    }

    public void Connect(){
        try{
            System.out.println("user standby...");
            c_socket[n_socket] = s_socket.accept();
            System.out.println("user " + (n_socket) + " connected!...");
            th[n_socket] = new ServerThread();
            th[n_socket].start();
            n_socket++;
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void PushMsg(int index, String msg){
        try{
            th[index].out = c_socket[index].getOutputStream();
            th[index].out.write(msg.getBytes());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void PullMsg(int index){
        Arrays.fill(th[index].data, (byte)0);
        try{
            th[index].in = c_socket[index].getInputStream();
            th[index].in.read(th[index].data);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        ByteToString(index);
    }

    public void ByteToString(int index){
        String msg = new String(th[index].data);
        System.out.println("Client " + index + ": " + msg);
    }

    public void StoCmsg(int UserNum, String msg){
        PushMsg(UserNum, msg);
    }

    public void BroadCast(String msg){
        for(int i = 0; i < n_socket; i++)
            PushMsg(i, msg);
    }

    public void CloseServer()throws IOException{
        s_socket.close();
    }
}