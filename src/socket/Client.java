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
    StringBuffer GuiVal = new StringBuffer();

    public void EnterMyself()throws IOException{
        c_socket = new Socket("127.0.0.1", 8888);
    }

    public void EnterRoom(String ip, int port)throws IOException{
        c_socket = new Socket(ip, port);
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