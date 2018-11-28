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
    byte[] b_send, b_rec;
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

    public void GetValue(int x, int y, int LR)throws IOException{
        GuiVal.append(x);
        GuiVal.append('/');
        GuiVal.append(y);
        GuiVal.append('/');
        GuiVal.append(LR);
        GuiVal.append('/');
        send = new String(GuiVal);
        out = c_socket.getOutputStream();
        out.write(send.getBytes());
    }

    public

    public static void main(String[] args)
    {
        try{
            Socket mc_socket = new Socket("127.0.0.1", 8888);

            InputStream in = mc_socket.getInputStream();
            OutputStream out = mc_socket.getOutputStream();
            byte[] rec_b = new byte[100];
            in.read(rec_b);
            String rec =new String(rec_b);
            System.out.println(rec);
            Arrays.fill(rec_b, (byte)0);
            String send;

            while(true){
                System.out.println("두 수를 연산(입력: 연산/값/값/, 탈출: exit/) : ");
                send = sc.nextLine();
                out.write(send.getBytes());;
                in.read(rec_b);
                if(rec_b[0] == (byte)0){
                    break;
                }
                rec = new String(rec_b);
                System.out.println(rec);
                Arrays.fill(rec_b, (byte)0);
            }

            mc_socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}